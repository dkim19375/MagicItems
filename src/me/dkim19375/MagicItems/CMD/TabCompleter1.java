package me.dkim19375.MagicItems.CMD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class TabCompleter1 implements TabCompleter {
	
	private final HashMultimap<String, String> completesListMap;
	
	public TabCompleter1() {
		completesListMap = HashMultimap.create();
		add("core", "help", "give", "version", "enchants", "attributes", "vanishing", "binding");
		add("extra", "toggle", "status", "help");
	}
	
	private void add(String key, String... args) {
		completesListMap.putAll(key, Arrays.asList(args));
	}
	
	private List<String> getPartial(String token, Iterable<String> collection) {
		return StringUtil.copyPartialMatches(token, collection, new ArrayList<>());
	}
	
	public
	@Override List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		switch (args.length) {
			case 0: return Lists.newArrayList(completesListMap.get("core"));
			case 1: return getPartial(args[0], completesListMap.get("core"));
			case 2:
				if (args[0].equalsIgnoreCase("enchants") || args[0].equalsIgnoreCase("attributes") || args[0].equalsIgnoreCase("vanishing") || args[0].equalsIgnoreCase("binding")) {
					if (completesListMap.get("core").contains(args[0].toLowerCase())) {
						return getPartial(args[1], completesListMap.get("extra"));
					}
				}
			default: return ImmutableList.of();
		}
	}
}
