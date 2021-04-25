package io.itch.awesomekalin.noob.objects.items;

import io.itch.awesomekalin.noob.Main;
import io.itch.awesomekalin.noob.init.ItemInit;
import io.itch.awesomekalin.noob.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.NOOB_TAB);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
