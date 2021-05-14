package io.itch.awesomekalin.noob.objects.blocks.noob_chest;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiNoobChest extends GuiContainer {
    private static final ResourceLocation GUI_CHEST = new ResourceLocation("noob:textures/gui/noob_chest.png");
    private final InventoryPlayer playerInv;
    private final TileEntityNoobChest te;

    public GuiNoobChest(InventoryPlayer playerInv, TileEntityNoobChest chestInventory, EntityPlayer player) {
        super(new ContainerNoobChest(playerInv, chestInventory, player));
        this.playerInv = playerInv;
        this.te = chestInventory;

        this.xSize=176;
        this.ySize=166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 0, 0, 000000);
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 0, this.ySize-92, 000000);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
}
