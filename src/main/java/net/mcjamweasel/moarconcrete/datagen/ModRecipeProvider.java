package net.mcjamweasel.moarconcrete.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mcjamweasel.moarconcrete.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }


//Creates the recipes for each block, one set per colour.
//Stone cutting for stairs, slabs, walls.
//Crafting table for all.
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

    //White
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_STAIRS, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_SLAB, Blocks.WHITE_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_SLAB, Blocks.WHITE_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_WALL, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_WALL, Blocks.WHITE_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.WHITE_CONCRETE_STAIRS, Items.WHITE_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.WHITE_CONCRETE_FENCE, Items.WHITE_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.WHITE_CONCRETE_GATE, Items.WHITE_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.WHITE_CONCRETE_BUTTON, Items.WHITE_CONCRETE);
        offerStainedGlassPaneRecipe(exporter, ModBlocks.WHITE_CONCRETE_PANEL, Blocks.WHITE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_CONCRETE_PANEL, Blocks.WHITE_CONCRETE, 4);

    //Light Gray
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, Blocks.LIGHT_GRAY_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB, Blocks.LIGHT_GRAY_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_WALL, Blocks.LIGHT_GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_CONCRETE_WALL, Blocks.LIGHT_GRAY_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS, Items.LIGHT_GRAY_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.LIGHT_GRAY_CONCRETE_FENCE, Items.LIGHT_GRAY_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.LIGHT_GRAY_CONCRETE_GATE, Items.LIGHT_GRAY_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.LIGHT_GRAY_CONCRETE_BUTTON, Items.LIGHT_GRAY_CONCRETE);

    //Gray
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_STAIRS, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_SLAB, Blocks.GRAY_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_SLAB, Blocks.GRAY_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_WALL, Blocks.GRAY_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_CONCRETE_WALL, Blocks.GRAY_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.GRAY_CONCRETE_STAIRS, Items.GRAY_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.GRAY_CONCRETE_FENCE, Items.GRAY_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.GRAY_CONCRETE_GATE, Items.GRAY_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.GRAY_CONCRETE_BUTTON, Items.GRAY_CONCRETE);

    //Black
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_STAIRS, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_SLAB, Blocks.BLACK_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_SLAB, Blocks.BLACK_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_WALL, Blocks.BLACK_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_CONCRETE_WALL, Blocks.BLACK_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.BLACK_CONCRETE_STAIRS, Items.BLACK_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.BLACK_CONCRETE_FENCE, Items.BLACK_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.BLACK_CONCRETE_GATE, Items.BLACK_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.BLACK_CONCRETE_BUTTON, Items.BLACK_CONCRETE);

    //Brown
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_STAIRS, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_SLAB, Blocks.BROWN_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_SLAB, Blocks.BROWN_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_WALL, Blocks.BROWN_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_CONCRETE_WALL, Blocks.BROWN_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.BROWN_CONCRETE_STAIRS, Items.BROWN_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.BROWN_CONCRETE_FENCE, Items.BROWN_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.BROWN_CONCRETE_GATE, Items.BROWN_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.BROWN_CONCRETE_BUTTON, Items.BROWN_CONCRETE);

    //Red
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_STAIRS, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_SLAB, Blocks.RED_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_SLAB, Blocks.RED_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_WALL, Blocks.RED_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_CONCRETE_WALL, Blocks.RED_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.RED_CONCRETE_STAIRS, Items.RED_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.RED_CONCRETE_FENCE, Items.RED_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.RED_CONCRETE_GATE, Items.RED_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.RED_CONCRETE_BUTTON, Items.RED_CONCRETE);

    //Orange
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_STAIRS, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_SLAB, Blocks.ORANGE_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_SLAB, Blocks.ORANGE_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_WALL, Blocks.ORANGE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_CONCRETE_WALL, Blocks.ORANGE_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.ORANGE_CONCRETE_STAIRS, Items.ORANGE_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.ORANGE_CONCRETE_FENCE, Items.ORANGE_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.ORANGE_CONCRETE_GATE, Items.ORANGE_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.ORANGE_CONCRETE_BUTTON, Items.ORANGE_CONCRETE);

    //Yellow
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_STAIRS, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_SLAB, Blocks.YELLOW_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_SLAB, Blocks.YELLOW_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_WALL, Blocks.YELLOW_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_CONCRETE_WALL, Blocks.YELLOW_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.YELLOW_CONCRETE_STAIRS, Items.YELLOW_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.YELLOW_CONCRETE_FENCE, Items.YELLOW_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.YELLOW_CONCRETE_GATE, Items.YELLOW_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.YELLOW_CONCRETE_BUTTON, Items.YELLOW_CONCRETE);

    //Lime
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_STAIRS, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_SLAB, Blocks.LIME_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_SLAB, Blocks.LIME_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_WALL, Blocks.LIME_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_CONCRETE_WALL, Blocks.LIME_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.LIME_CONCRETE_STAIRS, Items.LIME_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.LIME_CONCRETE_FENCE, Items.LIME_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.LIME_CONCRETE_GATE, Items.LIME_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.LIME_CONCRETE_BUTTON, Items.LIME_CONCRETE);

    //Green
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_STAIRS, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_SLAB, Blocks.GREEN_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_SLAB, Blocks.GREEN_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_WALL, Blocks.GREEN_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_CONCRETE_WALL, Blocks.GREEN_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.GREEN_CONCRETE_STAIRS, Items.GREEN_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.GREEN_CONCRETE_FENCE, Items.GREEN_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.GREEN_CONCRETE_GATE, Items.GREEN_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.GREEN_CONCRETE_BUTTON, Items.GREEN_CONCRETE);

    //Cyan
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_STAIRS, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_SLAB, Blocks.CYAN_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_SLAB, Blocks.CYAN_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_WALL, Blocks.CYAN_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_CONCRETE_WALL, Blocks.CYAN_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.CYAN_CONCRETE_STAIRS, Items.CYAN_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.CYAN_CONCRETE_FENCE, Items.CYAN_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.CYAN_CONCRETE_GATE, Items.CYAN_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.CYAN_CONCRETE_BUTTON, Items.CYAN_CONCRETE);

    //Light Blue
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, Blocks.LIGHT_BLUE_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB, Blocks.LIGHT_BLUE_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_WALL, Blocks.LIGHT_BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_CONCRETE_WALL, Blocks.LIGHT_BLUE_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS, Items.LIGHT_BLUE_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.LIGHT_BLUE_CONCRETE_FENCE, Items.LIGHT_BLUE_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.LIGHT_BLUE_CONCRETE_GATE, Items.LIGHT_BLUE_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.LIGHT_BLUE_CONCRETE_BUTTON, Items.LIGHT_BLUE_CONCRETE);

    //Blue
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_STAIRS, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_SLAB, Blocks.BLUE_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_SLAB, Blocks.BLUE_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_WALL, Blocks.BLUE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_CONCRETE_WALL, Blocks.BLUE_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.BLUE_CONCRETE_STAIRS, Items.BLUE_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.BLUE_CONCRETE_FENCE, Items.BLUE_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.BLUE_CONCRETE_GATE, Items.BLUE_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.BLUE_CONCRETE_BUTTON, Items.BLUE_CONCRETE);

    //Purple
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_STAIRS, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_SLAB, Blocks.PURPLE_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_SLAB, Blocks.PURPLE_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_WALL, Blocks.PURPLE_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_CONCRETE_WALL, Blocks.PURPLE_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.PURPLE_CONCRETE_STAIRS, Items.PURPLE_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.PURPLE_CONCRETE_FENCE, Items.PURPLE_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.PURPLE_CONCRETE_GATE, Items.PURPLE_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.PURPLE_CONCRETE_BUTTON, Items.PURPLE_CONCRETE);

    //Magenta
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_STAIRS, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_SLAB, Blocks.MAGENTA_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_SLAB, Blocks.MAGENTA_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_WALL, Blocks.MAGENTA_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_CONCRETE_WALL, Blocks.MAGENTA_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.MAGENTA_CONCRETE_STAIRS, Items.MAGENTA_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.MAGENTA_CONCRETE_FENCE, Items.MAGENTA_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.MAGENTA_CONCRETE_GATE, Items.MAGENTA_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.MAGENTA_CONCRETE_BUTTON, Items.MAGENTA_CONCRETE);

    //Pink
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_STAIRS, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_SLAB, Blocks.PINK_CONCRETE, 2);
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_SLAB, Blocks.PINK_CONCRETE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_WALL, Blocks.PINK_CONCRETE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_CONCRETE_WALL, Blocks.PINK_CONCRETE);
        concreteStairRecipe(exporter, ModBlocks.PINK_CONCRETE_STAIRS, Items.PINK_CONCRETE);
        concreteFenceRecipe(exporter, ModBlocks.PINK_CONCRETE_FENCE, Items.PINK_CONCRETE);
        concreteGateRecipe(exporter, ModBlocks.PINK_CONCRETE_GATE, Items.PINK_CONCRETE);
        concreteButtonRecipe(exporter, ModBlocks.PINK_CONCRETE_BUTTON, Items.PINK_CONCRETE);
        Block[] vanillaConcrete = {
                Blocks.WHITE_CONCRETE,
                Blocks.LIGHT_GRAY_CONCRETE,
                Blocks.GRAY_CONCRETE,
                Blocks.BLACK_CONCRETE,
                Blocks.BROWN_CONCRETE,
                Blocks.RED_CONCRETE,
                Blocks.ORANGE_CONCRETE,
                Blocks.YELLOW_CONCRETE,
                Blocks.LIME_CONCRETE,
                Blocks.GREEN_CONCRETE,
                Blocks.CYAN_CONCRETE,
                Blocks.LIGHT_BLUE_CONCRETE,
                Blocks.BLUE_CONCRETE,
                Blocks.PURPLE_CONCRETE,
                Blocks.MAGENTA_CONCRETE,
                Blocks.PINK_CONCRETE,
        };
        Block[] concretePanels = {
                ModBlocks.WHITE_CONCRETE_PANEL,
                ModBlocks.LIGHT_GRAY_CONCRETE_PANEL,
                ModBlocks.GRAY_CONCRETE_PANEL,
                ModBlocks.BLACK_CONCRETE_PANEL,
                ModBlocks.BROWN_CONCRETE_PANEL,
                ModBlocks.RED_CONCRETE_PANEL,
                ModBlocks.ORANGE_CONCRETE_PANEL,
                ModBlocks.YELLOW_CONCRETE_PANEL,
                ModBlocks.LIME_CONCRETE_PANEL,
                ModBlocks.GREEN_CONCRETE_PANEL,
                ModBlocks.CYAN_CONCRETE_PANEL,
                ModBlocks.LIGHT_BLUE_CONCRETE_PANEL,
                ModBlocks.BLUE_CONCRETE_PANEL,
                ModBlocks.PURPLE_CONCRETE_PANEL,
                ModBlocks.MAGENTA_CONCRETE_PANEL,
                ModBlocks.PINK_CONCRETE_PANEL,
        };
        Block[] concreteBricks = {
                ModBlocks.WHITE_CONCRETE_BRICKS,
                ModBlocks.LIGHT_GRAY_CONCRETE_BRICKS,
                ModBlocks.GRAY_CONCRETE_BRICKS,
                ModBlocks.BLACK_CONCRETE_BRICKS,
                ModBlocks.BROWN_CONCRETE_BRICKS,
                ModBlocks.RED_CONCRETE_BRICKS,
                ModBlocks.ORANGE_CONCRETE_BRICKS,
                ModBlocks.YELLOW_CONCRETE_BRICKS,
                ModBlocks.LIME_CONCRETE_BRICKS,
                ModBlocks.GREEN_CONCRETE_BRICKS,
                ModBlocks.CYAN_CONCRETE_BRICKS,
                ModBlocks.LIGHT_BLUE_CONCRETE_BRICKS,
                ModBlocks.BLUE_CONCRETE_BRICKS,
                ModBlocks.PURPLE_CONCRETE_BRICKS,
                ModBlocks.MAGENTA_CONCRETE_BRICKS,
                ModBlocks.PINK_CONCRETE_BRICKS,
        };
        Block[] concreteBrickSlabs = {
                ModBlocks.WHITE_CONCRETE_BRICK_SLAB,
                ModBlocks.LIGHT_GRAY_CONCRETE_BRICK_SLAB,
                ModBlocks.GRAY_CONCRETE_BRICK_SLAB,
                ModBlocks.BLACK_CONCRETE_BRICK_SLAB,
                ModBlocks.BROWN_CONCRETE_BRICK_SLAB,
                ModBlocks.RED_CONCRETE_BRICK_SLAB,
                ModBlocks.ORANGE_CONCRETE_BRICK_SLAB,
                ModBlocks.YELLOW_CONCRETE_BRICK_SLAB,
                ModBlocks.LIME_CONCRETE_BRICK_SLAB,
                ModBlocks.GREEN_CONCRETE_BRICK_SLAB,
                ModBlocks.CYAN_CONCRETE_BRICK_SLAB,
                ModBlocks.LIGHT_BLUE_CONCRETE_BRICK_SLAB,
                ModBlocks.BLUE_CONCRETE_BRICK_SLAB,
                ModBlocks.PURPLE_CONCRETE_BRICK_SLAB,
                ModBlocks.MAGENTA_CONCRETE_BRICK_SLAB,
                ModBlocks.PINK_CONCRETE_BRICK_SLAB,
        };

        for (int i = 1; i < vanillaConcrete.length; i++) {
            offerStainedGlassPaneRecipe(exporter, concretePanels[i], vanillaConcrete[i]);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                    concretePanels[i], vanillaConcrete[i], 4);
        }

        for (int i = 0; i < vanillaConcrete.length; i++) {
            concreteBricksRecipe(exporter, concreteBricks[i], vanillaConcrete[i]);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                    concreteBricks[i], vanillaConcrete[i]);
            offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                    concreteBrickSlabs[i], vanillaConcrete[i]);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS,
                    concreteBrickSlabs[i], vanillaConcrete[i], 2);
        }
    }


