package me.dkim19375.MagicItems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.dkim19375.MagicItems.CMD.MagicItemsCMD;
import me.dkim19375.MagicItems.CMD.TabCompleter1;
import me.dkim19375.MagicItems.CMD.TabCompleter2;


public class Main extends JavaPlugin {
	public String returnValue;
	public String returnValue2;
	public String returnValue3;
	public String returnValue4;
	public String returnValue5;
	public String returnValue6;
	public String returnValue7;
	
	@Override
	public void onEnable() {		
		System.out.println("[MagicItems] Starting up Magic Items!");
		if (this.getConfig().getInt("config-version") != 1) {
			printToConsole(ChatColor.RED + "" + ChatColor.BOLD + "WARNING! DELETE THE CONFIG FILE AS IT IS OUTDATED!");
			printToConsole(ChatColor.RED + "" + ChatColor.BOLD + "WARNING! YOU MAY EXPERIENCE ERRORS!");
		}
		MagicItemsCMD magicitemscmd = new MagicItemsCMD(this);
		magicitemscmd.getUpdateCheckS1();
		magicitemscmd.getUpdateCheckS2();
		magicitemscmd.getUpdateCheckS3();
		magicitemscmd.getUpdateCheckS4();
		magicitemscmd.ReloadConfig();
		magicitemscmd.ReloadedConfig();
		this.getPluginVersion1();
		this.getPluginVersion2();
		this.getPluginVersion3();
		this.getPluginVersion4();
		this.getReloadConfig();
		this.getReloadedConfig();
		this.saveDefaultConfig();
		if (Bukkit.getVersion().contains("1.16")) {
			System.out.println("[MagicItems] Version detected: 1.16.x");
			updateChecker();
			this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
			this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
			this.getCommand("magicitems").setTabCompleter(new TabCompleter2());
			System.out.println("[MagicItems] Done! Enjoy the plugin!");
		} else {
			if (Bukkit.getVersion().contains("1.13")) {
				System.out.println("[MagicItems] Version detected: 1.13.x");
				updateChecker();
				this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
				this.getCommand("testing").setExecutor(new MagicItemsCMD(this));
				this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
				this.getCommand("magicitems").setTabCompleter(new TabCompleter2());
				System.out.println("[MagicItems] Done! Enjoy the plugin!");
			} else {
				if (Bukkit.getVersion().contains("1.14")) {
					System.out.println("[MagicItems] Version detected: 1.14.x");
					updateChecker();
					this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
					this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
					this.getCommand("magicitems").setTabCompleter(new TabCompleter2());
					System.out.println("[MagicItems] Done! Enjoy the plugin!");
				} else {
					if (Bukkit.getVersion().contains("1.15")) {
						System.out.println("[MagicItems] Version detected: 1.15.x");
						updateChecker();
						this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
						this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
						this.getCommand("magicitems").setTabCompleter(new TabCompleter2());
						System.out.println("[MagicItems] Done! Enjoy the plugin!");
					} else {
						getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MagicItems] ERROR: Incompatible version! Please use version 1.13 - 1.16!");
						getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MagicItems] Current Version: " + Bukkit.getVersion());
						updateChecker();
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
	
    public void printToConsole(String msg) {
        this.getServer().getConsoleSender().sendMessage("[MagicItems] " + msg);
    }
	
    PluginDescriptionFile config = this.getDescription();
    String configVersion = config.getVersion();
    String configWebsite = config.getWebsite();
    
    
    public String getPluginVersion1() {
        new UpdateChecker(this, 82693).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                this.returnValue = ChatColor.GOLD + "MagicItems is " + ChatColor.GREEN + "up to date" + ChatColor.GOLD + "!";
            } else {
                this.returnValue = ChatColor.GOLD + "MagicItems is " + ChatColor.RED + "outdated" + ChatColor.GOLD + "!";
            }
        });
    	return returnValue;
    }
    
    public String getPluginVersion2() {
        new UpdateChecker(this, 82693).getLatestVersion(version -> {
            this.returnValue2 = ChatColor.GOLD + "Newest version: " + ChatColor.GREEN + version;
        });
    	return returnValue2;
    }
    
    public String getPluginVersion3() {
        new UpdateChecker(this, 82693).getLatestVersion(version -> {
            this.returnValue3 = ChatColor.GOLD + "Your version: " + ChatColor.GREEN + configVersion;
        });
    	return returnValue3;
    }
    
    public String getPluginVersion4() {
        new UpdateChecker(this, 82693).getLatestVersion(version -> {
        	this.returnValue4 = ChatColor.GOLD + "Please Update Here: " + ChatColor.GREEN + configWebsite;
        });
    	return returnValue4;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (label.equalsIgnoreCase("blahtest")) {
    		sender.sendMessage("TEST RESULTS: " + this.getConfig().getString(args[0]));
    	}    	
    	return false;
    }
    
    public String getReloadConfig() {
		this.returnValue5 = this.getConfig().getString("Reload.message");
		return returnValue5;
	}
    
    
    
