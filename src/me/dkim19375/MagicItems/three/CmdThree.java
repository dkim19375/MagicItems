package me.dkim19375.MagicItems.three;

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

import me.dkim19375.MagicItems.Main;

public class CmdThree implements CommandExecutor {
	private boolean enchantstoggle = false;
	private boolean attributestoggle = true;
	private boolean vanishingtoggle = true;
	private boolean bindingtoggle = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("magicitems")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Too little arguments.");
				sender.sendMessage(ChatColor.GREEN + "Usage:");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems help");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems give");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems binding");
				return true;
			}
			if (args.length > 2) {
				sender.sendMessage(ChatColor.RED + "Too many arguments.");
				sender.sendMessage(ChatColor.GREEN + "Usage:");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems help");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems give");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems binding");
				return true;
			} else {
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("vanishing")) {	
						
						if (args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing ?");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing help");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing toggle");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing status");
							return true;
						}
						
						if (args[1].equalsIgnoreCase("toggle")) {
							if (sender.hasPermission("magicitems.attributes.status")) {
								if (vanishingtoggle) {
									vanishingtoggle = false;
									sender.sendMessage(ChatColor.GOLD + "The Vanishing Curse on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									vanishingtoggle = true;
									sender.sendMessage(ChatColor.GOLD + "The Vanishing Curse on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}
								return true;
							} else {
								sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
							}							
						}
						
						if (args[1].equalsIgnoreCase("status")) {
							if (sender.hasPermission("magicitems.vanishing.status")) {
								if (vanishingtoggle) {
									sender.sendMessage(ChatColor.GOLD + "The Vanishing Curse on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");									
								} else {
									sender.sendMessage(ChatColor.GOLD + "The Vanishing Curse on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								}
								return true;
							}
							sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
						}
						
						if (args[1].equalsIgnoreCase("?") || args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing ?");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing help");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing toggle");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing status");
							
							return true;
						}
					
						sender.sendMessage(ChatColor.RED + "Invalid arguments.");
						sender.sendMessage(ChatColor.GREEN + "Usage:");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing ?");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing help");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing toggle");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing status");
						
					}
					
					if (args[0].equalsIgnoreCase("binding")) {	
						
						if (args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding ?");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding help");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding toggle");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding status");
							return true;
						}
						
						if (args[1].equalsIgnoreCase("toggle")) {
							if (sender.hasPermission("magicitems.binding.status")) {
								if (bindingtoggle) {
									bindingtoggle = false;
									sender.sendMessage(ChatColor.GOLD + "The Binding Curse on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									bindingtoggle = true;
									sender.sendMessage(ChatColor.GOLD + "The Binding Curse on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}
								return true;
							} else {
								sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
							}							
						}
						
						if (args[1].equalsIgnoreCase("status")) {
							if (sender.hasPermission("magicitems.binding.status")) {
								if (bindingtoggle) {
									sender.sendMessage(ChatColor.GOLD + "The Binding Curse on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");									
								} else {
									sender.sendMessage(ChatColor.GOLD + "The Binding Curse on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								}
								return true;
							}
							sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
						}
						
						if (args[1].equalsIgnoreCase("?") || args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding ?");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding help");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding toggle");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems binding status");
							
							return true;
						}
					
						sender.sendMessage(ChatColor.RED + "Invalid arguments.");
						sender.sendMessage(ChatColor.GREEN + "Usage:");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems binding ?");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems binding help");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems binding toggle");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems binding status");
						
					}
				
					if (args[0].equalsIgnoreCase("enchants")) {	
						
						if (args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /enchants vanishing ?");
							sender.sendMessage(ChatColor.GREEN + "- /enchants vanishing help");
							sender.sendMessage(ChatColor.GREEN + "- /enchants vanishing toggle");
							sender.sendMessage(ChatColor.GREEN + "- /enchants vanishing status");
							return true;
						}
						
						if (args[1].equalsIgnoreCase("toggle")) {
							if (sender.hasPermission("magicitems.enchants.toggle")) {
								if (enchantstoggle) {
									enchantstoggle = false;
									sender.sendMessage(ChatColor.GOLD + "Enchants on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									enchantstoggle = true;
									sender.sendMessage(ChatColor.GOLD + "Enchants on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}
								return true;
							} else {
								sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
							}

						}
						
						if (args[1].equalsIgnoreCase("status")) {
							if (sender.hasPermission("magicitems.enchants.status")) {
								if (enchantstoggle) {
									sender.sendMessage(ChatColor.GOLD + "Enchants on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");									
								} else {
									sender.sendMessage(ChatColor.GOLD + "Enchants Curse on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								}
								return true;
							} else {
								sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
							}

						}
						
						if (args[1].equalsIgnoreCase("?") || args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants ?");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants help");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants toggle");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants status");
							
							return true;
						}
					
						sender.sendMessage(ChatColor.RED + "Invalid arguments.");
						sender.sendMessage(ChatColor.GREEN + "Usage:");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants ?");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants help");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants toggle");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants status");
					
					}
					if (args[0].equalsIgnoreCase("attributes")) {	
						
						if (args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /enchants attributes ?");
							sender.sendMessage(ChatColor.GREEN + "- /enchants attributes help");
							sender.sendMessage(ChatColor.GREEN + "- /enchants attributes toggle");
							sender.sendMessage(ChatColor.GREEN + "- /enchants attributes status");
							return true;
						}
						
						if (args[1].equalsIgnoreCase("toggle")) {
							if (sender.hasPermission("magicitems.attributes.toggle")) {
								if (attributestoggle) {
									attributestoggle = false;
									sender.sendMessage(ChatColor.GOLD + "Attributes on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								} else {
									attributestoggle = true;
									sender.sendMessage(ChatColor.GOLD + "Attributes on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");
								}
								return true;
							} else {
								sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
							}
						}
						
						if (args[1].equalsIgnoreCase("status")) {
							if (sender.hasPermission("magicitems.attributes.status")) {
								if (attributestoggle) {
									sender.sendMessage(ChatColor.GOLD + "Attributes on Magic Tools: " + ChatColor.GREEN + " ON" + ChatColor.GOLD + "!");									
								} else {
									sender.sendMessage(ChatColor.GOLD + "Attributes Curse on Magic Tools: " + ChatColor.RED + " OFF" + ChatColor.GOLD + "!");
								}
								return true;
							} else {
								sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
							}
						}
						
						if (args[1].equalsIgnoreCase("?") || args[1].equalsIgnoreCase("help")) {
							sender.sendMessage(ChatColor.GREEN + "Usage:");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes ?");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes help");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes toggle");
							sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes status");
							
							return true;
						}
					
						sender.sendMessage(ChatColor.RED + "Invalid arguments.");
						sender.sendMessage(ChatColor.GREEN + "Usage:");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes ?");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes help");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes toggle");
						sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes status");
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
						player.sendMessage(ChatColor.GOLD + "You have been received the items.");
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
							world.dropItemNaturally(loc, getShovel2());
						} else {
							player.getInventory().addItem(getShovel2());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getHoe());
						} else {
							player.getInventory().addItem(getHoe());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getBow());
						} else {
							player.getInventory().addItem(getBow());
						}
						if (player.getInventory().firstEmpty() == -1) {
							Location loc = player.getLocation();
							World world = player.getWorld();
							world.dropItemNaturally(loc, getElytra());
						} else {
							player.getInventory().addItem(getElytra());
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

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.WATER_WORKER, Main.aqua_affinity, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Main.blast_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, Main.fire_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, Main.projectile_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Main.protection, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.OXYGEN, Main.respiration, true);
		meta.addEnchant(Enchantment.THORNS, Main.thorns, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		helmet.setItemMeta(meta);

		return helmet;

	}

	public ItemStack getChestplate() {

		ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = chestplate.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.WATER_WORKER, Main.aqua_affinity, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Main.blast_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, Main.fire_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, Main.projectile_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Main.protection, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.OXYGEN, Main.respiration, true);
		meta.addEnchant(Enchantment.THORNS, Main.thorns, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		chestplate.setItemMeta(meta);

		return chestplate;

	}

	public ItemStack getLeggings() {

		ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemMeta meta = leggings.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.WATER_WORKER, Main.aqua_affinity, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, Main.blast_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, Main.fire_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, Main.projectile_protection, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Main.protection, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.OXYGEN, Main.respiration, true);
		meta.addEnchant(Enchantment.THORNS, Main.thorns, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		leggings.setItemMeta(meta);

		return leggings;

	}

	public ItemStack getBoots() {

		ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta meta = boots.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

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
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		boots.setItemMeta(meta);

		return boots;

	}

	public ItemStack getSword() {

		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = sword.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, Main.fire_aspect, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, Main.looting, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.SWEEPING_EDGE, Main.sweeping, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}	
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		sword.setItemMeta(meta);

		return sword;

	}

	public ItemStack getAxe() {

		ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = axe.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}	
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		axe.setItemMeta(meta);

		return axe;

	}

	public ItemStack getAxe2() {

		ItemStack axe2 = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta meta = axe2.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, Main.silk_touch, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}	
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		axe2.setItemMeta(meta);

		return axe2;

	}

	public ItemStack getPickaxe() {

		ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = pickaxe.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		pickaxe.setItemMeta(meta);

		return pickaxe;

	}

	public ItemStack getPickaxe2() {

		ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Has silk touch");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, Main.silk_touch, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}

	public ItemStack getHoe() {

		ItemStack item = new ItemStack(Material.DIAMOND_HOE);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}	
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}

	public ItemStack getShovel() {

		ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}	
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}

	public ItemStack getShovel2() {

		ItemStack item = new ItemStack(Material.DIAMOND_SHOVEL);
		ItemMeta meta = item.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		lore.add(ChatColor.GOLD + "" + ChatColor.ITALIC + "Has silk touch");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Main.bane_of_arthropods, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Main.fortune, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, Main.sharpness, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, Main.smite, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.DIG_SPEED, Main.efficiency, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, Main.silk_touch, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}	
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		item.setItemMeta(meta);

		return item;

	}
	
	public ItemStack getBow() {

		ItemStack bow = new ItemStack(Material.BOW);
		ItemMeta meta = bow.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.ARROW_FIRE, Main.flame, true);
		meta.addEnchant(Enchantment.ARROW_INFINITE, Main.infinity, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.ARROW_DAMAGE, Main.power, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		bow.setItemMeta(meta);

		return bow;

	}
	
	public ItemStack getElytra() {

		ItemStack elytra = new ItemStack(Material.ELYTRA);
		ItemMeta meta = elytra.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		meta.addEnchant(Enchantment.THORNS, Main.thorns, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, Main.binding_curse, true);
		}
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		meta.setUnbreakable(true);

		elytra.setItemMeta(meta);

		return elytra;

	}
	
}
