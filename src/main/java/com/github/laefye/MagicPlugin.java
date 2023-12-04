package com.github.laefye;

import com.github.laefye.commands.GiveCommand;
import com.github.laefye.services.CustomItemService;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public class MagicPlugin extends JavaPlugin {
    private CustomItemService customItemService;

    private <T> T registerService(Class<T> cl, T provider) {
        getServer().getServicesManager().register(cl, provider, this, ServicePriority.Normal);
        return provider;
    }

    @Override
    public void onEnable() {
        customItemService = registerService(CustomItemService.class, new CustomItemService(this));
        Optional.ofNullable(getCommand("magicgive"))
                .ifPresent(command -> command.setExecutor(new GiveCommand(this)));

        // Example
        customItemService.register(PoopItem.ID, new PoopItem());
    }

    @Override
    public void onDisable() {
        getServer().getServicesManager().unregister(customItemService);
    }

    public CustomItemService getCustomItemService() {
        return customItemService;
    }
}