    public String getReloadedConfig() {
    	this.reloadConfig();
    	this.setEnchantLevels();
		this.returnValue6 = this.getConfig().getString("Reload.reloaded-message");    
    	return returnValue6;
	}
    
    public String getConfigValue(String value) {
		this.returnValue7 = this.getConfig().getString(value);    
    	return returnValue7;
	}
    
    public void updateChecker() {
        new UpdateChecker(this, 82693).getLatestVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                printToConsole("MagicItems is up to date!");
            } else {
                printToConsole("MagicItems is outdated!");
                printToConsole("Newest version: " + version);
                printToConsole("Your version: " + configVersion);
                printToConsole("Please Update Here: " + configWebsite);
            }
        });
    }

    public static int protection;
    public static int fire_protection;
    public static int feather_falling;
    public static int blast_protection;
    public static int projectile_protection;
    public static int respiration;
    public static int aqua_affinity;
    public static int thorns;
    public static int depth_strider;
    public static int frost_walker;
    public static int binding_curse;
    public static int sharpness;
    public static int smite;
    public static int bane_of_arthropods;
    public static int knockback;
    public static int fire_aspect;
    public static int looting;
    public static int sweeping;
    public static int efficiency;
    public static int silk_touch;
    public static int unbreaking;
    public static int fortune;
    public static int power;
    public static int punch;
    public static int flame;
    public static int infinity;
    public static int luck_of_the_sea;
    public static int lure;
    public static int mending;
    public static int vanishing_curse;
    public static int channeling;
    public static int impaling;
    public static int loyalty;
    public static int multishot;
    public static int piercing;
    public static int quick_charge;
    public static int soul_speed;
    
    public boolean setEnchantLevels() {
    	
        Main.protection = this.getConfig().getInt("Enchant-Levels.protection");
        Main.fire_protection = this.getConfig().getInt("Enchant-Levels.fire_protection");
        Main.feather_falling = this.getConfig().getInt("Enchant-Levels.feather_falling");
        Main.blast_protection = this.getConfig().getInt("Enchant-Levels.blast_protection");
        Main.projectile_protection = this.getConfig().getInt("Enchant-Levels.projectile_protection");
        Main.respiration = this.getConfig().getInt("Enchant-Levels.respiration");
        Main.aqua_affinity = this.getConfig().getInt("Enchant-Levels.aqua_affinity");
        Main.thorns = this.getConfig().getInt("Enchant-Levels.thorns");
        Main.depth_strider = this.getConfig().getInt("Enchant-Levels.depth_strider");
        Main.frost_walker = this.getConfig().getInt("Enchant-Levels.frost_walker");
        Main.binding_curse = this.getConfig().getInt("Enchant-Levels.binding_curse");
        Main.sharpness = this.getConfig().getInt("Enchant-Levels.sharpness");
        Main.smite = this.getConfig().getInt("Enchant-Levels.smite");
        Main.bane_of_arthropods = this.getConfig().getInt("Enchant-Levels.bane_of_arthropods");
        Main.knockback = this.getConfig().getInt("Enchant-Levels.knockback");
        Main.fire_aspect = this.getConfig().getInt("Enchant-Levels.fire_aspect");
        Main.looting = this.getConfig().getInt("Enchant-Levels.looting");
        Main.sweeping = this.getConfig().getInt("Enchant-Levels.sweeping");
        Main.efficiency = this.getConfig().getInt("Enchant-Levels.efficiency");
        Main.silk_touch = this.getConfig().getInt("Enchant-Levels.silk_touch");
        Main.unbreaking = this.getConfig().getInt("Enchant-Levels.unbreaking");
        Main.fortune = this.getConfig().getInt("Enchant-Levels.fortune");
        Main.power = this.getConfig().getInt("Enchant-Levels.power");
        Main.punch = this.getConfig().getInt("Enchant-Levels.punch");
        Main.flame = this.getConfig().getInt("Enchant-Levels.flame");
        Main.infinity = this.getConfig().getInt("Enchant-Levels.infinity");
        Main.luck_of_the_sea = this.getConfig().getInt("Enchant-Levels.luck_of_the_sea");
        Main.lure = this.getConfig().getInt("Enchant-Levels.lure");
        Main.mending = this.getConfig().getInt("Enchant-Levels.mending");
        Main.vanishing_curse = this.getConfig().getInt("Enchant-Levels.vanishing_curse");
        Main.channeling = this.getConfig().getInt("Enchant-Levels.channeling");
        Main.impaling = this.getConfig().getInt("Enchant-Levels.impaling");
        Main.loyalty = this.getConfig().getInt("Enchant-Levels.loyalty");
        Main.multishot = this.getConfig().getInt("Enchant-Levels.multishot");
        Main.piercing = this.getConfig().getInt("Enchant-Levels.piercing");
        Main.quick_charge = this.getConfig().getInt("Enchant-Levels.quick_charge");
        Main.soul_speed = this.getConfig().getInt("Enchant-Levels.soul_speed");
        
        return true;
    }

}