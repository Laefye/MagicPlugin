package com.github.laefye;

import com.github.laefye.services.item.ItemManager;
import com.github.laefye.services.ui.UiManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MagicPlugin extends JavaPlugin {
    private ItemManager itemManager;
    private UiManager uiManager;


    @Override
    public void onEnable() {
        itemManager = new ItemManager(this);
        uiManager = new UiManager(this);
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public UiManager getUiManager() {
        return uiManager;
    }

    public static MagicPlugin getInstance() {
        return (MagicPlugin) Bukkit.getServer().getPluginManager().getPlugin("MagicPlugin");
    }
}