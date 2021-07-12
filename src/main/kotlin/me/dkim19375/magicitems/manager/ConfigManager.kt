package me.dkim19375.magicitems.manager

import me.dkim19375.magicitems.MagicItems
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.enchantments.Enchantment

class ConfigManager(private val plugin: MagicItems) {
    private val config: FileConfiguration
        get() = plugin.config

    fun fromEnchantment(enchant: Enchantment): Int = config.getInt("Enchant-Levels.${enchant.key.key}", 32767)
}