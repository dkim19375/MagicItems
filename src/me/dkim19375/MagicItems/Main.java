package me.dkim19375.MagicItems;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		System.out.println("Starting up Magic Items!");

		System.out.println("Starting up!");
		this.getCommand("magicitems").setExecutor(new MagicItemsCmd());

		System.out.println("Done! Enjoy the plugin!");

	}

	@Override
	public void onDisable() {

	}

}


