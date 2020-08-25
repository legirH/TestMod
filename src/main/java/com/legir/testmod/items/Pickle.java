package com.legir.testmod.items;


import com.legir.testmod.TestMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Pickle extends Item {

    public Pickle() {
        super(new Properties()
                .group(TestMod.TAB)
                .food(new Food.Builder()
                        .hunger(6)
                        .saturation(2.0f)
                        .effect(new EffectInstance(Effects.SPEED, 600, 2), 1)
                        .effect(new EffectInstance(Effects.HEALTH_BOOST, 600, 5), 1)
                        .effect(new EffectInstance(Effects.REGENERATION, 300, 4), 1)
                        .effect(new EffectInstance(Effects.JUMP_BOOST, 300, 2), 1)
                        .setAlwaysEdible()
                        .build())


        );
    }
}
