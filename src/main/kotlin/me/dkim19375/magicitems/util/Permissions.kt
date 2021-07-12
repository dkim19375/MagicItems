package me.dkim19375.magicitems.util

private const val base = "magicitems"

enum class Permissions(val perm: String) {
    COMMAND("$base.command"),
    RELOAD("$base.reload"),
    GIVE("$base.give"),
    VERSION("$base.version"),
    ENCHANTS("$base.enchants"),
    ATTRIBUTES("$base.attributes"),
    VANISHING("$base.vanishing"),
    BINDING("$base.binding")
}

fun String.toPermissions(): Permissions? = try {
    Permissions.valueOf(this)
} catch (_: IllegalArgumentException) {
    null
}