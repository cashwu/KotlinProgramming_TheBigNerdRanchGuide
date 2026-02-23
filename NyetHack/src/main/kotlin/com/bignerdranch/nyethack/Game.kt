package com.bignerdranch.nyethack

/**
 * 
 * @author cash.wu 
 * @since 2026/02/09 
 * 
 */

fun main() {
    val player = Player("Madrigal")
    player.castFireball()

    // aura
    player.auraColor()

    printPlayerStatus(player)

    // aura
    player.auraColor()
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