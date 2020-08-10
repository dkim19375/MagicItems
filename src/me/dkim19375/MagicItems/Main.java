package me.dkim19375.MagicItems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.dkim19375.MagicItems.six.CmdSix;
import me.dkim19375.MagicItems.six.SixTab;
import me.dkim19375.MagicItems.three.CmdThree;
import me.dkim19375.MagicItems.two.CmdTwo;


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		System.out.println("Starting up Magic Items!");
		
		if (Bukkit.getVersion().contains("1.16")) {
			System.out.println("Version detected: 1.16.x");
			this.getCommand("magicitems").setExecutor(new CmdSix());
			this.getCommand("magicitems").setTabCompleter(new SixTab());
			System.out.println("Done! Enjoy the plugin!");
		} else {
			if (Bukkit.getVersion().contains("1.13")) {
				System.out.println("Version detected: 1.13.x");
				this.getCommand("magicitems").setExecutor(new CmdThree());
				System.out.println("Done! Enjoy the plugin!");
			} else {
				if (Bukkit.getVersion().contains("1.14")) {
					System.out.println("Version detected: 1.14.x");
					this.getCommand("magicitems").setExecutor(new CmdThree());
					System.out.println("Done! Enjoy the plugin!");
				} else {
					if (Bukkit.getVersion().contains("1.15")) {
						System.out.println("Version detected: 1.15.x");
						this.getCommand("magicitems").setExecutor(new CmdThree());
						System.out.println("Done! Enjoy the plugin!");
					} else {
						if (Bukkit.getVersion().contains("1.12")) {
							System.out.println("Version detected: 1.12.x");
							this.getCommand("magicitems").setExecutor(new CmdTwo());
							System.out.println("Done! Enjoy the plugin!");
						} else {
							System.out.println("ERROR: Incompatible version! Please use version 1.12 - 1.16!");
						}
					}
				}
			}
		}
	}

	@Override
	public void onDisable() {
		System.out.println("Stopping plugin");
		System.out.println("Bye!");
	}

}