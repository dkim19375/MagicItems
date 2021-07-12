package me.dkim19375.magicitems

import io.github.slimjar.app.builder.ApplicationBuilder
import me.dkim19375.dkimbukkitcore.checker.UpdateChecker
import me.dkim19375.dkimbukkitcore.javaplugin.CoreJavaPlugin
import me.dkim19375.magicitems.command.MITabCompleter
import me.dkim19375.magicitems.command.MagicItemsCMD
import me.dkim19375.magicitems.manager.ConfigManager
import me.dkim19375.magicitems.manager.ItemManager
import me.dkim19375.magicitems.util.logInfo
import org.bukkit.ChatColor
import java.util.logging.Level
import kotlin.system.measureTimeMillis

class MagicItems : CoreJavaPlugin() {
    val configManager by lazy { ConfigManager(this) }
    val itemManager by lazy { ItemManager(this) }
    private val updateChecker = UpdateChecker("82693", null, this)

    override fun onLoad() {
        logInfo("Loading libraries... (This may take a few seconds up to a minute)")
        logInfo(
            "Finished loading libraries in ${
                measureTimeMillis {
                    ApplicationBuilder.appending(description.name).build()
                }
            }ms!"
        )
    }

    override fun onEnable() {
        saveDefaultConfig()
        configManager // init lazy
        itemManager // init lazy
        getVersion({ version ->
            if (version == description.version) {
                logInfo("${ChatColor.GOLD}MagicItems is up to date!")
                logInfo("Your version: ${description.version}")
                return@getVersion
            }
            logInfo("MagicItems is outdated!", Level.WARNING)
            logInfo("Your version: ${description.version}", Level.WARNING)
            logInfo("Newest version: $version", Level.WARNING)
            logInfo("Please update here: ${description.website}", Level.WARNING)
        }) {
            logInfo("Could not get latest version!", Level.SEVERE)
        }
        registerCommand("magicitems", MagicItemsCMD(this), MITabCompleter())
    }

    fun getVersion(version: (String) -> Unit = {}, error: () -> Unit = {}) {
        updateChecker.getSpigotVersion({ version1 ->
            version(version1)
        }) { error() }
    }
}