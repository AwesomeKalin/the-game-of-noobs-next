package io.itch.awesomekalin.noob.objects.blocks.noob_chest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public class TileEntityNoobChest extends TileEntityLockableLoot implements ITickable {

    private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(2, ItemStack.EMPTY);

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : this.chestContents){
            if(!stack.isEmpty()){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.noob_chest";
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.chestContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if(!this.checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, chestContents);
        if(compound.hasKey("CustomName", 8)) this.customName = compound.getString("CustomName");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        if(!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, chestContents);
        if(compound.hasKey("CustomName", 8)) compound.setString("CustomName", this.customName);

        return compound;
    }

    @Override
    public int getInventoryStackLimit() {
        return 3;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerNoobChest(playerInventory, this, playerIn);
    }

    @Override
    public String getGuiID() {
        return "noob:noob_chest";
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    public void update() {

    }

    @Override
    public void openInventory(EntityPlayer player) {
        this.world.addBlockEvent(pos, this.getBlockType(), 1, 1);
        this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
        this.world.addBlockEvent(pos, this.getBlockType(), 1, 0);
        this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
    }
}
