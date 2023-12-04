package com.github.laefye.tools;

import org.bukkit.craftbukkit.v1_20_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public class ItemTools {
    public static Optional<Compound> getItemTag(ItemStack itemStack) {
        return Optional.ofNullable(CraftItemStack.unwrap(itemStack).v())
                .map(Compound::new);
    }

    public static Compound getOrCreateItemTag(ItemStack itemStack) {
        return new Compound(CraftItemStack.unwrap(itemStack).w());
    }

    public static ItemStack setItemTag(ItemStack itemStack, Compound compound) {
        var unwrapped = CraftItemStack.unwrap(itemStack);
        unwrapped.c(compound.getNativeCompound());
        return CraftItemStack.asBukkitCopy(unwrapped);
    }
}
