package com.bignerdranch.nyethack

import java.io.File
import com.bignerdranch.nyethack.extensions.random as randomizer

/**
 * 
 * @author cash.wu 
 * @since 2026/02/23 
 * 
 */

class Player(
    _name: String,
    override var healthPoints: Int = 100,
    val isBlessed: Boolean = false,
    private val isImmortal: Boolean,
    override val diceCount: Int = 3,
    override val diceSides: Int = 6,
    override val damageRoll: Int = 6
) : Fightable {
    lateinit var alignment: String

    fun proclaimFate() {
        if (::alignment.isInitialized) {
            println(alignment)
        }
    }

//    constructor(name: String) : this(
//        name,
//        isBlessed = true,
//        isImmortal = false
//    ) {
//        if (name.lowercase() == "kar") {
//            healthPoints = 40
//        }
//    }

    var name = _name
        get() = "${field.replaceFirstChar { it.uppercase() }} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown by lazy { selectHometown() }

    var currentPosition = Coordinate(0, 0)

    private fun selectHometown(): String {
        return File("data/towns.txt")
            .readText()
            .split("\n")
            .randomizer()
    }

    init {
        require(healthPoints > 0) { "Health points must be greater than zero." }
        require(name.isNotBlank()) { "Player must have a name." }

        val (x, y) = Coordinate(0, 0)

        println(currentPosition.toString())
        println(currentPosition == Coordinate(0, 0))
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

    override fun attack(opponent: Fightable): Int {

        val damageDealt = if (isBlessed) {
            damageRoll * 2
        } else {
            damageRoll
        }

        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}
