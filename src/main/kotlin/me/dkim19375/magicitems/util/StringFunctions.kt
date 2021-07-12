package me.dkim19375.magicitems.util

import me.dkim19375.magicitems.MagicItems
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level

private val plugin: MagicItems by lazy { JavaPlugin.getPlugin(MagicItems::class.java) }

fun logInfo(text: String, level: Level = Level.INFO) = plugin.logger.log(level, text)

@Suppress("unused")
fun String.log(level: Level = Level.INFO) = plugin.logger.log(level, this)

fun String.toBooleanNonStrict(): Boolean? = when (lowercase()) {
    "true" -> true
    "false" -> false
    "yes" -> true
    "no" -> false
    "on" -> true
    "off" -> false
    "enabled" -> true
    "disabled" -> false
    else -> null
}