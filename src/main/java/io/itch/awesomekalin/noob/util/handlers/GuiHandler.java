package io.itch.awesomekalin.noob.util.handlers;

import io.itch.awesomekalin.noob.Reference;
import io.itch.awesomekalin.noob.objects.blocks.noob_chest.ContainerNoobChest;
import io.itch.awesomekalin.noob.objects.blocks.noob_chest.GuiNoobChest;
import io.itch.awesomekalin.noob.objects.blocks.noob_chest.TileEntityNoobChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_NOOB_CHEST){
            return new ContainerNoobChest(player.inventory, (TileEntityNoobChest)world.getTileEntity(new BlockPos(x,y,z)), player);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == Reference.GUI_NOOB_CHEST){
            return new GuiNoobChest(player.inventory, (TileEntityNoobChest)world.getTileEntity(new BlockPos(x,y,z)), player);
        }
        return null;
    }

}
