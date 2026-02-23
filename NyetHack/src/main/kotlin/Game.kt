/**
 * 
 * @author cash.wu 
 * @since 2026/02/09 
 * 
 */

val player = Player()
fun main() {
//    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val player = Player()
//    player.name = "estragon"
    println(player.name + " The Brave")
    player.castFireball()

    // aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)

//    castFireball(5)
//    castFireball()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

//private fun castFireball(numFireballs: Int = 2) =
//    println("A glass of Fireball springs into existence. (x$numFireballs)")

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String = when (healthPoints) {
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