package io.itch.awesomekalin.noob.init;

import io.itch.awesomekalin.noob.objects.items.ItemBase;
import io.itch.awesomekalin.noob.objects.items.tools.*;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item NOOB_DUST = new ItemBase("noob_dust");
    public static final Item MUD_SHOVEL_TOP = new MudShovel("mud_shovel_top");
    public static final Item MUD_SHOVEL_BOTTOM = new MudShovel("mud_shovel_bottom");

    public static final Item.ToolMaterial MUD_TOOL = EnumHelper.addToolMaterial("mud_tool", 1, 100, 0.5f, 0.7f, 5);
    public static final Item.ToolMaterial NOOB_TOOL = EnumHelper.addToolMaterial("noob_tool", 2, 150, 0.7f, 1.0f, 7);

    public static final Item MUD_AXE = new ToolAxeBase("mud_axe", MUD_TOOL);
    public static final Item MUD_HOE = new ToolHoeBase("mud_hoe", MUD_TOOL);
    public static final Item MUD_PICKAXE = new ToolPickaxeBase("mud_pickaxe", MUD_TOOL);
    public static final Item MUD_SHOVEL = new ToolShovelBase("mud_shovel", MUD_TOOL);
    public static final Item MUD_SWORD = new ToolSwordBase("mud_sword", MUD_TOOL);

    public static final Item NOOB_AXE = new ToolAxeBase("noob_axe", NOOB_TOOL);
    public static final Item NOOB_HOE = new ToolHoeBase("noob_hoe", NOOB_TOOL);
    public static final Item NOOB_PICKAXE = new ToolPickaxeBase("noob_pickaxe", NOOB_TOOL);
    public static final Item NOOB_SHOVEL = new ToolShovelBase("noob_shovel", NOOB_TOOL);
    public static final Item NOOB_SWORD = new ToolSwordBase("noob_sword", NOOB_TOOL);
}
