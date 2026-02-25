/**
 * 
 * @author cash.wu 
 * @since 2026/02/25 
 * 
 */

class LootBox<T : Loot>(vararg item: T) {

    var open = false

    private var loot: Array<out T> = item

    operator fun get(index: Int): T? = loot[index].takeIf { open }

    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }

    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }
}

open class Loot(val value: Int)
class Fedora(val name: String, value: Int) : Loot(value)
class Coin(value: Int) : Loot(value)

fun main() {

    val lootBoxOne = LootBox(
        Fedora("a generic-looking magenta fedora", 15),
        Fedora("a dazzling magenta fedora", 25)
    )

    val lootBoxTwo = LootBox(Coin(100))

    lootBoxOne.open = true

    lootBoxOne.fetch(1)?.let {
        println("let - you retrieve ${it.name} from the box")
    }

    lootBoxOne.fetch(1)?.run {
        println("run - you retrieve $name from the box")
    }

    val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }

    coin?.let {
        println(it.value)
    }

    val fedora = lootBoxOne[1]
    fedora?.let {
        println(it.name)
    }
}