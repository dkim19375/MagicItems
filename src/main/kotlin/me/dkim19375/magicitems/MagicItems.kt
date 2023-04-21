/*
 * MIT License
 *
 * Copyright (c) 2021 dkim19375
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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