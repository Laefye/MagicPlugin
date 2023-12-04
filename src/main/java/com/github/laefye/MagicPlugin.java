package com.github.laefye;

import com.github.laefye.services.item.CustomItemService;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class MagicPlugin extends JavaPlugin {
    private CustomItemService customItemService;

    private <T> T registerService(Class<T> cl, T provider) {
        getServer().getServicesManager().register(cl, provider, this, ServicePriority.Normal);
        return provider;
    }

    @Override
    public void onEnable() {
        customItemService = registerService(CustomItemService.class, new CustomItemService(this));
    }

    @Override
    public void onDisable() {
        getServer().getServicesManager().unregister(customItemService);
    }
}