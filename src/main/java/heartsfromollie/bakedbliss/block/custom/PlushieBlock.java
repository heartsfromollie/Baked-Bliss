package heartsfromollie.bakedbliss.block.custom;

import heartsfromollie.bakedbliss.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class PlushieBlock extends Block implements Waterloggable {
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);

    public PlushieBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            world.playSound(
                    null,
                    pos,
                    ModSounds.OLLIE_SQUEAL,
                    SoundCategory.BLOCKS,
                    1f,
                    1f
            );
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!world.isClient) {
            world.playSound(
                    null,
                    pos,
                    ModSounds.OLLIE_SQUEAL,
                    SoundCategory.BLOCKS,
                    1f,
                    1f
            );
        }
    }
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient) {
            world.playSound(
                    null,
                    pos,
                    ModSounds.OLLIE_SQUEAL,
                    SoundCategory.BLOCKS,
                    1f,
                    1f
            );
        }
    }
    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return true;
    }


    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (!world.isClient()) {
            world.playSound(
                    null,
                    pos,
                    ModSounds.OLLIE_BROKEN_SQUEAL,
                    SoundCategory.BLOCKS,
                    1f,
                    1f
            );
        }
    }
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient()) {
            world.playSound(
                    null,
                    pos,
                    ModSounds.OLLIE_SQUEAL,
                    SoundCategory.BLOCKS,
                    1f,
                    1f
            );
        }
    }
    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            BlockPos blockPos = hit.getBlockPos();
            world.playSound(null, blockPos, ModSounds.OLLIE_SQUEAL, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }
    }

}