package com.github.laefye.services.item;

import com.github.laefye.MagicPlugin;
import com.github.laefye.tools.ItemTools;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Optional;

public class CustomItemService {
    private final MagicPlugin plugin;
    public static final String ID_TAG = "MagicPluginItemID";
    private final HashMap<String, AbstractItem> items = new HashMap<>();

    public CustomItemService(MagicPlugin plugin) {
        this.plugin = plugin;
    }

    public AbstractItem register(String id, AbstractItem abstractItem) {
        this.items.put(id, abstractItem);
        return abstractItem;
    }

    public Optional<AbstractItem> get(String id) {
        return Optional.ofNullable(items.get(id));
    }

    public Optional<ItemStack> give(String id) {
        return get(id).map(abstractItem -> abstractItem.create(id));
    }

    public Optional<AbstractItem> cast(ItemStack itemStack) {
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
