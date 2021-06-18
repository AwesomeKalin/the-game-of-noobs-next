package io.itch.awesomekalin.noob.world.generation;

import io.itch.awesomekalin.noob.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenerationOre implements IWorldGenerator {
    private WorldGenerator noob_ore;
    private WorldGenerator noob_ore_grass;
    private WorldGenerator noob_ore_dirt;
    private WorldGenerator noob_chest;
    private WorldGenerator noob_chest_grass;
    private WorldGenerator noob_chest_dirt;

    public WorldGenerationOre(){
        noob_ore = new WorldGenMinable(BlockInit.NOOB_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
        noob_ore_grass = new WorldGenMinable(BlockInit.NOOB_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.GRASS));
        noob_ore_dirt = new WorldGenMinable(BlockInit.NOOB_ORE.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.DIRT));
        noob_chest = new WorldGenMinable(BlockInit.NOOB_CHEST.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
        noob_chest_grass = new WorldGenMinable(BlockInit.NOOB_CHEST.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.GRASS));
        noob_chest_dirt = new WorldGenMinable(BlockInit.NOOB_CHEST.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.DIRT));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension())
        {
            case -1:

                //runGenerator(copper_ore_nether, world, random, chunkX, chunkZ, 50, 0, 100);

                break;

            case 0:

                runGenerator(noob_ore, world, random, chunkX, chunkZ, 90, 0, 255);
                // runGenerator(noob_ore_grass, world, random, chunkX, chunkZ, 90, 0, 255);
                // runGenerator(noob_ore_dirt, world, random, chunkX, chunkZ, 90, 0, 255);
                runGenerator(noob_chest, world, random, chunkX, chunkZ, 85, 0, 255);
                runGenerator(noob_chest_grass, world, random, chunkX, chunkZ, 85, 0, 255);
                runGenerator(noob_chest_dirt, world, random, chunkX, chunkZ, 85, 0, 255);

                break;

            case 1:

                //runGenerator(copper_ore_end, world, random, chunkX, chunkZ, 50, 0, 256);
        }
    }
    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
    {
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;
        for(int i = 0; i < chance; i++)
        {
            int x = chunkX * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunkZ * 16 + rand.nextInt(16);

            gen.generate(world, rand, new BlockPos(x,y,z));
        }
    }
}
