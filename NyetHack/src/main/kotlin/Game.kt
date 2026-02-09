/**
 * 
 * @author cash.wu 
 * @since 2026/02/09 
 * 
 */

fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    // aura
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)

    val healthStatus = if (healthPoints == 100) {
        "is in excellent condition!"
    } else if (healthPoints >= 90) {
        "has a few scratches."
    } else if (healthPoints >= 75) {
        if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
    } else if (healthPoints >= 90) {
        "has a few scratches."
    } else {
        "is in awful condition!"
    }

    println(name + " " + healthStatus)
}