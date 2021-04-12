package io.itch.awesomekalin.noob.objects.items.tools;

import io.itch.awesomekalin.noob.Main;
import io.itch.awesomekalin.noob.init.ItemInit;
import io.itch.awesomekalin.noob.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ToolShovelBase extends ItemSpade implements IHasModel {
    public ToolShovelBase(String name, ToolMaterial material)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
