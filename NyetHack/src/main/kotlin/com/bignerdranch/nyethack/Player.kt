package com.bignerdranch.nyethack

/**
 * 
 * @author cash.wu 
 * @since 2026/02/23 
 * 
 */

class Player(
    _name: String,
    var healthPoints: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {

    constructor(name: String) : this(
        name,
        isBlessed = true,
        isImmortal = false
    ) {
        if (name.lowercase() == "kar") {
            healthPoints = 40
        }
    }

    var name = _name
        get() = field.replaceFirstChar { it.uppercase() }
        private set(value) {
            field = value.trim()
        }

    fun castFireball(numFireballs: Int = 2) = println("A glass of Fireball springs into existence. (x$numFireballs)")

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus(): String = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }

        in 15..74 -> "has a few scratches."
        else -> "is in awful condition!"
    }
}
