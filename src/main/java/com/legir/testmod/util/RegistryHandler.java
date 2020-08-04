package com.legir.testmod.util;

import com.legir.testmod.TestMod;
import com.legir.testmod.blocks.BlockItemBase;
import com.legir.testmod.blocks.GemBlock;
import com.legir.testmod.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items
    public static final RegistryObject<Item> GEM = ITEMS.register("gem", ItemBase::new);


    // Blocks
    public static final RegistryObject<Block> GEM_BLOCK = BLOCKS.register("gem_block", GemBlock::new);

    //Block Items
    public static final RegistryObject<Item> GEM_BLOCK_ITEM = ITEMS.register("gem_block", () -> new BlockItemBase(GEM_BLOCK.get()));
}
