package io.itch.awesomekalin.noob.init;

import io.itch.awesomekalin.noob.objects.blocks.BlockBase;
import io.itch.awesomekalin.noob.objects.blocks.BlockNoobChest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    // Regular block
    public static final Block NOOB_BLOCK = new BlockBase("noob_block", Material.IRON);
    public static final Block NOOB_ORE = new BlockBase("noob_ore", Material.ROCK);

    // Chests
    public static final Block NOOB_CHEST = new BlockNoobChest("noob_chest");
}
