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