package io.itch.awesomekalin.noob.objects.items.tools;

import io.itch.awesomekalin.noob.Main;
import io.itch.awesomekalin.noob.init.ItemInit;
import io.itch.awesomekalin.noob.util.IHasModel;
import net.minecraft.item.ItemHoe;

public class ToolHoeBase extends ItemHoe implements IHasModel {
    public ToolHoeBase(String name, ToolMaterial material)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.NOOB_TAB);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
