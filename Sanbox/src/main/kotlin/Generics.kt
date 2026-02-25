/**
 * 
 * @author cash.wu 
 * @since 2026/02/25 
 * 
 */

class LootBox<T : Loot>(item: T) {

    var open = false

    private var loot: T = item

    fun fetch(): T? {
        return loot.takeIf { open }
    }

    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }
}

open class Loot(val value: Int)
class Fedora(val name: String, value: Int) : Loot(value)
class Coin(value: Int) : Loot(value)

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

    val coin = lootBoxOne.fetch() {
        Coin(it.value * 3)
    }

    coin?.let {
        println(it.value)
    }
}