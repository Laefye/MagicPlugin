package com.github.laefye.services.ui;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class Ui {
    protected Inventory inventory;

    public Ui(Inventory inventory) {
        this.inventory = inventory;
    }

    public void click(InventoryClickEvent event) {

    }

    public void drag(InventoryDragEvent event) {

    }

    public void move(InventoryMoveItemEvent event) {

    }

    public void pickup(InventoryPickupItemEvent event) {

    }
}
