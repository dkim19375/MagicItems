package me.dkim19375.MagicItems.CMD;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCompleter2 implements TabCompleter {
	List<String> arguments = new ArrayList<String>();
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (arguments.isEmpty()) {
			arguments.add("toggle"); arguments.add("status");
			arguments.add("help");
		}
		
		List<String> result = new ArrayList<String>();
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("enchants") || args[0].equalsIgnoreCase("attributes") || args[0].equalsIgnoreCase("vanishing") || args[0].equalsIgnoreCase("binding")) {
				for (String a : arguments) {
					if (a.toLowerCase().startsWith(args[0].toLowerCase()))
						result.add(a);
				}
				return result;
			}
		}
		
		
		return null;
	}
}
