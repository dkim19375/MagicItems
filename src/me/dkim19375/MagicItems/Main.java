package me.dkim19375.MagicItems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
		loadConfig();
		System.out.println("[MagicItems] Starting up Magic Items!");
		
		this.saveDefaultConfig();
		
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
	
	
	
	public boolean onCommand(CommandSender sender,  Command cmd,  String label, String[] args) {
		if (label.equalsIgnoreCase("magicitems")) {
			if (!sender.hasPermission("magicitems.reload")) {
				sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
				return true;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('§', 
						this.getConfig().getString("Reload.message")));
				getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "[MagicItems] " + ChatColor.translateAlternateColorCodes('§', 
						this.getConfig().getString("Reload.message")));
				this.reloadConfig();
				loadConfig();
				sender.sendMessage(ChatColor.translateAlternateColorCodes('§', 
						this.getConfig().getString("Reload.reloaded-message")));
				getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "[MagicItems] " + ChatColor.translateAlternateColorCodes('§', 
						this.getConfig().getString("Reload.reloaded-message")));
				
			}
		}
		return false;
	}
	
	

	public static int protection = 32767;
	public static int fire_protection = 32767;
	public static int feather_falling = 32767;
	public static int blast_protection = 32767;
	public static int projectile_protection = 32767;
	public static int respiration = 32767;
	public static int aqua_affinity = 32767;
	public static int thorns = 32767;
	public static int depth_strider = 32767;
	public static int frost_walker = 32767;
	public static int binding_curse = 32767;
	public static int sharpness = 32767;
	public static int smite = 32767;
	public static int bane_of_arthropods = 32767;
	public static int knockback = 0;
	public static int fire_aspect = 32767;
	public static int looting = 1000;
	public static int sweeping = 32767;
	public static int efficiency = 32767;
	public static int silk_touch = 32767;
	public static int unbreaking = 32767;
	public static int fortune = 32767;
	public static int power = 32767;
	public static int punch = 0;
	public static int flame = 32767;
	public static int infinity = 32767;
	public static int luck_of_the_sea = 32767;
	public static int lure = 32767;
	public static int mending = 32767;
	public static int vanishing_curse = 32767;
	public static int channeling = 32767;
	public static int impaling = 32767;
	public static int loyalty = 32767;
	public static int multishot = 32767;
	public static int piercing = 32767;
	public static int quick_charge = 32767;
	public static int soul_speed = 10;
	
	
	public boolean loadConfig() {
		
		protection = this.getConfig().getInt("Enchant Levels.protection");
		fire_protection = this.getConfig().getInt("Enchant Levels.fire_protection");
		feather_falling = this.getConfig().getInt("Enchant Levels.feather_falling");
		blast_protection = this.getConfig().getInt("Enchant Levels.blast_protection");
		projectile_protection = this.getConfig().getInt("Enchant Levels.projectile_protection");
		respiration = this.getConfig().getInt("Enchant Levels.respiration");
		aqua_affinity = this.getConfig().getInt("Enchant Levels.aqua_affinity");
		thorns = this.getConfig().getInt("Enchant Levels.thorns");
		depth_strider = this.getConfig().getInt("Enchant Levels.depth_strider");
		frost_walker = this.getConfig().getInt("Enchant Levels.frost_walker");
		binding_curse = this.getConfig().getInt("Enchant Levels.binding_curse");
		sharpness = this.getConfig().getInt("Enchant Levels.sharpness");
		smite = this.getConfig().getInt("Enchant Levels.smite");
		bane_of_arthropods = this.getConfig().getInt("Enchant Levels.bane_of_arthropods");
		knockback = this.getConfig().getInt("Enchant Levels.knockback");
		fire_aspect = this.getConfig().getInt("Enchant Levels.fire_aspect");
		looting = this.getConfig().getInt("Enchant Levels.looting");
		sweeping = this.getConfig().getInt("Enchant Levels.sweeping");
		efficiency = this.getConfig().getInt("Enchant Levels.efficiency");
		silk_touch = this.getConfig().getInt("Enchant Levels.silk_touch");
		unbreaking = this.getConfig().getInt("Enchant Levels.unbreaking");
		fortune = this.getConfig().getInt("Enchant Levels.fortune");
		power = this.getConfig().getInt("Enchant Levels.power");
		punch = this.getConfig().getInt("Enchant Levels.punch");
		flame = this.getConfig().getInt("Enchant Levels.flame");
		infinity = this.getConfig().getInt("Enchant Levels.infinity");
		luck_of_the_sea = this.getConfig().getInt("Enchant Levels.luck_of_the_sea");
		lure = this.getConfig().getInt("Enchant Levels.lure");
		mending = this.getConfig().getInt("Enchant Levels.mending");
		vanishing_curse = this.getConfig().getInt("Enchant Levels.vanishing_curse");
		channeling = this.getConfig().getInt("Enchant Levels.channeling");
		impaling = this.getConfig().getInt("Enchant Levels.impaling");
		loyalty = this.getConfig().getInt("Enchant Levels.loyalty");
		multishot = this.getConfig().getInt("Enchant Levels.multishot");
		piercing = this.getConfig().getInt("Enchant Levels.piercing");
		quick_charge = this.getConfig().getInt("Enchant Levels.quick_charge");
		soul_speed = this.getConfig().getInt("Enchant Levels.soul_speed");


			
		return true;
	}
	

}