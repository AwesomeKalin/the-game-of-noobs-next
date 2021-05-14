package io.itch.awesomekalin.noob.objects.blocks.noob_chest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerNoobChest extends Container {
    private final TileEntityNoobChest chestInventory;

    public ContainerNoobChest(InventoryPlayer playerInv, TileEntityNoobChest chestInventory, EntityPlayer player) {
        this.chestInventory = chestInventory;
        chestInventory.openInventory(player);

        this.addSlotToContainer(new Slot(chestInventory, 0, 15, 50));
        this.addSlotToContainer(new Slot(chestInventory, 1, 150, 50));

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 70 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 128));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.chestInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        chestInventory.closeInventory(playerIn);
    }

    public TileEntityNoobChest getChestInventory() {
        return this.chestInventory;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        return itemstack;
    }
}
