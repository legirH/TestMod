package com.legir.testmod.items;

import com.legir.testmod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase() { super(new Item.Properties().group(ItemGroup.MATERIALS)); }
}
