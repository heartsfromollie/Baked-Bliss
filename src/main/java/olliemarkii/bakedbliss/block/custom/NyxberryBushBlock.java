package olliemarkii.bakedbliss.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

public class NyxberryBushBlock extends SweetBerryBushBlock {
    public NyxberryBushBlock(Properties settings) {
        super(settings);
    }


    //? if <=1.21.1 {
    /*@Override
    public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(BakedBlissItems.NYXBERRIES);
    }
    *///? } else {
    @Override
    protected ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean bl) {
        return BakedBlissItems.NYXBERRIES.getDefaultInstance();
    }
    //? }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        int i = state.getValue(AGE);
        boolean bl = i == 3;
        if (i > 1) {
            int j = 1 + world.getRandom().nextInt(2);
            popResource(world, pos, new ItemStack(BakedBlissItems.NYXBERRIES, j + (bl ? 1 : 0)));
            world.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + world.getRandom().nextFloat() * 0.4F);
            BlockState blockState = state.setValue(AGE, 1);
            world.setBlock(pos, blockState, Block.UPDATE_CLIENTS);
            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
            //? if <=1.21.1 {
            /*return InteractionResult.sidedSuccess(world.isClientSide());
            *///? } else {
            return InteractionResult.SUCCESS;
            //? }
        } else {
            return super.useWithoutItem(state, world, pos, player, hit);
        }
    }
}
