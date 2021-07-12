package me.dkim19375.MagicItems;

import me.dkim19375.MagicItems.managers.ItemManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.dkim19375.MagicItems.CMD.MagicItemsCMD;
import me.dkim19375.MagicItems.CMD.TabCompleter1;


public class Main extends JavaPlugin {
    public String returnValue;
    public String returnValue2;
    public String returnValue3;
    public String returnValue4;
    public String returnValue5;
    public String returnValue6;

    @Override
    public void onEnable() {
        System.out.println("[MagicItems] Starting up Magic Items!");
        if (this.getConfig().getInt("config-version") != 1.2) {
            printToConsole(ChatColor.RED + "" + ChatColor.BOLD + "WARNING! DELETE THE CONFIG FILE AS IT IS OUTDATED!");
            printToConsole(ChatColor.RED + "" + ChatColor.BOLD + "WARNING! YOU MAY EXPERIENCE ERRORS!");
        }
        MagicItemsCMD magicitemscmd = new MagicItemsCMD(this);
        ItemManagers itemmanagers = new ItemManagers(this);
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


        if (Bukkit.getVersion().contains("1.17")) {
            System.out.println("[MagicItems] Version detected: 1.17.x");
            updateChecker();
            this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
            this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
            System.out.println("[MagicItems] Done! Enjoy the plugin!");
        } else {
            if (Bukkit.getVersion().contains("1.16")) {
                System.out.println("[MagicItems] Version detected: 1.16.x");
                updateChecker();
                this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
                this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
                System.out.println("[MagicItems] Done! Enjoy the plugin!");
            } else {
                if (Bukkit.getVersion().contains("1.13")) {
                    System.out.println("[MagicItems] Version detected: 1.13.x");
                    updateChecker();
                    this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
                    this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
                    System.out.println("[MagicItems] Done! Enjoy the plugin!");
                } else {
                    if (Bukkit.getVersion().contains("1.14")) {
                        System.out.println("[MagicItems] Version detected: 1.14.x");
                        updateChecker();
                        this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
                        this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
                        System.out.println("[MagicItems] Done! Enjoy the plugin!");
                    } else {
                        if (Bukkit.getVersion().contains("1.15")) {
                            System.out.println("[MagicItems] Version detected: 1.15.x");
                            updateChecker();
                            this.getCommand("magicitems").setExecutor(new MagicItemsCMD(this));
                            this.getCommand("magicitems").setTabCompleter(new TabCompleter1());
                            System.out.println("[MagicItems] Done! Enjoy the plugin!");
                        } else {
                            getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MagicItems] ERROR: Incompatible version! Please use version 1.13 - 1.17!");
                            getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MagicItems] Current Version: " + Bukkit.getVersion());
                            updateChecker();
                        }
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
        new UpdateChecker(this, 82693).getLatestVersion(version -> this.returnValue2 = ChatColor.GOLD + "Newest version: " + ChatColor.GREEN + version);
        return returnValue2;
    }

    public String getPluginVersion3() {
        new UpdateChecker(this, 82693).getLatestVersion(version -> this.returnValue3 = ChatColor.GOLD + "Your version: " + ChatColor.GREEN + configVersion);
        return returnValue3;
    }

    public String getPluginVersion4() {
        new UpdateChecker(this, 82693).getLatestVersion(version -> this.returnValue4 = ChatColor.GOLD + "Please Update Here: " + ChatColor.GREEN + configWebsite);
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

    public int protection;
    public int fire_protection;
    public int feather_falling;
    public int blast_protection;
    public int projectile_protection;
    public int respiration;
    public int aqua_affinity;
    public int thorns;
    public int depth_strider;
    public int frost_walker;
    public int binding_curse;
    public int sharpness;
    public int smite;
    public int bane_of_arthropods;
    public int knockback;
    public int fire_aspect;
    public int looting;
    public int sweeping;
    public int efficiency;
    public int silk_touch;
    public int unbreaking;
    public int fortune;
    public int power;
    public int punch;
    public int flame;
    public int infinity;
    public int luck_of_the_sea;
    public int lure;
    public int mending;
    public int vanishing_curse;
    public int channeling;
    public int impaling;
    public int loyalty;
    public int multishot;
    public int piercing;
    public int quick_charge;
    public int soul_speed;

    public int getProtection() {
        return protection;
    }

    public int getFire_protection() {
        return fire_protection;
    }

    public int getFeather_falling() {
        return feather_falling;
    }

    public int getBlast_protection() {
        return blast_protection;
    }

    public int getProjectile_protection() {
        return projectile_protection;
    }

    public int getRespiration() {
        return respiration;
    }

    public int getAqua_affinity() {
        return aqua_affinity;
    }

    public int getThorns() {
        return thorns;
    }

    public int getDepth_strider() {
        return depth_strider;
    }

    public int getFrost_walker() {
        return frost_walker;
    }

    public int getBinding_curse() {
        return binding_curse;
    }

    public int getSharpness() {
        return sharpness;
    }

    public int getSmite() {
        return smite;
    }

    public int getBane_of_arthropods() {
        return bane_of_arthropods;
    }

    public int getKnockback() {
        return knockback;
    }

    public int getFire_aspect() {
        return fire_aspect;
    }

    public int getLooting() {
        return looting;
    }

    public int getSweeping() {
        return sweeping;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public int getSilk_touch() {
        return silk_touch;
    }

    public int getUnbreaking() {
        return unbreaking;
    }

    public int getFortune() {
        return fortune;
    }

    public int getPower() {
        return power;
    }

    public int getPunch() {
        return punch;
    }

    public int getFlame() {
        return flame;
    }

    public int getInfinity() {
        return infinity;
    }

    public int getLuck_of_the_sea() {
        return luck_of_the_sea;
    }

    public int getLure() {
        return lure;
    }

    public int getMending() {
        return mending;
    }

    public int getVanishing_curse() {
        return vanishing_curse;
    }

    public int getChanneling() {
        return channeling;
    }

    public int getImpaling() {
        return impaling;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public int getMultishot() {
        return multishot;
    }

    public int getPiercing() {
        return piercing;
    }

    public int getQuick_charge() {
        return quick_charge;
    }

    public int getSoul_speed() {
        return soul_speed;
    }

    public void setEnchantLevels() {

        this.protection = this.getConfig().getInt("Enchant-Levels.protection");
        this.fire_protection = this.getConfig().getInt("Enchant-Levels.fire_protection");
        this.feather_falling = this.getConfig().getInt("Enchant-Levels.feather_falling");
        this.blast_protection = this.getConfig().getInt("Enchant-Levels.blast_protection");
        this.projectile_protection = this.getConfig().getInt("Enchant-Levels.projectile_protection");
        this.respiration = this.getConfig().getInt("Enchant-Levels.respiration");
        this.aqua_affinity = this.getConfig().getInt("Enchant-Levels.aqua_affinity");
        this.thorns = this.getConfig().getInt("Enchant-Levels.thorns");
        this.depth_strider = this.getConfig().getInt("Enchant-Levels.depth_strider");
        this.frost_walker = this.getConfig().getInt("Enchant-Levels.frost_walker");
        this.binding_curse = this.getConfig().getInt("Enchant-Levels.binding_curse");
        this.sharpness = this.getConfig().getInt("Enchant-Levels.sharpness");
        this.smite = this.getConfig().getInt("Enchant-Levels.smite");
        this.bane_of_arthropods = this.getConfig().getInt("Enchant-Levels.bane_of_arthropods");
        this.knockback = this.getConfig().getInt("Enchant-Levels.knockback");
        this.fire_aspect = this.getConfig().getInt("Enchant-Levels.fire_aspect");
        this.looting = this.getConfig().getInt("Enchant-Levels.looting");
        this.sweeping = this.getConfig().getInt("Enchant-Levels.sweeping");
        this.efficiency = this.getConfig().getInt("Enchant-Levels.efficiency");
        this.silk_touch = this.getConfig().getInt("Enchant-Levels.silk_touch");
        this.unbreaking = this.getConfig().getInt("Enchant-Levels.unbreaking");
        this.fortune = this.getConfig().getInt("Enchant-Levels.fortune");
        this.power = this.getConfig().getInt("Enchant-Levels.power");
        this.punch = this.getConfig().getInt("Enchant-Levels.punch");
        this.flame = this.getConfig().getInt("Enchant-Levels.flame");
        this.infinity = this.getConfig().getInt("Enchant-Levels.infinity");
        this.luck_of_the_sea = this.getConfig().getInt("Enchant-Levels.luck_of_the_sea");
        this.lure = this.getConfig().getInt("Enchant-Levels.lure");
        this.mending = this.getConfig().getInt("Enchant-Levels.mending");
        this.vanishing_curse = this.getConfig().getInt("Enchant-Levels.vanishing_curse");
        this.channeling = this.getConfig().getInt("Enchant-Levels.channeling");
        this.impaling = this.getConfig().getInt("Enchant-Levels.impaling");
        this.loyalty = this.getConfig().getInt("Enchant-Levels.loyalty");
        this.multishot = this.getConfig().getInt("Enchant-Levels.multishot");
        this.piercing = this.getConfig().getInt("Enchant-Levels.piercing");
        this.quick_charge = this.getConfig().getInt("Enchant-Levels.quick_charge");
        this.soul_speed = this.getConfig().getInt("Enchant-Levels.soul_speed");

    }
}