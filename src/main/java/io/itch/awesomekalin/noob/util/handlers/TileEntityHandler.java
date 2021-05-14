package io.itch.awesomekalin.noob.util.handlers;

import io.itch.awesomekalin.noob.objects.blocks.noob_chest.TileEntityNoobChest;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityNoobChest.class, new ResourceLocation("noob:noob_chest"));
    }
}
