/**
 * 
 * @author cash.wu 
 * @since 2026/02/25 
 * 
 */

class LootBox<T>(item: T) {

    private var loot: T = item
}

class Fedora(val name: String, val value: Int)
class Coin(val value: Int)

fun main() {

    val lootBoxOne = LootBox(Fedora("cash", 100))

    val lootBoxTwo = LootBox(Coin(100))
}