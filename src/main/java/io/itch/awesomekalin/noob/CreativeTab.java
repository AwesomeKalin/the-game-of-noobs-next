package io.itch.awesomekalin.noob;

import io.itch.awesomekalin.noob.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
    public CreativeTab(){
        super("The Game of Noobs");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(ItemInit.NOOB_DUST);
    }
}
