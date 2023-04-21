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