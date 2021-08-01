package io.itch.awesomekalin.noob.objects.items.food;

import io.itch.awesomekalin.noob.Main;
import io.itch.awesomekalin.noob.init.ItemInit;
import io.itch.awesomekalin.noob.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCustomFood extends ItemFood implements IHasModel {
    public ItemCustomFood(String name, int amount, boolean isWolfFood) {
        super(amount, isWolfFood);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.NOOB_TAB);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if(!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 60, 5, false, false));
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 60, 5, false, false));
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 60, 5, false, false));
        }
    }
}
