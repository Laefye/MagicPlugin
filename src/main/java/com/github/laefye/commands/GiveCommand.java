package com.github.laefye.commands;

import com.github.laefye.MagicPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GiveCommand implements CommandExecutor {
    private MagicPlugin plugin;

    public GiveCommand(MagicPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            return false;
        }
        if (!(sender instanceof Player player)) {
            return false;
        }
        int amount = args.length == 2 ? Integer.parseInt(args[1]) : 1;
        if (amount < 1) {
            amount = 1;
        }
        var optionalItemStack = plugin.getCustomItemService().give(args[0]);
        if (optionalItemStack.isEmpty()) {
            return false;
        }
        var itemStack = optionalItemStack.get();
        itemStack.setAmount(amount);
        player.getInventory().addItem(itemStack);
        return true;
    }
}
