package io.itch.awesomekalin.noob.init;

import io.itch.awesomekalin.noob.objects.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block NOOB_BLOCK = new BlockBase("noob_block", Material.IRON);
}
