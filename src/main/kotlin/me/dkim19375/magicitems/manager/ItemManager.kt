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

package me.dkim19375.magicitems.manager

import me.dkim19375.magicitems.MagicItems
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class ItemManager(plugin: MagicItems) {
    private val configManager = plugin.configManager
    private val useNetherite = Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.17")

    var enchantsToggle = false
    var attributesToggle = true
    var vanishingToggle = true
    var bindingToggle = false

    fun getItems(): Array<ItemStack> = arrayOf(
        getItem(Material.DIAMOND_HELMET),
        getItem(Material.DIAMOND_CHESTPLATE),
        getItem(Material.DIAMOND_LEGGINGS),
        getItem(Material.DIAMOND_BOOTS),
        getItem(Material.DIAMOND_SWORD),
        getItem(Material.DIAMOND_AXE),
        getItem(Material.DIAMOND_AXE, true),
        getItem(Material.DIAMOND_PICKAXE),
        getItem(Material.DIAMOND_PICKAXE, true),
        getItem(Material.DIAMOND_HOE),
        getItem(Material.DIAMOND_SHOVEL),
        getItem(Material.DIAMOND_SHOVEL, true),
        getItem(Material.BOW),
        getItem(Material.ARROW),
        getItem(Material.ELYTRA),
        getItem(Material.FIREWORK_ROCKET),
        getItem(Material.FLINT_AND_STEEL),
        getItem(Material.CROSSBOW)
    )

    private fun getItem(type: Material, silk: Boolean = false): ItemStack {
        val netheriteType = Material.matchMaterial(
            "NETHERITE_${
                type.name.split('_').getOrElse(1) { "" }
            }"
        )
        val newType = if (useNetherite && netheriteType != null) {
            netheriteType
        } else {
            type
        }
        val item = ItemStack(newType, if (type == Material.FIREWORK_ROCKET) 64 else 1)
        val meta = item.itemMeta ?: return item
        if (!enchantsToggle) {
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS)
        }
        if (!attributesToggle) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES)
        }
        meta.lore = listOf(
            "",
            "${ChatColor.BOLD}${ChatColor.ITALIC}Magical Item",
        ).plus(if (silk) listOf("${ChatColor.GOLD}${ChatColor.ITALIC}Has silk touch") else emptyList())
        loop@ for (enchant in Enchantment.values()) {
            when (enchant) {
                Enchantment.SILK_TOUCH -> {
                    if (!silk) {
                        continue@loop
                    }
                    meta.addEnchant(enchant, configManager.fromEnchantment(enchant), true)
                    continue@loop
                }
                Enchantment.VANISHING_CURSE -> {
                    if (!vanishingToggle) {
                        continue@loop
                    }
                    meta.addEnchant(enchant, configManager.fromEnchantment(enchant), true)
                    continue@loop
                }
                Enchantment.BINDING_CURSE -> {
                    if (!bindingToggle) {
                        continue@loop
                    }
                    meta.addEnchant(enchant, configManager.fromEnchantment(enchant), true)
                    continue@loop
                }
            }
            if (enchant.canEnchantItem(item)) {
                meta.addEnchant(enchant, configManager.fromEnchantment(enchant), true)
            }
        }
        item.itemMeta = meta
        return item
    }
}