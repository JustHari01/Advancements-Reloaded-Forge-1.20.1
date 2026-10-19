package net.mcjamweasel.moarconcrete.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mcjamweasel.moarconcrete.MoarConcrete;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

//Stairs functions.
    public static final Block WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            new StairsBlock(Blocks.WHITE_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE)));

    public static final Block LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    public static final Block GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            new StairsBlock(Blocks.GRAY_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE)));

    public static final Block BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            new StairsBlock(Blocks.BLACK_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE)));

    public static final Block BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            new StairsBlock(Blocks.BROWN_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE)));

    public static final Block RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            new StairsBlock(Blocks.RED_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.RED_CONCRETE)));

    public static final Block ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            new StairsBlock(Blocks.ORANGE_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE)));

    public static final Block YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            new StairsBlock(Blocks.YELLOW_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE)));

    public static final Block LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            new StairsBlock(Blocks.LIME_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE)));

    public static final Block GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            new StairsBlock(Blocks.GREEN_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE)));

    public static final Block CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            new StairsBlock(Blocks.CYAN_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            new StairsBlock(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    public static final Block BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            new StairsBlock(Blocks.BLUE_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE)));

    public static final Block PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            new StairsBlock(Blocks.PURPLE_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            new StairsBlock(Blocks.MAGENTA_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE)));

    public static final Block PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            new StairsBlock(Blocks.PINK_CONCRETE.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));


//Slab functions.
    public static final Block WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
        new SlabBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE)));

    public static final Block LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    public static final Block GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE)));

    public static final Block BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE)));

    public static final Block BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE)));

    public static final Block RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE)));

    public static final Block ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE)));

    public static final Block YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE)));

    public static final Block LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE)));

    public static final Block GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE)));

    public static final Block CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    public static final Block BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE)));

    public static final Block PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE)));

    public static final Block PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));


