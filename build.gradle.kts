plugins {
    alias(libs.plugins.loom)
}

class ModData {
    val id = property("mod.id").toString()
    val name = property("mod.name")
    val version = property("mod.version")
    val group = property("mod.group").toString()
    val description = property("mod.description")
    val source = property("mod.source")
    val issues = property("mod.issues")
    val license = property("mod.license").toString()
    val modrinth = property("mod.modrinth")
    val curseforge = property("mod.curseforge")
    val discord = property("mod.discord")
}

class Dependencies {
    val fabricLoaderVersion = property("deps.fabric_loader_version")
    val fabricApiVersion = property("deps.fabric_api_version")
}

class LoaderData {
    val loader = loom.platform.get().name.lowercase()
    val isFabric = loader == "fabric"
    val isNeoforge = loader == "neoforge"
}

class McData {
    val version = property("mod.mc_version")
    val dep = property("mod.mc_dep").toString()
}

val mc = McData()
val mod = ModData()
val deps = Dependencies()
val loader = LoaderData()

version = "${mod.version}+${mc.version}-${loader.loader}"
group = mod.group
base { archivesName.set(mod.id) }

stonecutter {
    constants["fabric"] = loader.isFabric
    constants["neoforge"] = loader.isNeoforge
}

loom {
    silentMojangMappingsLicense()

    runConfigs.all {
        ideConfigGenerated(stonecutter.current.isActive)
        runDir =
            "../../run" // This sets the run folder for all mc versions to the same folder. Remove this line if you want individual run folders.
    }

    runConfigs.remove(runConfigs["server"]) // Removes server run configs
}

loom.runs {
    afterEvaluate {
        val mixinJarFile = configurations.runtimeClasspath.get().incoming.artifactView {
            componentFilter {
                it is ModuleComponentIdentifier && it.group == "net.fabricmc" && it.module == "sponge-mixin"
            }
        }.files.first()

        configureEach {
            vmArg("-javaagent:$mixinJarFile") // Mixin Hotswap doesn't work on NeoForge, but doesn't hurt to keep

            property("mixin.hotSwap", "true")
            property("mixin.debug.export", "true") // Puts mixin outputs in /run/.mixin.out
        }
    }
}

repositories {
    maven("https://maven.parchmentmc.org") // Parchment
    maven("https://maven.terraformersmc.com") // Mod Menu
    maven("https://maven.nucleoid.xyz/") // Placeholder API - required by Mod Menu
    maven("https://maven.neoforged.net/releases") // NeoForge
    maven("https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1") // DevAuth
    maven("https://maven.bawnorton.com/releases") // MixinSquared
    maven("https://api.modrinth.com/maven") // Modrinth
}

dependencies {
    minecraft("com.mojang:minecraft:${mc.version}")

    @Suppress("UnstableApiUsage")
    mappings(loom.layered {
        // Mojmap mappings
        officialMojangMappings()

        // Parchment mappings (it adds parameter mappings & javadoc)
        optionalProp("deps.parchment_version") {
            parchment("org.parchmentmc.data:parchment-${mc.version}:$it@zip")
        }
    })

    if (loader.isFabric) {
        modImplementation("net.fabricmc:fabric-loader:${deps.fabricLoaderVersion}")!!
        modImplementation("net.fabricmc.fabric-api:fabric-api:${deps.fabricApiVersion}")
        if (project.hasProperty("deps.modmenu_version")) {
            modImplementation("com.terraformersmc:modmenu:${property("deps.modmenu_version")}")
        }
    }
}

java {
    // withSourcesJar() // Uncomment if you want sources
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.gradle.jvm.tasks.Jar>().configureEach {
    from(rootProject.file("LICENSE")) {
        into("META-INF/licenses/optiboxes")
        rename { "GPL-3.0-Minecraft-Linking-Exception.txt" }
    }
    from(rootProject.file("ORIGINAL_LICENSE")) {
        into("META-INF/licenses/optiboxes")
        rename { "MIT-AMereBagatelle.txt" }
    }
}

tasks.processResources {
    val props = buildMap {
        put("id", mod.id)
        put("name", mod.name)
        put("version", mod.version)
        put("mcdep", mc.dep)
        put("description", mod.description)
        put("source", mod.source)
        put("issues", mod.issues)
        put("license", mod.license)
        put("modrinth", mod.modrinth)
        put("curseforge", mod.curseforge)
        put("discord", mod.discord)
        if (loader.isFabric) {
            put("fabric_loader_version", deps.fabricLoaderVersion)
        }

    }

    props.forEach(inputs::property)

    filesMatching("**/lang/en_us.json") { // Defaults description to English translation
        expand(props)
        filteringCharset = "UTF-8"
    }

    if (loader.isFabric) {
        filesMatching("fabric.mod.json") { expand(props) }
        exclude(listOf("META-INF/neoforge.mods.toml"))
    }

}

if (stonecutter.current.isActive) {
    rootProject.tasks.register("buildActive") {
        group = "project"
        dependsOn(tasks.named("build"))
    }
}

fun <T> optionalProp(property: String, block: (String) -> T?): T? =
    findProperty(property)?.toString()?.takeUnless { it.isBlank() }?.let(block)
