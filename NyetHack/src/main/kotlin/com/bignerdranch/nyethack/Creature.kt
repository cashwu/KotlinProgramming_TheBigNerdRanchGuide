package com.bignerdranch.nyethack

import kotlin.random.Random

interface Fightable {
    var healthPoints: Int
    val diceCount : Int
    val diceSides: Int
    val damageRoll: Int
        get() = (0 until diceCount).sumOf {
            Random.nextInt(diceSides) + 1
        }

    fun attack(opponent: Fightable) : Int
}

abstract class Monster(
    val name : String,
    val description : String,
    override var healthPoints: Int,
) : Fightable {


    override fun attack(opponent: Fightable) : Int {

        val damageDealt = damageRoll
        opponent.healthPoints -= damageDealt
        return damageDealt
    }
}

class Goblin(
    name : String = "Gobbly",
    description : String = "A nasty-looking goblin",
    healthPoints : Int = 30,
) : Monster(name, description, healthPoints) {

    override val diceCount: Int = 2
    override val diceSides: Int = 8
}