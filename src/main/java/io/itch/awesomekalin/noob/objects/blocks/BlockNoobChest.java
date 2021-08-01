package io.itch.awesomekalin.noob.objects.blocks;

import io.itch.awesomekalin.noob.Main;
import io.itch.awesomekalin.noob.Reference;
import io.itch.awesomekalin.noob.init.BlockInit;
import io.itch.awesomekalin.noob.init.ItemInit;
import io.itch.awesomekalin.noob.objects.blocks.noob_chest.TileEntityNoobChest;
import io.itch.awesomekalin.noob.util.IHasModel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNoobChest extends BlockContainer implements IHasModel {
    public BlockNoobChest(String name){
        super(Material.SPONGE);
        setSoundType(SoundType.SLIME);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.NOOB_TAB);
        setHardness(1F);
        setResistance(10F);
        setLightLevel(0F);
        setLightOpacity(255);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        playerIn.openGui(Main.INSTANCE, Reference.GUI_NOOB_CHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if(stack.hasDisplayName()){
            TileEntity te = worldIn.getTileEntity(pos);

            if(te instanceof TileEntityNoobChest){
                ((TileEntityNoobChest)te).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityNoobChest();
    }
}
