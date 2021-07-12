package me.dkim19375.MagicItems.CMD;

import me.dkim19375.MagicItems.Main;
import me.dkim19375.MagicItems.managers.ItemManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MagicItemsCMD implements CommandExecutor {

	public Main main;

	public MagicItemsCMD(Main main) {
		this.main = main;
	}

	private boolean enchantstoggle = false;
	private boolean attributestoggle = true;
	private boolean vanishingtoggle = true;
	private boolean bindingtoggle = false;

	public String getUpdateCheckS1() { return main.getPluginVersion1(); }
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
	public int getProtection() { return main.getProtection(); }
	public int getFire_protection() { return main.getFire_protection(); }
	public int getFeather_falling() { return main.getFeather_falling(); }
	public int getBlast_protection() { return main.getBlast_protection(); }
	public int getProjectile_protection() { return main.getProjectile_protection(); }
	public int getRespiration() { return main.getRespiration(); }
	public int getAqua_affinity() { return main.getAqua_affinity(); }
	public int getThorns() { return main.getThorns(); }
	public int getDepth_strider() { return main.getDepth_strider(); }
	public int getFrost_walker() { return main.getFrost_walker(); }
	public int getBinding_curse() { return main.getBinding_curse(); }
	public int getSharpness() { return main.getSharpness(); }
	public int getSmite() { return main.getSmite(); }
	public int getBane_of_arthropods() { return main.getBane_of_arthropods(); }
	public int getKnockback() { return main.getKnockback(); }

	public int getFire_aspect() { return main.getFire_aspect(); }
	public int getLooting() { return main.getLooting(); }
	public int getSweeping() { return main.getSweeping(); }
	public int getEfficiency() { return main.getEfficiency(); }
	public int getSilk_touch() { return main.getSilk_touch(); }
	public int getUnbreaking() { return main.getUnbreaking(); }
	public int getFortune() { return main.getFortune(); }
	public int getPower() { return main.getPower(); }
	public int getPunch() { return main.getPunch(); }
	public int getFlame() { return main.getFlame(); }
	public int getInfinity() { return main.getInfinity(); }
	public int getLuck_of_the_sea() { return main.getLuck_of_the_sea(); }
	public int getLure() { return main.getLure(); }
	public int getMending() { return main.getMending(); }
	public int getVanishing_curse() { return main.getVanishing_curse(); }
	public int getChanneling() { return main.getChanneling(); }
	public int getImpaling() { return main.getImpaling(); }
	public int getLoyalty() { return main.getLoyalty(); }
	public int getMultishot() { return main.getMultishot(); }
	public int getPiercing() { return main.getPiercing(); }
	public int getQuick_charge() { return main.getQuick_charge(); }
	public int getSoul_speed() { return main.getSoul_speed(); }

	void getItems(Player player, ItemStack getter) {
		if (player.getInventory().firstEmpty() == -1) {
			Location loc = player.getLocation();
			World world = player.getWorld();
			world.dropItemNaturally(loc, getter);
		} else {
			player.getInventory().addItem(getter);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("magicitems") || label.equalsIgnoreCase("mi")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Too little arguments.");
				sendHelpMessage(sender);
				return true;
			}
			if (args.length > 2) {
				sender.sendMessage(ChatColor.RED + "Too many arguments.");
				sendHelpMessage(sender);
				return true;
			}
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("vanishing")) {

					if (args[1].equalsIgnoreCase("help")) {
						sendVanishingHelpMsg(sender);
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
						sendVanishingHelpMsg(sender);
						return true;
					}

					sender.sendMessage(ChatColor.RED + "Invalid arguments.");
					sendVanishingHelpMsg(sender);
					return true;
				}

				if (args[0].equalsIgnoreCase("binding")) {

					if (args[1].equalsIgnoreCase("help")) {
						sendBindingHelpMsg(sender);
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
 						sendBindingHelpMsg(sender);
						return true;
					}

					sender.sendMessage(ChatColor.RED + "Invalid arguments.");
					sendBindingHelpMsg(sender);
					return true;
				}

				if (args[0].equalsIgnoreCase("enchants")) {

					if (args[1].equalsIgnoreCase("help")) {
						sendEnchantsHelpMsg(sender);
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
						sendEnchantsHelpMsg(sender);

						return true;
					}

					sender.sendMessage(ChatColor.RED + "Invalid arguments.");
					sendEnchantsHelpMsg(sender);
					return true;
				}
				if (args[0].equalsIgnoreCase("attributes")) {

					if (args[1].equalsIgnoreCase("help")) {
						sendAttributesHelpMsg(sender);
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
						sendAttributesHelpMsg(sender);
						return true;
					}

					sender.sendMessage(ChatColor.RED + "Invalid arguments.");
					sendAttributesHelpMsg(sender);
				}
				return true;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				sender.sendMessage(ChatColor.GOLD + this.ReloadConfig());
				this.ReloadConfig();
				sender.sendMessage(ChatColor.GOLD + this.ReloadedConfig());
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
				sendHelpMessage(sender);
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
				ItemManagers im = new ItemManagers(main);

				player.sendMessage(ChatColor.GOLD + "You have been received the items.");
				getItems(player, im.getHelmet(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getChestplate(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getLeggings(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getBoots(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getSword(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getAxe(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getAxe2(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getPickaxe(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getPickaxe2(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getShovel(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getShovel2(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				getItems(player, im.getHoe(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				if (Bukkit.getVersion().contains("1.14") || Bukkit.getVersion().contains("1.15") || Bukkit.getVersion().contains("1.16")) {
					getItems(player, im.getCrossbow(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				}
				getItems(player, im.getBow(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				for (int i = 0; i < 64; i++) {
					getItems(player, im.getArrows(enchantstoggle, attributestoggle));
				}
				getItems(player, im.getElytra(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				for (int i = 0; i < 64; i++) {
					getItems(player, im.getRockets(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				}
				getItems(player, im.getFlintSteel(vanishingtoggle, bindingtoggle, enchantstoggle, attributestoggle));
				return true;
			}
		}
		return false;
	}





	private void sendHelpMessage(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "Usage:");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems help");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems give");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems version");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems enchants");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems attributes");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems binding");
	}

	private void sendVanishingHelpMsg(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "Usage:");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing ?");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing help");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing toggle");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems vanishing status");
	}

	private void sendBindingHelpMsg(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "Usage:");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems binding ?");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems binding help");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems binding toggle");
		sender.sendMessage(ChatColor.GREEN + "- /magicitems binding status");
	}

	private void sendEnchantsHelpMsg(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "Usage:");
		sender.sendMessage(ChatColor.GREEN + "- /enchants enchants ?");
		sender.sendMessage(ChatColor.GREEN + "- /enchants enchants help");
		sender.sendMessage(ChatColor.GREEN + "- /enchants enchants toggle");
		sender.sendMessage(ChatColor.GREEN + "- /enchants enchants status");
	}

	private void sendAttributesHelpMsg(CommandSender sender) {
		sender.sendMessage(ChatColor.GREEN + "Usage:");
		sender.sendMessage(ChatColor.GREEN + "- /enchants attributes ?");
		sender.sendMessage(ChatColor.GREEN + "- /enchants attributes help");
		sender.sendMessage(ChatColor.GREEN + "- /enchants attributes toggle");
		sender.sendMessage(ChatColor.GREEN + "- /enchants attributes status");
	}
}