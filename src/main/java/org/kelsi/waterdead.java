package org.kelsi;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.commands.reloadCMD;

public final class waterdead extends JavaPlugin implements Listener {

    boolean enabled = getConfig().getBoolean("plugin.enabled");

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        getCommand("wdreload").setExecutor(new reloadCMD());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event) {
        if (enabled) {
            Material m = event.getPlayer().getLocation().getBlock().getType();
            Player player = event.getPlayer();
            if (m == Material.WATER) {
                player.damage(getConfig().getDouble("plugin.damage"));
            }
        }
    }
}