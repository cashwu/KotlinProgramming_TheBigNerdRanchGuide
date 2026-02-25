/**
 * 
 * @author cash.wu 
 * @since 2026/02/25 
 * 
 */

class Barrel<in T>(item: T)

fun main() {
    var fedoraBarrel : Barrel<Fedora> = Barrel(Fedora("a generic-looking magenta fedora", 15))
    var lootBarrel : Barrel<Loot> = Barrel(Coin(15))

//    lootBarrel = fedoraBarrel

    fedoraBarrel = lootBarrel

//    lootBarrel.item = Coin(15)
//    val item: Fedora = fedoraBarrel.item

//    val item: Fedora = lootBarrel.item
}