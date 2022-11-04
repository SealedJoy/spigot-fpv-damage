package org.sealyj.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class reloadCMD implements CommandExecutor {

    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("NoTouch");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player)sender;

        if (player.hasPermission("wd.reload")) {
            plugin.reloadConfig();
            plugin.saveConfig();
            player.sendMessage("FPV Damage Plugin has reloaded!");
        }
        return false;
    }
}
