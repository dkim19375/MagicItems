package me.dkim19375.MagicItems;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		System.out.println("Starting up Magic Items!");

		System.out.println("Setting up variables");
		System.out.println("Done setting up variables");

		System.out.println("Setting up /magicitems command");
		this.getCommand("magicitems").setExecutor(new MagicItemsCmd());
		System.out.println("Done setting up /magicitems command");

		System.out.println("Done! Enjoy the plugin!");

	}

	@Override
	public void onDisable() {

	}

}


