package me.dkim19375.MagicItems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.dkim19375.MagicItems.fourfive.CmdFourFive;
import me.dkim19375.MagicItems.fourfive.FourFiveTab;
import me.dkim19375.MagicItems.six.CmdSix;
import me.dkim19375.MagicItems.six.SixTab;
import me.dkim19375.MagicItems.three.CmdThree;
import me.dkim19375.MagicItems.three.ThreeTab;


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		System.out.println("[MagicItems] Starting up Magic Items!");
		
		if (Bukkit.getVersion().contains("1.16")) {
			System.out.println("[MagicItems] Version detected: 1.16.x");
			this.getCommand("magicitems").setExecutor(new CmdSix());
			this.getCommand("magicitems").setTabCompleter(new SixTab());
			System.out.println("[MagicItems] Done! Enjoy the plugin!");
		} else {
			if (Bukkit.getVersion().contains("1.13")) {
				System.out.println("[MagicItems] Version detected: 1.13.x");
				this.getCommand("magicitems").setExecutor(new CmdThree());
				this.getCommand("magicitems").setTabCompleter(new ThreeTab());
				System.out.println("[MagicItems] Done! Enjoy the plugin!");
			} else {
				if (Bukkit.getVersion().contains("1.14")) {
					System.out.println("[MagicItems] Version detected: 1.14.x");
					this.getCommand("magicitems").setExecutor(new CmdFourFive());
					this.getCommand("magicitems").setTabCompleter(new FourFiveTab());
					System.out.println("[MagicItems] Done! Enjoy the plugin!");
				} else {
					if (Bukkit.getVersion().contains("1.15")) {
						System.out.println("[MagicItems] Version detected: 1.15.x");
						this.getCommand("magicitems").setExecutor(new CmdFourFive());
						this.getCommand("magicitems").setTabCompleter(new FourFiveTab());
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