/**
 * 
 * @author cash.wu 
 * @since 2026/02/25 
 * 
 */

class LootBox<T>(item: T) {

    var open = false

    private var loot: T = item

    fun fetch(): T? {
        return loot.takeIf { open }
    }
}

class Fedora(val name: String, val value: Int)
class Coin(val value: Int)

fun main() {

    val lootBoxOne = LootBox(Fedora("cash", 100))

    val lootBoxTwo = LootBox(Coin(100))

    lootBoxOne.open = true

    lootBoxOne.fetch()?.let {
        println("let - you retrieve ${it.name} from the box")
    }

    lootBoxOne.fetch()?.run {
        println("run - you retrieve $name from the box")
    }
}