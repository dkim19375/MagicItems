package me.dkim19375.MagicItems.managers;

import me.dkim19375.MagicItems.Main;
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
    public static ItemStack getHelmet(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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


        meta.addEnchant(Enchantment.WATER_WORKER, Main.aqua_affinity, true);
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Main.blast_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, Main.fire_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, Main.projectile_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Main.protection, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.OXYGEN, Main.respiration, true);
        meta.addEnchant(Enchantment.THORNS, Main.thorns, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getChestplate(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.WATER_WORKER, Main.aqua_affinity, true);
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Main.blast_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, Main.fire_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, Main.projectile_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Main.protection, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.OXYGEN, Main.respiration, true);
        meta.addEnchant(Enchantment.THORNS, Main.thorns, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getLeggings(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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


        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Main.blast_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, Main.fire_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, Main.projectile_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Main.protection, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.OXYGEN, Main.respiration, true);
        meta.addEnchant(Enchantment.THORNS, Main.thorns, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getBoots(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.WATER_WORKER, Main.aqua_affinity, true);
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Main.blast_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, Main.fire_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, Main.projectile_protection, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Main.protection, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.OXYGEN, Main.respiration, true);
        meta.addEnchant(Enchantment.THORNS, Main.thorns, true);
        meta.addEnchant(Enchantment.DEPTH_STRIDER, Main.depth_strider, true);
        meta.addEnchant(Enchantment.PROTECTION_FALL, Main.feather_falling, true);
        if (Bukkit.getVersion().contains("1.16")) {
            meta.addEnchant(Enchantment.SOUL_SPEED, Main.soul_speed, true);
        }

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getSword(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, Main.fire_aspect, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, Main.looting, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, Main.sweeping, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getAxe(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getAxe2(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
        meta.addEnchant(Enchantment.SILK_TOUCH, Main.silk_touch, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getPickaxe(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getPickaxe2(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
        meta.addEnchant(Enchantment.SILK_TOUCH, Main.silk_touch, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getHoe(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getShovel(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getShovel2(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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


        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
        meta.addEnchant(Enchantment.SILK_TOUCH, Main.silk_touch, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getBow(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.ARROW_FIRE, Main.flame, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, Main.infinity, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, Main.power, true);
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK, Main.punch, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getArrows(boolean enchantstoggle, boolean attributestoggle) {

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

    public static ItemStack getElytra(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.ELYTRA);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);
        meta.addEnchant(Enchantment.THORNS, Main.thorns, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    public static ItemStack getRockets(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

    public static ItemStack getFlintSteel(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

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

    public static ItemStack getCrossbow(boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {

        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return item;
        }
        meta.setLore(addLore(false));

        meta.addEnchant(Enchantment.QUICK_CHARGE, Main.quick_charge, true);
        meta.addEnchant(Enchantment.MULTISHOT, Main.multishot, true);
        meta.addEnchant(Enchantment.PIERCING, Main.piercing, true);
        meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
        meta.addEnchant(Enchantment.MENDING, Main.mending, true);

        meta = metaToggle(meta, vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle);

        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }

    private static ItemMeta metaToggle(ItemMeta meta, boolean vanishingtoggle, boolean bindingtoggle, boolean enchantstoggle, boolean attributestoggle) {
        if (vanishingtoggle) {
            meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
        }
        if (bindingtoggle) {
            meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
        }
        if (!enchantstoggle) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (!attributestoggle) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }
        return meta;
    }

    private static List<String> addLore(boolean hasSilk) {
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
        if (hasSilk) {
            lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Has silk touch");
        }
        return lore;
    }
}