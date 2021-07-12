package me.dkim19375.magicitems.util

import me.dkim19375.dkimbukkitcore.data.HelpMessage
import me.dkim19375.dkimbukkitcore.function.showHelpMessage
import me.dkim19375.magicitems.MagicItems
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

private val plugin: MagicItems by lazy { JavaPlugin.getPlugin(MagicItems::class.java) }

private val commands = listOf(
    HelpMessage("help", "Send help message", Permissions.COMMAND.perm),
    HelpMessage("reload", "Reload the plugin's config file", Permissions.RELOAD.perm),
    HelpMessage("give", "Give items", Permissions.GIVE.perm),
    HelpMessage("version", "Check for version updates", Permissions.VERSION.perm),
    HelpMessage("enchants [help|toggle|status]", "Toggle enchants", Permissions.ENCHANTS.perm),
    HelpMessage("attributes [help|toggle|status]", "Toggle attributes", Permissions.ATTRIBUTES.perm),
    HelpMessage("vanishing [help|toggle|status]", "Toggle vanishing", Permissions.VANISHING.perm),
    HelpMessage("binding [help|toggle|status]", "Toggle binding", Permissions.BINDING.perm),
)

fun CommandSender.hasPermission(permission: Permissions): Boolean = hasPermission(permission.perm)

fun CommandSender.sendHelpMessage(label: String, error: ErrorType? = null, page: Int = 1) {
    showHelpMessage(label, error?.description, page, commands, plugin)
}