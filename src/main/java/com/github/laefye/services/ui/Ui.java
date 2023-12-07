package com.github.laefye.services.ui;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class Ui {
    protected Inventory inventory;

    public Ui(InventoryHolder owner, int size) {
        inventory = Bukkit.createInventory(owner, size);
    }

    public void dispatchEvent(InventoryInteractEvent event) {

    }
}
