package me.dkim19375.MagicItems.managers;

import me.dkim19375.MagicItems.CMD.MagicItemsCMD;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManagers {

    MagicItemsCMD mi = new MagicItemsCMD();

    public ItemStack getHelmet(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_HELMET;
        } else mat = Material.DIAMOND_HELMET;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        if (mi.getAqua_affinity() != 0) {
            meta.addEnchant(Enchantment.WATER_WORKER, mi.getAqua_affinity(), true);
        }
        if (mi.getBlast_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, mi.getBlast_protection(), true);
        }
        if (mi.getFire_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_FIRE, mi.getFire_protection(), true);
        }
        if (mi.getProjectile_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, mi.getProjectile_protection(), true);
        }
        if (mi.getProtection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, mi.getProtection(), true);
        }
        if (mi.getMending() != 0) {
            meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        }
        if (mi.getRespiration() != 0) {
            meta.addEnchant(Enchantment.OXYGEN, mi.getRespiration(), true);
        }
        if (mi.getThorns() != 0) {
            meta.addEnchant(Enchantment.THORNS, mi.getThorns(), true);
        }

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getChestplate(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_CHESTPLATE;
        } else mat = Material.DIAMOND_CHESTPLATE;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        if (mi.getBlast_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, mi.getBlast_protection(), true);
        }
        if (mi.getFire_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_FIRE, mi.getFire_protection(), true);
        }
        if (mi.getProjectile_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, mi.getProjectile_protection(), true);
        }
        if (mi.getProtection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, mi.getProtection(), true);
        }
        if (mi.getMending() != 0) {
            meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        }
        if (mi.getThorns() != 0) {
            meta.addEnchant(Enchantment.THORNS, mi.getThorns(), true);
        }

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getLeggings(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_LEGGINGS;
        } else mat = Material.DIAMOND_LEGGINGS;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));


        if (mi.getBlast_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, mi.getBlast_protection(), true);
        }
        if (mi.getFire_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_FIRE, mi.getFire_protection(), true);
        }
        if (mi.getProjectile_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, mi.getProjectile_protection(), true);
        }
        if (mi.getProtection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, mi.getProtection(), true);
        }
        if (mi.getMending() != 0) {
            meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        }
        if (mi.getThorns() != 0) {
            meta.addEnchant(Enchantment.THORNS, mi.getThorns(), true);
        }

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getBoots(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_BOOTS;
        } else mat = Material.DIAMOND_BOOTS;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        getBasicArmorEnchants(meta);

        if (mi.getDepth_strider() != 0) {
            meta.addEnchant(Enchantment.DEPTH_STRIDER, mi.getDepth_strider(), true);
        }
        if (mi.getFeather_falling() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_FALL, mi.getFeather_falling(), true);
        }
        if (Bukkit.getVersion().contains("1.16") && mi.getSoul_speed() != 0) {
            meta.addEnchant(Enchantment.SOUL_SPEED, mi.getSoul_speed(), true);
        }

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getSword(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_SWORD;
        } else mat = Material.DIAMOND_SWORD;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, mi.getFire_aspect(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, mi.getLooting(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, mi.getSweeping(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getAxe(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_AXE;
        } else mat = Material.DIAMOND_AXE;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, mi.getFortune(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getAxe2(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_AXE;
        } else mat = Material.DIAMOND_AXE;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(true));

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, mi.getFortune(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);
        meta.addEnchant(Enchantment.SILK_TOUCH, mi.getSilk_touch(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getPickaxe(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_PICKAXE;
        } else mat = Material.DIAMOND_PICKAXE;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, mi.getFortune(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getPickaxe2(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_PICKAXE;
        } else mat = Material.DIAMOND_PICKAXE;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(true));

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, mi.getFortune(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);
        meta.addEnchant(Enchantment.SILK_TOUCH, mi.getSilk_touch(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getHoe(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_HOE;
        } else mat = Material.DIAMOND_HOE;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, mi.getFortune(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getShovel(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_SHOVEL;
        } else mat = Material.DIAMOND_SHOVEL;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, mi.getFortune(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getShovel2(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        Material mat;
        if (Bukkit.getVersion().contains("1.16")) {
            mat = Material.NETHERITE_SHOVEL;
        } else mat = Material.DIAMOND_SHOVEL;

        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(true));


        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, mi.getBane_of_arthropods(), true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, mi.getFortune(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, mi.getSharpness(), true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, mi.getSmite(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.DIG_SPEED, mi.getEfficiency(), true);
        meta.addEnchant(Enchantment.SILK_TOUCH, mi.getSilk_touch(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getBow(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.ARROW_FIRE, mi.getFlame(), true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, mi.getInfinity(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, mi.getPower(), true);
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK, mi.getPunch(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getArrows(boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.ARROW);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta = metaToggle(meta, false, false, enchantstoggle, attributestoggle);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getElytra(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.ELYTRA);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        meta.addEnchant(Enchantment.THORNS, mi.getThorns(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getRockets(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getFlintSteel(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        item.setItemMeta(meta);

        return item;

    }

    public ItemStack getCrossbow(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.QUICK_CHARGE, mi.getQuick_charge(), true);
        meta.addEnchant(Enchantment.MULTISHOT, mi.getMultishot(), true);
        meta.addEnchant(Enchantment.PIERCING, mi.getPiercing(), true);
        meta.addEnchant(Enchantment.DURABILITY, mi.getUnbreaking(), true);
        meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    private ItemMeta metaToggle(ItemMeta meta, boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {
        if (vanishingtoggle) {
            meta.addEnchant(Enchantment.VANISHING_CURSE, mi.getVanishing_curse(), true);
        }
        if (bindingtoggle) {
            meta.addEnchant(Enchantment.BINDING_CURSE, mi.getBinding_curse(), true);
        }
        if (!enchantstoggle) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (!attributestoggle) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }
        return meta;
    }

    private ItemMeta getBasicArmorEnchants(ItemMeta meta) {
        if (mi.getBlast_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, mi.getBlast_protection(), true);
        }
        if (mi.getFire_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_FIRE, mi.getFire_protection(), true);
        }
        if (mi.getProjectile_protection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, mi.getProjectile_protection(), true);
        }
        if (mi.getProtection() != 0) {
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, mi.getProtection(), true);
        }
        if (mi.getMending() != 0) {
            meta.addEnchant(Enchantment.MENDING, mi.getMending(), true);
        }
        if (mi.getThorns() != 0) {
            meta.addEnchant(Enchantment.THORNS, mi.getThorns(), true);
        }
        return meta;
    }

    private List<String> addLore(boolean hasSilk) {
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
        if (hasSilk) {
            lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Has silk touch");
        }
        return lore;
    }
}