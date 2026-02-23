/**
 * 
 * @author cash.wu 
 * @since 2026/02/23 
 * 
 */
class Player {

    var name = "madrigal"
        get() = field.replaceFirstChar { it.uppercase() }
        set(value) {
            field = value.trim()
        }

    fun castFireball(numFireballs: Int = 2) = println("A glass of Fireball springs into existence. (x$numFireballs)")

}