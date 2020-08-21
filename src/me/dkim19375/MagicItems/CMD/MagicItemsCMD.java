package me.dkim19375.MagicItems.CMD;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
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

public class MagicItemsCMD implements CommandExecutor {
	
	public Main main;
	
	public MagicItemsCMD(Main main) {
		this.main = main;
	}
	
	private boolean enchantstoggle = false;
	private boolean attributestoggle = true;
	private boolean vanishingtoggle = true;
	private boolean bindingtoggle = false;
	
	public String getUpdateCheckS1() {		
		return main.getPluginVersion1();
	}
	public String getUpdateCheckS2() {		
		return main.getPluginVersion2();
	}
	public String getUpdateCheckS3() {		
		return main.getPluginVersion3();
	}
	public String getUpdateCheckS4() {		
		return main.getPluginVersion4();
	}
	public String ReloadConfig() {		
		return main.getReloadConfig();
	}
	public String ReloadedConfig() {		
		return main.getReloadedConfig();
	}
	public String getConfigValue(String value) {		
		return main.getConfigValue(value);
	}
	
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
				sender.sendMessage(ChatColor.GREEN + "- /magicitems version");
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
				sender.sendMessage(ChatColor.GREEN + "- /magicitems version");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing");
				sender.sendMessage(ChatColor.GREEN + "- /magicitems binding");
				return true;
			}
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
					return true;
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
							if (vanishingtoggle) {
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
					return true;
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
					return true;
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
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					sender.sendMessage(ChatColor.GOLD + this.ReloadConfig());
					this.ReloadConfig();
					sender.sendMessage(ChatColor.GOLD + this.ReloadedConfig());  
					return true;
				}
				if (args[0].equalsIgnoreCase("testing")) {
					sender.sendMessage(ChatColor.GOLD + this.getConfigValue(args[1]));
					return true;
				}
				if (args[0].equalsIgnoreCase("version")) {
					sender.sendMessage(ChatColor.GOLD + this.getUpdateCheckS1());
					sender.sendMessage(ChatColor.GOLD + this.getUpdateCheckS2());
					sender.sendMessage(ChatColor.GOLD + this.getUpdateCheckS3());
					sender.sendMessage(ChatColor.GOLD + this.getUpdateCheckS4());
					return true;
				}
				if (args[0].equalsIgnoreCase("help")) {
					sender.sendMessage(ChatColor.GREEN + "Usage:");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems help");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems give");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems version");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing");
					sender.sendMessage(ChatColor.GREEN + "- /magicitems binding");
					return true;
				}
				if (args[0].equalsIgnoreCase("give")) {
					if (!(sender.hasPermission("magicitems.give"))) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
						return true;
					}
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
					if (Bukkit.getVersion().contains("1.14") || Bukkit.getVersion().contains("1.15") || Bukkit.getVersion().contains("1.16")) {
						getItems(player.getLocation(), player.getWorld(), player, getCrossbow());
					}
					getItems(player.getLocation(), player.getWorld(), player, getBow());
					for (int i = 0; i < 64; i++) {
						getItems(player.getLocation(), player.getWorld(), player, getArrows());
					}
					getItems(player.getLocation(), player.getWorld(), player, getElytra());
					for (int i = 0; i < 64; i++) {
						getItems(player.getLocation(), player.getWorld(), player, getRockets());
					}
					getItems(player.getLocation(), player.getWorld(), player, getFlintSteel());
					return true;
				}
			}
		}
		return false;
	}

	public ItemStack getHelmet() {		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_HELMET;
		} else mat = Material.DIAMOND_HELMET;
		
		ItemStack helmet = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_CHESTPLATE;
		} else mat = Material.DIAMOND_CHESTPLATE;

		ItemStack chestplate = new ItemStack(mat);
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

		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_LEGGINGS;
		} else mat = Material.DIAMOND_LEGGINGS;

		ItemStack leggings = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_BOOTS;
		} else mat = Material.DIAMOND_BOOTS;

		ItemStack boots = new ItemStack(mat);
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
		if (Bukkit.getVersion().contains("1.16")) {
			meta.addEnchant(Enchantment.SOUL_SPEED, Main.soul_speed, true);
		}		
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_SWORD;
		} else mat = Material.DIAMOND_SWORD;

		ItemStack sword = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_AXE;
		} else mat = Material.DIAMOND_AXE;

		ItemStack axe = new ItemStack(mat);
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

		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_AXE;
		} else mat = Material.DIAMOND_AXE;

		ItemStack axe2 = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_PICKAXE;
		} else mat = Material.DIAMOND_PICKAXE;

		ItemStack pickaxe = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_PICKAXE;
		} else mat = Material.DIAMOND_PICKAXE;

		ItemStack item = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_HOE;
		} else mat = Material.DIAMOND_HOE;

		ItemStack item = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_SHOVEL;
		} else mat = Material.DIAMOND_SHOVEL;

		ItemStack item = new ItemStack(mat);
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
		
		Material mat;
		if (Bukkit.getVersion().contains("1.16")) {
		  mat = Material.NETHERITE_SHOVEL;
		} else mat = Material.DIAMOND_SHOVEL;

		ItemStack item = new ItemStack(mat);
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
		meta.addEnchant(Enchantment.ARROW_KNOCKBACK, Main.punch, true);
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
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		
		rockets.setItemMeta(meta);

		return rockets;

	}
	
	public ItemStack getFlintSteel() {

		ItemStack flintsteel = new ItemStack(Material.FLINT_AND_STEEL);
		ItemMeta meta = flintsteel.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);
		
		if (!this.enchantstoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		if (vanishingtoggle) {
			meta.addEnchant(Enchantment.VANISHING_CURSE, Main.vanishing_curse, true);
		}
		if (!this.attributestoggle) {
			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		}
		
		flintsteel.setItemMeta(meta);

		return flintsteel;

	}
	
	public ItemStack getCrossbow() {

		ItemStack Crossbow = new ItemStack(Material.CROSSBOW);
		ItemMeta meta = Crossbow.getItemMeta();

		List<String> lore = new ArrayList<>();
		lore.add("");
		lore.add(ChatColor.BOLD + "" + ChatColor.ITALIC + "Magical Item");
		meta.setLore(lore);

		meta.addEnchant(Enchantment.QUICK_CHARGE, Main.quick_charge, true);
		meta.addEnchant(Enchantment.MULTISHOT, Main.multishot, true);
		meta.addEnchant(Enchantment.PIERCING, Main.piercing, true);
		meta.addEnchant(Enchantment.DURABILITY, Main.unbreaking, true);
		meta.addEnchant(Enchantment.MENDING, Main.mending, true);
		
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

		Crossbow.setItemMeta(meta);

		return Crossbow;

	}
}
