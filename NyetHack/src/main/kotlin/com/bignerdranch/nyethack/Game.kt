package com.bignerdranch.nyethack

/**
 * 
 * @author cash.wu 
 * @since 2026/02/09 
 * 
 */

fun main() {
    Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private val currentRoom: Room = TownSquare()

    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }

    fun play() {

        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            println("> Enter your command: ")
            println("Last command: ${readLine()}")
        }
    }

    private fun printPlayerStatus(
        player: Player
    ) {
        println(
            "(Aura: ${player.auraColor()}) " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }
}