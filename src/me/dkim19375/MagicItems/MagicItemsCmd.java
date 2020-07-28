package me.dkim19375.MagicItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MagicItemsCmd implements CommandExecutor {

	private boolean enchantstoggle = false;
	private boolean attributestoggle = true;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("magicitems")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Too little arguments.");
				sender.sendMessage(ChatColor.GREEN + "Usage:");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems help");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems give");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
				return true;
			}
			if (args.length >= 2) {
				if (args.length > 2) {
					sender.sendMessage(ChatColor.RED + "Too many arguments.");
					sender.sendMessage(ChatColor.GREEN + "Usage:");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems help");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems give");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
					return true;
				} else {
					if (args.length == 2) {
						if (args[0].equalsIgnoreCase("enchants")) {
							if (args[1].equalsIgnoreCase("toggle")) {
								if (enchantstoggle) {
									enchantstoggle = false;
									sender.sendMessage(ChatColor.GOLD + "Enchants on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									enchantstoggle = true;
									sender.sendMessage(ChatColor.GOLD + "Enchants on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}
							}
							
							if (args[1].equalsIgnoreCase("status")) {
								if (enchantstoggle) {
									enchantstoggle = false;
									sender.sendMessage(ChatColor.GOLD + "Enchants on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									enchantstoggle = true;
									sender.sendMessage(ChatColor.GOLD + "Enchants on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}
							}
							
							if (args[1].equalsIgnoreCase("toggle") || args[1].equalsIgnoreCase("status")) {
								sender.sendMessage(ChatColor.RED + "Invalid arguments.");
								sender.sendMessage(ChatColor.GREEN + "Usage:");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems enchanst ?");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants help");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants toggle");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants status");
							}
							if (args[1].equalsIgnoreCase("?") || args[1].equalsIgnoreCase("help")) {
								sender.sendMessage(ChatColor.GREEN + "Usage:");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants ?");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants help");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants toggle");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems encahnts status");
							}
						}
						if (args[0].equalsIgnoreCase("attributes")) {
							if (args[1].equalsIgnoreCase("toggle")) {
								if (attributestoggle) {
									attributestoggle = false;
									sender.sendMessage(ChatColor.GOLD + "Attributes on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									attributestoggle = true;
									sender.sendMessage(ChatColor.GOLD + "Attributes on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}								
							}
							
							if (args[1].equalsIgnoreCase("status")) {
								if (attributestoggle) {
									attributestoggle = false;
									sender.sendMessage(ChatColor.GOLD + "Attributes on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									attributestoggle = true;
									sender.sendMessage(ChatColor.GOLD + "Attributes on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}
							}
							
							if (args[1].equalsIgnoreCase("toggle") || args[1].equalsIgnoreCase("status")) {
								sender.sendMessage(ChatColor.RED + "Invalid arguments.");
								sender.sendMessage(ChatColor.GREEN + "Usage:");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes ?");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes help");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes toggle");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes status");
							}
							if (args[1].equalsIgnoreCase("?") || args[1].equalsIgnoreCase("help")) {
								sender.sendMessage(ChatColor.GREEN + "Usage:");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes ?");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes help");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes toggle");
								sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes status");
							}
						}
					}
				}

			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(ChatColor.GREEN + "Usage:");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems help");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems give");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
					return true;
				}
				if (args[0].equalsIgnoreCase("give")) {
					if (!(sender.hasPermission("magicitems.give"))) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
					} else {
						if (!(sender instanceof Player)) {
							sender.sendMessage("You cannot hold items as a console.");
							return true;
						}
						Player player = (Player) sender;
						player.sendMessage(ChatColor.GOLD + "You have been recieved the items.");
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getHelmet());
						} else {
							player.getInventory().addItem(getHelmet());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getChestplate());
						} else {
							player.getInventory().addItem(getChestplate());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getLeggings());
						} else {
							player.getInventory().addItem(getLeggings());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getBoots());
						} else {
							player.getInventory().addItem(getBoots());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getSword());
						} else {
							player.getInventory().addItem(getSword());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getAxe());
						} else {
							player.getInventory().addItem(getAxe());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getAxe2());
						} else {
							player.getInventory().addItem(getAxe2());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getPickaxe());
						} else {
							player.getInventory().addItem(getPickaxe());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getPickaxe2());
						} else {
							player.getInventory().addItem(getPickaxe2());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getShovel());
						} else {
							player.getInventory().addItem(getShovel());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getHoe());
						} else {
							player.getInventory().addItem(getHoe());
						}

						return true;
					}
				}

			}

		}
		return false;
	}

	public ItemStack getHelmet() {

		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta meta = helmet.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.WATER_WORKER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.OXYGEN, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		helmet.setItemMeta(meta);

		return helmet;

	}

	public ItemStack getChestplate() {

		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = chestplate.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.WATER_WORKER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.OXYGEN, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		chestplate.setItemMeta(meta);

		return chestplate;

	}

	public ItemStack getLeggings() {

		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta = leggings.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.WATER_WORKER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.OXYGEN, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		leggings.setItemMeta(meta);

		return leggings;

	}

	public ItemStack getBoots() {

		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = boots.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.WATER_WORKER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.OXYGEN, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		meta.addEnchant(Enchantment.DEPTH_STRIDER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FALL, 32767, true);
		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		boots.setItemMeta(meta);

		return boots;

	}

	public ItemStack getSword() {

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = sword.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.SWEEPING_EDGE, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		sword.setItemMeta(meta);

		return sword;

	}

	public ItemStack getAxe() {

		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = axe.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		axe.setItemMeta(meta);

		return axe;

	}

	public ItemStack getAxe2() {

		ItemStack axe2 = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = axe2.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		axe2.setItemMeta(meta);

		return axe2;

	}

	public ItemStack getPickaxe() {

		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = pickaxe.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		pickaxe.setItemMeta(meta);

		return pickaxe;

	}

	public ItemStack getPickaxe2() {

		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}

	public ItemStack getHoe() {

		ItemStack item = new ItemStack(Material.DIAMOND_HOE);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}

	public ItemStack getShovel() {

		ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}

	public ItemStack getShovel2() {

		ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, 32767, true);

		if (enchantstoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (attributestoggle == false) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}
}