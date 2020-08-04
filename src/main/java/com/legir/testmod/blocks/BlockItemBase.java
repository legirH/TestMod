package com.legir.testmod.blocks;


import com.legir.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Properties().group(TestMod.TAB));
    }
}
