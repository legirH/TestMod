package com.legir.testmod.util;

import com.legir.testmod.TestMod;
import com.legir.testmod.armor.ModArmorMaterial;
import com.legir.testmod.blocks.BlockItemBase;
import com.legir.testmod.blocks.GemBlock;
import com.legir.testmod.items.ItemBase;
import com.legir.testmod.tools.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
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

    //Tools
    public static final RegistryObject<SwordItem> GEM_SWORD = ITEMS.register("gem_sword", () -> new SwordItem(ModItemTier.GEM, 4, -2.4F, new Item.Properties().group(TestMod.TAB)));
    public static final RegistryObject<PickaxeItem> GEM_PICKAXE = ITEMS.register("gem_pickaxe", () -> new PickaxeItem(ModItemTier.GEM, 0, -2.8F, new Item.Properties().group(TestMod.TAB)));
    public static final RegistryObject<AxeItem> GEM_AXE = ITEMS.register("gem_axe", () -> new AxeItem(ModItemTier.GEM, 6, -3.1F, new Item.Properties().group(TestMod.TAB)));
    public static final RegistryObject<ShovelItem> GEM_SHOVEL = ITEMS.register("gem_shovel", () -> new ShovelItem(ModItemTier.GEM, 0.5F, -3.0F, new Item.Properties().group(TestMod.TAB)));
    public static final RegistryObject<HoeItem> GEM_HOE = ITEMS.register("gem_hoe", () -> new HoeItem(ModItemTier.GEM, -3,-1.0F, new Item.Properties().group(TestMod.TAB)));

    //Armor
    public static final RegistryObject<ArmorItem> GEM_HELMET = ITEMS.register("gem_helmet", () -> new ArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.HEAD, new Item.Properties().group(TestMod.TAB)));
    public static final RegistryObject<ArmorItem> GEM_CHESTPLATE = ITEMS.register("gem_chestplate", () -> new ArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.CHEST, new Item.Properties().group(TestMod.TAB)));
    public static final RegistryObject<ArmorItem> GEM_LEGGINGS = ITEMS.register("gem_leggings", () -> new ArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.LEGS, new Item.Properties().group(TestMod.TAB)));
    public static final RegistryObject<ArmorItem> GEM_BOOTS = ITEMS.register("gem_boots", () -> new ArmorItem(ModArmorMaterial.GEM, EquipmentSlotType.FEET, new Item.Properties().group(TestMod.TAB)));


    //Blocks
    public static final RegistryObject<Block> GEM_BLOCK = BLOCKS.register("gem_block", GemBlock::new);

    //Block Items
    public static final RegistryObject<Item> GEM_BLOCK_ITEM = ITEMS.register("gem_block", () -> new BlockItemBase(GEM_BLOCK.get()));
}