//Function to create concrete brick recipes.
    public static void concreteBricksRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("CC")
                .pattern("CC")
                .input('C', Ingredient.ofItems(input))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }


//Function to create stair recipes for concrete. Makes the recipe builder code less complex.
    public static void concreteStairRecipe (Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                .pattern("C  ")
                .pattern("CC ")
                .pattern("CCC")
                .input('C', Ingredient.ofItems(input))
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }


//Function to create fence recipes for concrete. Makes the recipe builder code less complex.
    public static void concreteFenceRecipe (Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 3)
                .pattern("CIC")
                .pattern("CIC")
                .pattern("   ")
                .input('C', Ingredient.ofItems(input))
                .input('I', Ingredient.ofItems(Items.IRON_BARS))
                .criterion(hasItem(input), conditionsFromItem(input))
                .criterion(hasItem(Items.IRON_BARS), conditionsFromItem(Items.IRON_BARS))
                .offerTo(exporter);
    }


//Function to create fence gate recipes for concrete. Makes the recipe builder code less complex.
    public static void concreteGateRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 1)
                .pattern("ICI")
                .pattern("ICI")
                .pattern("   ")
                .input('C', Ingredient.ofItems(input))
                .input('I', Ingredient.ofItems(Items.IRON_BARS))
                .criterion(hasItem(input), conditionsFromItem(input))
                .criterion(hasItem(Items.IRON_BARS), conditionsFromItem(Items.IRON_BARS))
                .offerTo(exporter);
    }


//Function to create button recipes for concrete. Makes the recipe builder code less complex.
    public static void concreteButtonRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output, 1)
                .input(input)
                .group("concrete_buttons")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
}
