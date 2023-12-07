package com.github.laefye.services.ui;

import com.github.laefye.MagicPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;

import java.util.ArrayList;

public class UiManager implements Listener {
    private final MagicPlugin plugin;
    private final ArrayList<Ui> uis = new ArrayList<>();

    public UiManager(MagicPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void open(Player player, Ui ui) {
        player.closeInventory();
        player.openInventory(ui.inventory);
    }

    @EventHandler
    public void onInteract(InventoryInteractEvent event) {
        for (var ui : uis) {
            if (ui.inventory == event.getInventory()) {
                ui.dispatchEvent(event);
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        for (var ui : uis) {
            if (ui.inventory == event.getInventory()) {
                ui.inventory.close();
                uis.remove(ui);
                break;
            }
        }
    }
}
