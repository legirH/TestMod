package com.legir.testmod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Oven extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 2, 1, 15, 8, 15), Block.makeCuboidShape(0, 0, 0, 1, 3, 1),
            Block.makeCuboidShape(0, 0, 15, 1, 3, 16), Block.makeCuboidShape(15, 0, 0, 16, 3, 1),
            Block.makeCuboidShape(15, 0, 15, 16, 3, 16), Block.makeCuboidShape(0, 8, 0, 16, 9, 16),
            Block.makeCuboidShape(2, 9, 2, 14, 10, 14), Block.makeCuboidShape(5, 7, 13, 11, 15, 16),
            Block.makeCuboidShape(5, 12, 16, 11, 15, 17), Block.makeCuboidShape(1, 2, 0, 2, 3, 1),
            Block.makeCuboidShape(14, 2, 0, 15, 3, 1), Block.makeCuboidShape(2, 1, 1, 14, 2, 15),
            Block.makeCuboidShape(1, 2, 15, 2, 3, 16), Block.makeCuboidShape(14, 2, 15, 15, 3, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(1.0714285714285694, 2.3571428571428568, 1, 15.07142857142857, 8.357142857142858, 15), Block.makeCuboidShape(15.07142857142857, 0.35714285714285676, 0, 16.07142857142857, 3.3571428571428568, 1),
            Block.makeCuboidShape(0.0714285714285694, 0.35714285714285676, 0, 1.0714285714285694, 3.3571428571428568, 1), Block.makeCuboidShape(15.07142857142857, 0.35714285714285676, 15, 16.07142857142857, 3.3571428571428568, 16),
            Block.makeCuboidShape(0.0714285714285694, 0.35714285714285676, 15, 1.0714285714285694, 3.3571428571428568, 16), Block.makeCuboidShape(0.0714285714285694, 8.357142857142858, 0, 16.07142857142857, 9.357142857142858, 16),
            Block.makeCuboidShape(2.0714285714285694, 9.357142857142858, 2, 14.07142857142857, 10.357142857142858, 14), Block.makeCuboidShape(0.0714285714285694, 7.357142857142858, 5, 3.0714285714285694, 15.357142857142858, 11),
            Block.makeCuboidShape(-0.9285714285714306, 12.357142857142858, 5, 0.0714285714285694, 15.357142857142858, 11), Block.makeCuboidShape(15.07142857142857, 2.3571428571428568, 1, 16.07142857142857, 3.3571428571428568, 2),
            Block.makeCuboidShape(15.07142857142857, 2.3571428571428568, 14, 16.07142857142857, 3.3571428571428568, 15), Block.makeCuboidShape(1.0714285714285694, 1.3571428571428568, 2, 15.07142857142857, 2.3571428571428568, 14),
            Block.makeCuboidShape(0.0714285714285694, 2.3571428571428568, 1, 1.0714285714285694, 3.3571428571428568, 2), Block.makeCuboidShape(0.0714285714285694, 2.3571428571428568, 14, 1.0714285714285694, 3.3571428571428568, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1.0714285714285694, 2.3571428571428568, 1.0714285714285694, 15.07142857142857, 8.357142857142858, 15.07142857142857), Block.makeCuboidShape(15.07142857142857, 0.35714285714285676, 15.07142857142857, 16.07142857142857, 3.3571428571428568, 16.07142857142857),
            Block.makeCuboidShape(15.07142857142857, 0.35714285714285676, 0.0714285714285694, 16.07142857142857, 3.3571428571428568, 1.0714285714285694), Block.makeCuboidShape(0.0714285714285694, 0.35714285714285676, 15.07142857142857, 1.0714285714285694, 3.3571428571428568, 16.07142857142857),
            Block.makeCuboidShape(0.0714285714285694, 0.35714285714285676, 0.0714285714285694, 1.0714285714285694, 3.3571428571428568, 1.0714285714285694), Block.makeCuboidShape(0.0714285714285694, 8.357142857142858, 0.0714285714285694, 16.07142857142857, 9.357142857142858, 16.07142857142857),
            Block.makeCuboidShape(2.0714285714285694, 9.357142857142858, 2.0714285714285694, 14.07142857142857, 10.357142857142858, 14.07142857142857), Block.makeCuboidShape(5.071428571428569, 7.357142857142858, 0.0714285714285694, 11.07142857142857, 15.357142857142858, 3.0714285714285694),
            Block.makeCuboidShape(5.071428571428569, 12.357142857142858, -0.9285714285714306, 11.07142857142857, 15.357142857142858, 0.0714285714285694), Block.makeCuboidShape(14.07142857142857, 2.3571428571428568, 15.07142857142857, 15.07142857142857, 3.3571428571428568, 16.07142857142857),
            Block.makeCuboidShape(1.0714285714285694, 2.3571428571428568, 15.07142857142857, 2.0714285714285694, 3.3571428571428568, 16.07142857142857), Block.makeCuboidShape(2.0714285714285694, 1.3571428571428568, 1.0714285714285694, 14.07142857142857, 2.3571428571428568, 15.07142857142857),
            Block.makeCuboidShape(14.07142857142857, 2.3571428571428568, 0.0714285714285694, 15.07142857142857, 3.3571428571428568, 1.0714285714285694), Block.makeCuboidShape(1.0714285714285694, 2.3571428571428568, 0.0714285714285694, 2.0714285714285694, 3.3571428571428568, 1.0714285714285694)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(1.0714285714285694, 2.3571428571428568, 1.0714285714285694, 15.07142857142857, 8.357142857142858, 15.07142857142857), Block.makeCuboidShape(0.0714285714285694, 0.35714285714285676, 15.07142857142857, 1.0714285714285694, 3.3571428571428568, 16.07142857142857),
            Block.makeCuboidShape(15.07142857142857, 0.35714285714285676, 15.07142857142857, 16.07142857142857, 3.3571428571428568, 16.07142857142857), Block.makeCuboidShape(0.0714285714285694, 0.35714285714285676, 0.0714285714285694, 1.0714285714285694, 3.3571428571428568, 1.0714285714285694),
            Block.makeCuboidShape(15.07142857142857, 0.35714285714285676, 0.0714285714285694, 16.07142857142857, 3.3571428571428568, 1.0714285714285694), Block.makeCuboidShape(0.0714285714285694, 8.357142857142858, 0.0714285714285694, 16.07142857142857, 9.357142857142858, 16.07142857142857),
            Block.makeCuboidShape(2.0714285714285694, 9.357142857142858, 2.0714285714285694, 14.07142857142857, 10.357142857142858, 14.07142857142857), Block.makeCuboidShape(13.07142857142857, 7.357142857142858, 5.071428571428569, 16.07142857142857, 15.357142857142858, 11.07142857142857),
            Block.makeCuboidShape(16.07142857142857, 12.357142857142858, 5.071428571428569, 17.07142857142857, 15.357142857142858, 11.07142857142857), Block.makeCuboidShape(0.0714285714285694, 2.3571428571428568, 14.07142857142857, 1.0714285714285694, 3.3571428571428568, 15.07142857142857),
            Block.makeCuboidShape(0.0714285714285694, 2.3571428571428568, 1.0714285714285694, 1.0714285714285694, 3.3571428571428568, 2.0714285714285694), Block.makeCuboidShape(1.0714285714285694, 1.3571428571428568, 2.0714285714285694, 15.07142857142857, 2.3571428571428568, 14.07142857142857),
            Block.makeCuboidShape(15.07142857142857, 2.3571428571428568, 14.07142857142857, 16.07142857142857, 3.3571428571428568, 15.07142857142857), Block.makeCuboidShape(15.07142857142857, 2.3571428571428568, 1.0714285714285694, 16.07142857142857, 3.3571428571428568, 2.0714285714285694)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();



    public Oven() {
        super(AbstractBlock.Properties.create(Material.IRON)
        .hardnessAndResistance(3.5f, 4.0f)
        .sound(SoundType.ANVIL)
        .harvestLevel(0)
        .harvestTool(ToolType.PICKAXE)
        .setRequiresTool());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    // Block always rotates to look at you
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }
}
