package me.dkim19375.magicitems.command

import org.bukkit.command.TabCompleter
import com.google.common.collect.HashMultimap
import org.bukkit.util.StringUtil
import com.google.common.collect.Lists
import com.google.common.collect.ImmutableList
import me.dkim19375.magicitems.util.Permissions
import me.dkim19375.magicitems.util.hasPermission
import me.dkim19375.magicitems.util.toPermissions
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import java.util.*

class MITabCompleter : TabCompleter {

    private fun getCoreCommands(sender: CommandSender): List<String>? {
        val commands = mapOf(
            "help" to Permissions.COMMAND,
            "reload" to Permissions.RELOAD,
            "give" to Permissions.GIVE,
            "version" to Permissions.VERSION,
            "enchants" to Permissions.ENCHANTS,
            "attributes" to Permissions.ATTRIBUTES,
            "vanishing" to Permissions.VANISHING,
            "binding" to Permissions.BINDING
        )
        val new = commands.mapNotNull { (command, permission) ->
            if (sender.hasPermission(permission)) command else null
        }
        if (new.isEmpty()) {
            return null
        }
        return new
    }

    private fun getToggleCommands(sender: CommandSender, arg: String): List<String>? {
        if (!sender.hasPermission(arg.uppercase().toPermissions() ?: return null)) {
            return null
        }
        return listOf("help", "toggle", "status")
    }

    private fun getPartial(token: String, collection: Iterable<String>): List<String> {
        return StringUtil.copyPartialMatches(token, collection, mutableListOf())
    }

    override fun onTabComplete(sender: CommandSender, cmd: Command, label: String, args: Array<String>): List<String>? {
        return when (args.size) {
            0 -> getCoreCommands(sender)
            1 -> getPartial(args[0], getCoreCommands(sender) ?: return null)
            2 -> {
                if (!setOf("enchants", "attributes", "vanishing", "binding").contains(args[0].lowercase())) {
                    return null
                }
                if (!(getCoreCommands(sender) ?: return null).contains(args[0].lowercase())) {
                    return null
                }
                return getPartial(args[1], getToggleCommands(sender, args[0]) ?: return null)
            }
            else -> null
        }
    }
}