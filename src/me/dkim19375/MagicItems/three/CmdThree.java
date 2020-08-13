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

public class CmdThree implements CommandExecutor {
	private boolean enchantstoggle = false;
	private boolean attributestoggle = true;
	private boolean vanishingtoggle = true;
	private boolean bindingtoggle = false;

	
	boolean getItems(Location loc, World world, Player player, ItemStack getter) {
		if (player.getInventory().firstEmpty() == -1) {
			loc = player.getLocation();
			world = player.getWorld();
			world.dropItemNaturally(loc, getter);
		} else {
			player.getInventory().addItem(getter);
		}
		return false;
	}
	
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
							if (sender.hasPermission("magicitems.vanishing.status")) {
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
					sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems binding");
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
						
						getItems(player.getLocation(), player.getWorld(), player, getHelmet());
						getItems(player.getLocation(), player.getWorld(), player, getChestplate());
						getItems(player.getLocation(), player.getWorld(), player, getLeggings());
						getItems(player.getLocation(), player.getWorld(), player, getBoots());
						getItems(player.getLocation(), player.getWorld(), player, getSword());
						getItems(player.getLocation(), player.getWorld(), player, getAxe());
						getItems(player.getLocation(), player.getWorld(), player, getAxe2());
						getItems(player.getLocation(), player.getWorld(), player, getPickaxe());
						getItems(player.getLocation(), player.getWorld(), player, getPickaxe2());
						getItems(player.getLocation(), player.getWorld(), player, getShovel());
						getItems(player.getLocation(), player.getWorld(), player, getShovel2());
						getItems(player.getLocation(), player.getWorld(), player, getHoe());
						getItems(player.getLocation(), player.getWorld(), player, getBow());
						getItems(player.getLocation(), player.getWorld(), player, getArrows());
						getItems(player.getLocation(), player.getWorld(), player, getPickaxe2());
						for (int i = 0; i < 64; i++) {
							getItems(player.getLocation(), player.getWorld(), player, getArrows());
						}
						getItems(player.getLocation(), player.getWorld(), player, getElytra());
						for (int i = 0; i < 64; i++) {
							getItems(player.getLocation(), player.getWorld(), player, getRockets());
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

		meta.addEnchant(Enchantment.WATER_WORKER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.OXYGEN, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.WATER_WORKER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.OXYGEN, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.WATER_WORKER, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 32767, true);
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.OXYGEN, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.SWEEPING_EDGE, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 32767, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1000, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_ALL, 32767, true);
		meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.DIG_SPEED, 32767, true);
		meta.addEnchant(Enchantment.SILK_TOUCH, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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

		meta.addEnchant(Enchantment.ARROW_FIRE, 32767, true);
		meta.addEnchant(Enchantment.ARROW_INFINITE, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.ARROW_DAMAGE, 32767, true);
		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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
	
	public ItemStack getArrows() {

		ItemStack arrows = new ItemStack(Material.ARROW);
		ItemMeta meta = arrows.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);
		
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		
		arrows.setItemMeta(meta);

		return arrows;

	}	
	
	public ItemStack getElytra() {

		ItemStack elytra = new ItemStack(Material.ELYTRA);
		ItemMeta meta = elytra.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.DURABILITY, 32767, true);
		meta.addEnchant(Enchantment.MENDING, 32767, true);
		meta.addEnchant(Enchantment.THORNS, 32767, true);
		
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}	
		if (bindingtoggle) {
			meta.addEnchant(Enchantment.BINDING_CURSE, 32767, true);
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
	
	public ItemStack getRockets() {

		ItemStack rockets = new ItemStack(Material.FIREWORK_ROCKET);
		ItemMeta meta = rockets.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);
		
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, 32767, true);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		
		rockets.setItemMeta(meta);

		return rockets;

	}
	
}

