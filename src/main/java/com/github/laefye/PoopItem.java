package com.github.laefye;

import com.github.laefye.services.AbstractItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class PoopItem extends AbstractItem {
    public static String ID = "poop";

    @Override
    protected ItemMeta itemMeta(ItemMeta itemMeta) {
        itemMeta.displayName(Component.text("Poop"));
        return itemMeta;
    }

    public PoopItem() {
        super(Material.BROWN_WOOL);
    }
}
