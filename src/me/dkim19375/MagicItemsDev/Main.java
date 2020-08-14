package me.dkim19375.MagicItemsDev;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.dkim19375.MagicItemsDev.CMD.MagicItemsCMD;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
        Logger logger = this.getLogger();
        
        new UpdateChecker(this, 82693).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("This plugin (" + this.getDescription().getVersion() + ") is updated to the latest version! ");
            } else {
                logger.info("This plugin (" + this.getDescription().getVersion() + ") is not updated to the latest version! Update to version " + version);
            }
        });
		
		System.out.println("[MagicItems] Starting up Magic Items!");
		this.getCommand("magicitems").setExecutor(new MagicItemsCMD());
		if (Bukkit.getVersion().contains("1.16")) {
			System.out.println("[MagicItems] Version detected: 1.16.x");
			public double version = 1.16;
			System.out.println("[MagicItems] Done! Enjoy the plugin!");
		} else {
			if (Bukkit.getVersion().contains("1.13")) {
				System.out.println("[MagicItems] Version detected: 1.13.x");
				public final double version = 1.13;
				System.out.println("[MagicItems] Done! Enjoy the plugin!");
			} else {
				if (Bukkit.getVersion().contains("1.14")) {
					System.out.println("[MagicItems] Version detected: 1.14.x");
					public final double version = 1.14;
					System.out.println("[MagicItems] Done! Enjoy the plugin!");
				} else {
					if (Bukkit.getVersion().contains("1.15")) {
						System.out.println("[MagicItems] Version detected: 1.15.x");
						public final double version = 1.15;
						System.out.println("[MagicItems] Done! Enjoy the plugin!");
					} else {
						getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MagicItems] ERROR: Incompatible version! Please use version 1.13 - 1.16!");
						getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MagicItems] Current Version: " + Bukkit.getVersion());
					}
				}
			}
		}
	}

	@Override
	public void onDisable() {
		System.out.println("[MagicItems] Stopping plugin");
		System.out.println("[MagicItems] Bye!");
	}

}
