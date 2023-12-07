package com.github.laefye.services.item;

import com.github.laefye.craft.Compound;
import com.github.laefye.craft.ItemTools;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Optional;

public class BaseItem {
    private final Material material;
    public BaseItem(Material material) {
        this.material = material;
    }

    private ItemStack craft(String id) {
        var item = new ItemStack(material);
        var tag = ItemTools.getOrCreateItemTag(item);
        tag.putString(ItemManager.ID_TAG, id);
        tag = compound(tag);
        item = ItemTools.setItemTag(item, tag);
        Optional.ofNullable(item.getItemMeta())
                .map(this::itemMeta)
                .ifPresent(item::setItemMeta);
        return item;
    }

    protected Compound compound(Compound compound) {
        return compound;
    }

    protected ItemMeta itemMeta(ItemMeta itemMeta) {
        return itemMeta;
    }

    public ItemStack create(String id) {
        return craft(id).clone();
    }
}
