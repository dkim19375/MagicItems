package me.dkim19375.magicitems.command

import me.dkim19375.dkimbukkitcore.data.HelpMessage
import me.dkim19375.dkimbukkitcore.function.showHelpMessage
import me.dkim19375.magicitems.MagicItems
import me.dkim19375.magicitems.util.*
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import kotlin.reflect.KMutableProperty0

class MagicItemsCMD(private val plugin: MagicItems) : CommandExecutor {
    private val itemManager = plugin.itemManager

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendHelpMessage(label)
            return true
        }
        when (args[0].lowercase()) {
            "help" -> {
                sender.sendHelpMessage(label, null, args.getOrNull(1)?.toIntOrNull() ?: 1)
                return true
            }
            "reload" -> {
                if (!sender.hasPermission(Permissions.RELOAD)) {
                    sender.sendHelpMessage(label, ErrorType.NO_PERMISSION)
                    return true
                }
                plugin.reloadConfig()
                sender.sendMessage("${ChatColor.GREEN}Successfully reloaded config file!")
                return true
            }
            "give" -> {
                if (!sender.hasPermission(Permissions.GIVE)) {
                    sender.sendHelpMessage(label, ErrorType.NO_PERMISSION)
                    return true
                }
                if (sender !is Player) {
                    sender.sendHelpMessage(label, ErrorType.MUST_BE_PLAYER)
                    return true
                }
                sender.sendMessage("${ChatColor.GREEN}Successfully gave magical items!")
                sender.inventory.addItem(*itemManager.getItems())
                return true
            }
            "version" -> {
                if (!sender.hasPermission(Permissions.VERSION)) {
                    sender.sendHelpMessage(label, ErrorType.NO_PERMISSION)
                    return true
                }
                sender.sendMessage("${ChatColor.GOLD}Current version: ${plugin.description.version}")
                sender.sendMessage("${ChatColor.GOLD}Fetching latest version...")
                plugin.getVersion({ version ->
                    sender.sendMessage("${ChatColor.AQUA}Latest version: $version")
                    if (version != plugin.description.version) {
                        sender.sendMessage("${ChatColor.RED}You are outdated!")
                        return@getVersion
                    }
                    sender.sendMessage("${ChatColor.GREEN}You are up to date!")
                }) {
                    sender.sendMessage("${ChatColor.RED}Error! Could not get latest version!")
                }
                return true
            }
            "enchants" -> {
                if (!sender.hasPermission(Permissions.ENCHANTS)) {
                    sender.sendHelpMessage(label, ErrorType.NO_PERMISSION)
                    return true
                }
                onToggleCommand(label, sender, itemManager::enchantsToggle, args.getOrNull(1), "Enchants")
                return true
            }
            "attributes" -> {
                if (!sender.hasPermission(Permissions.ATTRIBUTES)) {
                    sender.sendHelpMessage(label, ErrorType.NO_PERMISSION)
                    return true
                }
                onToggleCommand(label, sender, itemManager::attributesToggle, args.getOrNull(1), "Attributes")
                return true
            }
            "vanishing" -> {
                if (!sender.hasPermission(Permissions.VANISHING)) {
                    sender.sendHelpMessage(label, ErrorType.NO_PERMISSION)
                    return true
                }
                onToggleCommand(label, sender, itemManager::vanishingToggle, args.getOrNull(1), "Vanishing")
                return true
            }
            "binding" -> {
                if (!sender.hasPermission(Permissions.BINDING)) {
                    sender.sendHelpMessage(label, ErrorType.NO_PERMISSION)
                    return true
                }
                onToggleCommand(label, sender, itemManager::bindingToggle, args.getOrNull(1), "Binding")
                return true
            }
            else -> {
                sender.sendHelpMessage(label, ErrorType.INVALID_ARG)
                return true
            }
        }
    }

    private fun onToggleCommand(label: String, sender: CommandSender, variable: KMutableProperty0<Boolean>, arg: String?, name: String) {
        val commands = listOf(
            HelpMessage(
                "${name.lowercase()} help",
                "Show this help message for the $name toggle",
                Permissions.valueOf(name.uppercase()).perm
            ),
            HelpMessage(
                "${name.lowercase()} toggle [true|false|yes|no|etc|etc]",
                "Toggle the $name option",
                Permissions.valueOf(name.uppercase()).perm
            ),
            HelpMessage(
                "${name.lowercase()} status",
                "Show the status of the $name toggle",
                Permissions.valueOf(name.uppercase()).perm
            ),
        )
        when (arg?.lowercase()) {
            null, "help" -> {
                sender.showHelpMessage(label, null, 1, commands, plugin)
                return
            }
            "toggle" -> {
                println("to boolean: ${arg.toBooleanNonStrict()}")
                val boolean = arg.toBooleanNonStrict() ?: !variable.get()
                variable.set(boolean)
                sender.sendMessage("${ChatColor.GREEN}Successfully set $name to $boolean!")
                return
            }
            "status" -> {
                sender.sendMessage("${ChatColor.GOLD}$name is set to ${variable.get()}!")
                return
            }
            else -> {
                sender.showHelpMessage(label, "Invalid argument!", 1, commands, plugin)
            }
        }
    }
}