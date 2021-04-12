package io.itch.awesomekalin.noob.init;

import io.itch.awesomekalin.noob.objects.items.ItemBase;
import io.itch.awesomekalin.noob.objects.items.MudShovel;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item NOOB_DUST = new ItemBase("noob_dust");
    public static final Item MUD_SHOVEL_TOP = new MudShovel("mud_shovel_top");
    public static final Item MUD_SHOVEL_BOTTOM = new MudShovel("mud_shovel_bottom");
}
