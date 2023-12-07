package com.github.laefye.services.item;

import com.github.laefye.MagicPlugin;
import com.github.laefye.craft.ItemTools;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Optional;

public class ItemManager {
    private final MagicPlugin plugin;
    public static final String ID_TAG = "MagicPluginItemID";
    private final HashMap<String, BaseItem> items = new HashMap<>();

    public ItemManager(MagicPlugin plugin) {
        this.plugin = plugin;
    }

    public BaseItem register(String id, BaseItem baseItem) {
        this.items.put(id, baseItem);
        return baseItem;
    }

    public Optional<BaseItem> get(String id) {
        return Optional.ofNullable(items.get(id));
    }

    public Optional<ItemStack> give(String id) {
        return get(id).map(baseItem -> baseItem.create(id));
    }

    public Optional<BaseItem> cast(ItemStack itemStack) {
        var tag = ItemTools.getItemTag(itemStack);
        if (tag.isEmpty()) {
            return Optional.empty();
        }
        if (!tag.get().contains(ID_TAG)) {
            return Optional.empty();
        }
        return get(tag.get().getString(ID_TAG));
    }
}
