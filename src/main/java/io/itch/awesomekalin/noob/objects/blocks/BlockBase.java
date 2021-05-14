package io.itch.awesomekalin.noob.objects.blocks;

import io.itch.awesomekalin.noob.Main;
import io.itch.awesomekalin.noob.init.BlockInit;
import io.itch.awesomekalin.noob.init.ItemInit;
import io.itch.awesomekalin.noob.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.NOOB_TAB);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
