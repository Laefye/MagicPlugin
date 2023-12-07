package com.github.laefye.services.ui;

import com.github.laefye.MagicPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Optional;

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
        uis.add(ui);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        getUi(event.getInventory()).ifPresent(ui -> ui.click(event));
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {
        getUi(event.getInventory()).ifPresent(ui -> ui.drag(event));
    }

    @EventHandler
    public void onMove(InventoryMoveItemEvent event) {
        getUi(event.getDestination()).ifPresent(ui -> ui.move(event));
    }

    @EventHandler
    public void onPickup(InventoryPickupItemEvent event) {
        getUi(event.getInventory()).ifPresent(ui -> ui.pickup(event));
    }

    private Optional<Ui> getUi(Inventory inventory) {
        return uis.stream().filter(ui -> ui.inventory == inventory).findAny();
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        getUi(event.getInventory()).ifPresent(ui -> {
            ui.close(event);
            uis.remove(ui);
        });
    }
}
