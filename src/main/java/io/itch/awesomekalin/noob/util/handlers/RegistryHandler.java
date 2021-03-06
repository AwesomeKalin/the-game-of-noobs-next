package io.itch.awesomekalin.noob.util.handlers;

import io.itch.awesomekalin.noob.Main;
import io.itch.awesomekalin.noob.init.BlockInit;
import io.itch.awesomekalin.noob.init.ItemInit;
import io.itch.awesomekalin.noob.objects.blocks.noob_chest.RenderNoobChest;
import io.itch.awesomekalin.noob.objects.blocks.noob_chest.TileEntityNoobChest;
import io.itch.awesomekalin.noob.util.IHasModel;
import io.itch.awesomekalin.noob.world.generation.WorldGenerationOre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
        TileEntityHandler.registerTileEntities();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNoobChest.class, new RenderNoobChest());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
        for (Block block : BlockInit.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

    public static void initRegistries(FMLPreInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.INSTANCE, new GuiHandler());
        GameRegistry.registerWorldGenerator(new WorldGenerationOre(), 0);
    }
}
