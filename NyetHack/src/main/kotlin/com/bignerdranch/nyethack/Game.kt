package com.bignerdranch.nyethack

import java.io.File

/**
 * 
 * @author cash.wu 
 * @since 2026/02/09 
 * 
 */

fun main() {
    Game.play()

//    val abandonedTownSquare = object : TownSquare() {
//        override fun load(): String {
//            return "you anticipate applause, but no one is here..."
//        }
//    }

//    PremadeWorldMap.load()
}

class PremadeWorldMap {

    companion object {
        private const val MAPS_FILEPATH = "nyethack.maps"
        fun load() = File(MAPS_FILEPATH).readBytes()
    }
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
            println(GameInput(readLine()).processCommand())
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

    private class GameInput(args: String?) {
        private val input = args ?: ""
        val command = input.split(" ")[0]
        val arguments = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.lowercase()) {
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do."
    }
}