//Wall functions.
    public static final Block WHITE_CONCRETE_WALL = registerBlock("white_concrete_wall",
        new WallBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE)));

    public static final Block LIGHT_GRAY_CONCRETE_WALL = registerBlock("light_gray_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE)));

    public static final Block GRAY_CONCRETE_WALL = registerBlock("gray_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE)));

    public static final Block BLACK_CONCRETE_WALL = registerBlock("black_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE)));

    public static final Block BROWN_CONCRETE_WALL = registerBlock("brown_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE)));

    public static final Block RED_CONCRETE_WALL = registerBlock("red_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE)));

    public static final Block ORANGE_CONCRETE_WALL = registerBlock("orange_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE)));

    public static final Block YELLOW_CONCRETE_WALL = registerBlock("yellow_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE)));

    public static final Block LIME_CONCRETE_WALL = registerBlock("lime_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE)));

    public static final Block GREEN_CONCRETE_WALL = registerBlock("green_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE)));

    public static final Block CYAN_CONCRETE_WALL = registerBlock("cyan_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_WALL = registerBlock("light_blue_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE)));

    public static final Block BLUE_CONCRETE_WALL = registerBlock("blue_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE)));

    public static final Block PURPLE_CONCRETE_WALL = registerBlock("purple_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_WALL = registerBlock("magenta_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE)));

    public static final Block PINK_CONCRETE_WALL = registerBlock("pink_concrete_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));


//Fence & Gate functions.
    public static final Block WHITE_CONCRETE_FENCE = registerBlock("white_concrete_fence",
        new FenceBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE)));
    public static final Block WHITE_CONCRETE_GATE = registerBlock("white_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE), WoodType.MANGROVE));

    public static final Block LIGHT_GRAY_CONCRETE_FENCE = registerBlock("light_gray_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_GATE = registerBlock("light_gray_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE), WoodType.MANGROVE));

    public static final Block GRAY_CONCRETE_FENCE = registerBlock("gray_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE)));
    public static final Block GRAY_CONCRETE_GATE = registerBlock("gray_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE), WoodType.MANGROVE));

    public static final Block BLACK_CONCRETE_FENCE = registerBlock("black_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE)));
    public static final Block BLACK_CONCRETE_GATE = registerBlock("black_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE), WoodType.MANGROVE));

    public static final Block BROWN_CONCRETE_FENCE = registerBlock("brown_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE)));
    public static final Block BROWN_CONCRETE_GATE = registerBlock("brown_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE), WoodType.MANGROVE));

    public static final Block RED_CONCRETE_FENCE = registerBlock("red_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE)));
    public static final Block RED_CONCRETE_GATE = registerBlock("red_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE), WoodType.MANGROVE));

    public static final Block ORANGE_CONCRETE_FENCE = registerBlock("orange_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE)));
    public static final Block ORANGE_CONCRETE_GATE = registerBlock("orange_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE), WoodType.MANGROVE));

    public static final Block YELLOW_CONCRETE_FENCE = registerBlock("yellow_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE)));
    public static final Block YELLOW_CONCRETE_GATE = registerBlock("yellow_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE), WoodType.MANGROVE));

    public static final Block LIME_CONCRETE_FENCE = registerBlock("lime_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE)));
    public static final Block LIME_CONCRETE_GATE = registerBlock("lime_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE), WoodType.MANGROVE));

    public static final Block GREEN_CONCRETE_FENCE = registerBlock("green_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE)));
    public static final Block GREEN_CONCRETE_GATE = registerBlock("green_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE), WoodType.MANGROVE));

    public static final Block CYAN_CONCRETE_FENCE = registerBlock("cyan_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE)));
    public static final Block CYAN_CONCRETE_GATE = registerBlock("cyan_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE), WoodType.MANGROVE));

    public static final Block LIGHT_BLUE_CONCRETE_FENCE = registerBlock("light_blue_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_GATE = registerBlock("light_blue_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE), WoodType.MANGROVE));

    public static final Block BLUE_CONCRETE_FENCE = registerBlock("blue_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE)));
    public static final Block BLUE_CONCRETE_GATE = registerBlock("blue_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE), WoodType.MANGROVE));

    public static final Block PURPLE_CONCRETE_FENCE = registerBlock("purple_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE)));
    public static final Block PURPLE_CONCRETE_GATE = registerBlock("purple_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE), WoodType.MANGROVE));

    public static final Block MAGENTA_CONCRETE_FENCE = registerBlock("magenta_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_GATE = registerBlock("magenta_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE), WoodType.MANGROVE));

    public static final Block PINK_CONCRETE_FENCE = registerBlock("pink_concrete_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block PINK_CONCRETE_GATE = registerBlock("pink_concrete_gate",
            new FenceGateBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE), WoodType.MANGROVE));

//Button functions
    public static final Block WHITE_CONCRETE_BUTTON = registerBlock("white_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block LIGHT_GRAY_CONCRETE_BUTTON = registerBlock("light_gray_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block GRAY_CONCRETE_BUTTON = registerBlock("gray_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block BLACK_CONCRETE_BUTTON = registerBlock("black_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block BROWN_CONCRETE_BUTTON = registerBlock("brown_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block RED_CONCRETE_BUTTON = registerBlock("red_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block ORANGE_CONCRETE_BUTTON = registerBlock("orange_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block YELLOW_CONCRETE_BUTTON = registerBlock("yellow_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block LIME_CONCRETE_BUTTON = registerBlock("lime_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block GREEN_CONCRETE_BUTTON = registerBlock("green_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block CYAN_CONCRETE_BUTTON = registerBlock("cyan_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block LIGHT_BLUE_CONCRETE_BUTTON = registerBlock("light_blue_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block BLUE_CONCRETE_BUTTON = registerBlock("blue_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block PURPLE_CONCRETE_BUTTON = registerBlock("purple_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block MAGENTA_CONCRETE_BUTTON = registerBlock("magenta_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE), BlockSetType.STONE, 10, false));

    public static final Block PINK_CONCRETE_BUTTON = registerBlock("pink_concrete_button",
            new ButtonBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE), BlockSetType.STONE, 10, false));


//Panel functions
   //public static final Block WHITE_CONCRETE_PANEL = registerBlock("white_concrete_panel",
     //       new PaneBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE)));

//Panel functions. Need one texture block and one panel block for each colour. The texture block is only used to set the texture for the panel, it is not available as a block in game.

    public static final Block WHITE_CONCRETE_TEXTURE = registerBlock("white_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block WHITE_CONCRETE_PANEL = registerBlock("white_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));


    public static final Block LIGHT_GRAY_CONCRETE_TEXTURE = registerBlock("light_gray_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block LIGHT_GRAY_CONCRETE_PANEL = registerBlock("light_gray_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block GRAY_CONCRETE_TEXTURE = registerBlock("gray_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block GRAY_CONCRETE_PANEL = registerBlock("gray_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BLACK_CONCRETE_TEXTURE = registerBlock("black_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block BLACK_CONCRETE_PANEL = registerBlock("black_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BROWN_CONCRETE_TEXTURE = registerBlock("brown_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block BROWN_CONCRETE_PANEL = registerBlock("brown_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block RED_CONCRETE_TEXTURE = registerBlock("red_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block RED_CONCRETE_PANEL = registerBlock("red_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block ORANGE_CONCRETE_TEXTURE = registerBlock("orange_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block ORANGE_CONCRETE_PANEL = registerBlock("orange_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block YELLOW_CONCRETE_TEXTURE = registerBlock("yellow_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block YELLOW_CONCRETE_PANEL = registerBlock("yellow_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIME_CONCRETE_TEXTURE = registerBlock("lime_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block LIME_CONCRETE_PANEL = registerBlock("lime_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block GREEN_CONCRETE_TEXTURE = registerBlock("green_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block GREEN_CONCRETE_PANEL = registerBlock("green_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block CYAN_CONCRETE_TEXTURE = registerBlock("cyan_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block CYAN_CONCRETE_PANEL = registerBlock("cyan_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_TEXTURE = registerBlock("light_blue_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block LIGHT_BLUE_CONCRETE_PANEL = registerBlock("light_blue_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BLUE_CONCRETE_TEXTURE = registerBlock("blue_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block BLUE_CONCRETE_PANEL = registerBlock("blue_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block PURPLE_CONCRETE_TEXTURE = registerBlock("purple_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block PURPLE_CONCRETE_PANEL = registerBlock("purple_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_TEXTURE = registerBlock("magenta_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block MAGENTA_CONCRETE_PANEL = registerBlock("magenta_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block PINK_CONCRETE_TEXTURE = registerBlock("pink_concrete_texture",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));
    public static final Block PINK_CONCRETE_PANEL = registerBlock("pink_concrete_panel",
            new PaneBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    // Colored concrete bricks.
    public static final Block WHITE_CONCRETE_BRICKS = registerBlock("white_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIGHT_GRAY_CONCRETE_BRICKS = registerBlock("light_gray_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block GRAY_CONCRETE_BRICKS = registerBlock("gray_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BLACK_CONCRETE_BRICKS = registerBlock("black_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BROWN_CONCRETE_BRICKS = registerBlock("brown_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block RED_CONCRETE_BRICKS = registerBlock("red_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block ORANGE_CONCRETE_BRICKS = registerBlock("orange_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block YELLOW_CONCRETE_BRICKS = registerBlock("yellow_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIME_CONCRETE_BRICKS = registerBlock("lime_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block GREEN_CONCRETE_BRICKS = registerBlock("green_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block CYAN_CONCRETE_BRICKS = registerBlock("cyan_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_BRICKS = registerBlock("light_blue_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BLUE_CONCRETE_BRICKS = registerBlock("blue_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block PURPLE_CONCRETE_BRICKS = registerBlock("purple_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_BRICKS = registerBlock("magenta_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block PINK_CONCRETE_BRICKS = registerBlock("pink_concrete_bricks",
            new Block(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    // Slabs for the colored concrete bricks.
    public static final Block WHITE_CONCRETE_BRICK_SLAB = registerBlock("white_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIGHT_GRAY_CONCRETE_BRICK_SLAB = registerBlock("light_gray_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block GRAY_CONCRETE_BRICK_SLAB = registerBlock("gray_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BLACK_CONCRETE_BRICK_SLAB = registerBlock("black_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BROWN_CONCRETE_BRICK_SLAB = registerBlock("brown_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block RED_CONCRETE_BRICK_SLAB = registerBlock("red_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block ORANGE_CONCRETE_BRICK_SLAB = registerBlock("orange_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block YELLOW_CONCRETE_BRICK_SLAB = registerBlock("yellow_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIME_CONCRETE_BRICK_SLAB = registerBlock("lime_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block GREEN_CONCRETE_BRICK_SLAB = registerBlock("green_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block CYAN_CONCRETE_BRICK_SLAB = registerBlock("cyan_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block LIGHT_BLUE_CONCRETE_BRICK_SLAB = registerBlock("light_blue_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block BLUE_CONCRETE_BRICK_SLAB = registerBlock("blue_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block PURPLE_CONCRETE_BRICK_SLAB = registerBlock("purple_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block MAGENTA_CONCRETE_BRICK_SLAB = registerBlock("magenta_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

    public static final Block PINK_CONCRETE_BRICK_SLAB = registerBlock("pink_concrete_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE)));

//Registry methods
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MoarConcrete.MOD_ID, name), block);
    }


    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(MoarConcrete.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


//Add an entry for each block to add the block to the creative menu coloured blocks category.
    private static void addBLockToGroup(FabricItemGroupEntries entries){

        entries.add(WHITE_CONCRETE_STAIRS);
        entries.add(WHITE_CONCRETE_SLAB);
        entries.add(WHITE_CONCRETE_WALL);
        entries.add(WHITE_CONCRETE_FENCE);
        entries.add(WHITE_CONCRETE_GATE);
        entries.add(WHITE_CONCRETE_PANEL);

        entries.add(LIGHT_GRAY_CONCRETE_STAIRS);
        entries.add(LIGHT_GRAY_CONCRETE_SLAB);
        entries.add(LIGHT_GRAY_CONCRETE_WALL);
        entries.add(LIGHT_GRAY_CONCRETE_FENCE);
        entries.add(LIGHT_GRAY_CONCRETE_GATE);

        entries.add(GRAY_CONCRETE_STAIRS);
        entries.add(GRAY_CONCRETE_SLAB);
        entries.add(GRAY_CONCRETE_WALL);
        entries.add(GRAY_CONCRETE_FENCE);
        entries.add(GRAY_CONCRETE_GATE);

        entries.add(BLACK_CONCRETE_STAIRS);
        entries.add(BLACK_CONCRETE_SLAB);
        entries.add(BLACK_CONCRETE_WALL);
        entries.add(BLACK_CONCRETE_FENCE);
        entries.add(BLACK_CONCRETE_GATE);

        entries.add(BROWN_CONCRETE_STAIRS);
        entries.add(BROWN_CONCRETE_SLAB);
        entries.add(BROWN_CONCRETE_WALL);
        entries.add(BROWN_CONCRETE_FENCE);
        entries.add(BROWN_CONCRETE_GATE);

        entries.add(RED_CONCRETE_STAIRS);
        entries.add(RED_CONCRETE_SLAB);
        entries.add(RED_CONCRETE_WALL);
        entries.add(RED_CONCRETE_FENCE);
        entries.add(RED_CONCRETE_GATE);

        entries.add(ORANGE_CONCRETE_STAIRS);
        entries.add(ORANGE_CONCRETE_SLAB);
        entries.add(ORANGE_CONCRETE_WALL);
        entries.add(ORANGE_CONCRETE_FENCE);
        entries.add(ORANGE_CONCRETE_GATE);

        entries.add(YELLOW_CONCRETE_STAIRS);
        entries.add(YELLOW_CONCRETE_SLAB);
        entries.add(YELLOW_CONCRETE_WALL);
        entries.add(YELLOW_CONCRETE_FENCE);
        entries.add(YELLOW_CONCRETE_GATE);

        entries.add(LIME_CONCRETE_STAIRS);
        entries.add(LIME_CONCRETE_SLAB);
        entries.add(LIME_CONCRETE_WALL);
        entries.add(LIME_CONCRETE_FENCE);
        entries.add(LIME_CONCRETE_GATE);

        entries.add(GREEN_CONCRETE_STAIRS);
        entries.add(GREEN_CONCRETE_SLAB);
        entries.add(GREEN_CONCRETE_WALL);
        entries.add(GREEN_CONCRETE_FENCE);
        entries.add(GREEN_CONCRETE_GATE);

        entries.add(CYAN_CONCRETE_STAIRS);
        entries.add(CYAN_CONCRETE_SLAB);
        entries.add(CYAN_CONCRETE_WALL);
        entries.add(CYAN_CONCRETE_FENCE);
        entries.add(CYAN_CONCRETE_GATE);

        entries.add(LIGHT_BLUE_CONCRETE_STAIRS);
        entries.add(LIGHT_BLUE_CONCRETE_SLAB);
        entries.add(LIGHT_BLUE_CONCRETE_WALL);
        entries.add(LIGHT_BLUE_CONCRETE_FENCE);
        entries.add(LIGHT_BLUE_CONCRETE_GATE);

        entries.add(BLUE_CONCRETE_STAIRS);
        entries.add(BLUE_CONCRETE_SLAB);
        entries.add(BLUE_CONCRETE_WALL);
        entries.add(BLUE_CONCRETE_FENCE);
        entries.add(BLUE_CONCRETE_GATE);

        entries.add(PURPLE_CONCRETE_STAIRS);
        entries.add(PURPLE_CONCRETE_SLAB);
        entries.add(PURPLE_CONCRETE_WALL);
        entries.add(PURPLE_CONCRETE_FENCE);
        entries.add(PURPLE_CONCRETE_GATE);

        entries.add(MAGENTA_CONCRETE_STAIRS);
        entries.add(MAGENTA_CONCRETE_SLAB);
        entries.add(MAGENTA_CONCRETE_WALL);
        entries.add(MAGENTA_CONCRETE_GATE);
        entries.add(MAGENTA_CONCRETE_FENCE);

        entries.add(PINK_CONCRETE_STAIRS);
        entries.add(PINK_CONCRETE_SLAB);
        entries.add(PINK_CONCRETE_WALL);
        entries.add(PINK_CONCRETE_FENCE);
        entries.add(PINK_CONCRETE_GATE);
        entries.add(LIGHT_GRAY_CONCRETE_PANEL);
        entries.add(GRAY_CONCRETE_PANEL);
        entries.add(BLACK_CONCRETE_PANEL);
        entries.add(BROWN_CONCRETE_PANEL);
        entries.add(RED_CONCRETE_PANEL);
        entries.add(ORANGE_CONCRETE_PANEL);
        entries.add(YELLOW_CONCRETE_PANEL);
        entries.add(LIME_CONCRETE_PANEL);
        entries.add(GREEN_CONCRETE_PANEL);
        entries.add(CYAN_CONCRETE_PANEL);
        entries.add(LIGHT_BLUE_CONCRETE_PANEL);
        entries.add(BLUE_CONCRETE_PANEL);
        entries.add(PURPLE_CONCRETE_PANEL);
        entries.add(MAGENTA_CONCRETE_PANEL);
        entries.add(PINK_CONCRETE_PANEL);
        entries.add(WHITE_CONCRETE_BRICKS);
        entries.add(LIGHT_GRAY_CONCRETE_BRICKS);
        entries.add(GRAY_CONCRETE_BRICKS);
        entries.add(BLACK_CONCRETE_BRICKS);
        entries.add(BROWN_CONCRETE_BRICKS);
        entries.add(RED_CONCRETE_BRICKS);
        entries.add(ORANGE_CONCRETE_BRICKS);
        entries.add(YELLOW_CONCRETE_BRICKS);
        entries.add(LIME_CONCRETE_BRICKS);
        entries.add(GREEN_CONCRETE_BRICKS);
        entries.add(CYAN_CONCRETE_BRICKS);
        entries.add(LIGHT_BLUE_CONCRETE_BRICKS);
        entries.add(BLUE_CONCRETE_BRICKS);
        entries.add(PURPLE_CONCRETE_BRICKS);
        entries.add(MAGENTA_CONCRETE_BRICKS);
        entries.add(PINK_CONCRETE_BRICKS);
        entries.add(WHITE_CONCRETE_BRICK_SLAB);
        entries.add(LIGHT_GRAY_CONCRETE_BRICK_SLAB);
        entries.add(GRAY_CONCRETE_BRICK_SLAB);
        entries.add(BLACK_CONCRETE_BRICK_SLAB);
        entries.add(BROWN_CONCRETE_BRICK_SLAB);
        entries.add(RED_CONCRETE_BRICK_SLAB);
        entries.add(ORANGE_CONCRETE_BRICK_SLAB);
        entries.add(YELLOW_CONCRETE_BRICK_SLAB);
        entries.add(LIME_CONCRETE_BRICK_SLAB);
        entries.add(GREEN_CONCRETE_BRICK_SLAB);
        entries.add(CYAN_CONCRETE_BRICK_SLAB);
        entries.add(LIGHT_BLUE_CONCRETE_BRICK_SLAB);
        entries.add(BLUE_CONCRETE_BRICK_SLAB);
        entries.add(PURPLE_CONCRETE_BRICK_SLAB);
        entries.add(MAGENTA_CONCRETE_BRICK_SLAB);
        entries.add(PINK_CONCRETE_BRICK_SLAB);
    }


//Add an entry for each block to add the block to the creative menu redstone blocks category.
    private static void addButtonToGroup(FabricItemGroupEntries entries){

    //Buttons
        entries.add(WHITE_CONCRETE_BUTTON);
        entries.add(LIGHT_GRAY_CONCRETE_BUTTON);
        entries.add(GRAY_CONCRETE_BUTTON);
        entries.add(BLACK_CONCRETE_BUTTON);
        entries.add(BROWN_CONCRETE_BUTTON);
        entries.add(RED_CONCRETE_BUTTON);
        entries.add(ORANGE_CONCRETE_BUTTON);
        entries.add(YELLOW_CONCRETE_BUTTON);
        entries.add(LIME_CONCRETE_BUTTON);
        entries.add(GREEN_CONCRETE_BUTTON);
        entries.add(CYAN_CONCRETE_BUTTON);
        entries.add(LIGHT_BLUE_CONCRETE_BUTTON);
        entries.add(BLUE_CONCRETE_BUTTON);
        entries.add(PURPLE_CONCRETE_BUTTON);
        entries.add(MAGENTA_CONCRETE_BUTTON);
        entries.add(PINK_CONCRETE_BUTTON);
    }


//Registers the blocks to the creative menus.
    public static void registerModBlocks(){
        MoarConcrete.LOGGER.info("Registering ModBlocks for " + MoarConcrete.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(ModBlocks::addBLockToGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(ModBlocks::addButtonToGroup);
    }
}
