package me.dkim19375.MagicItems.fourfive;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class FourFiveVanishingTab implements TabCompleter {	
	List<String> arguments = new ArrayList<String>();
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (arguments.isEmpty()) {
			arguments.add("help"); arguments.add("toggle");
			arguments.add("status"); arguments.add("?");
		}
		
		List<String> result = new ArrayList<String>();
		if (args.length == 2 || args[0].equalsIgnoreCase("vanishing")) {
			for (String a : arguments) {
				if (a.toLowerCase().startsWith(args[1].toLowerCase()))
					result.add(a);
			}
			return result;
		}
		
		
		return null;
	}
}