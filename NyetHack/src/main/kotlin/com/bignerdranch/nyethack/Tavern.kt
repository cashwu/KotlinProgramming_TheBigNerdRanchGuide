package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
var patronList = mutableListOf("Eli", "Mordoc", "Sophie")
var lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()

val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

//val com.bignerdranch.nyethack.patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
var patronGold = mutableMapOf<String, Double>()


fun main() {

//    com.bignerdranch.nyethack.patronList.forEachIndexed { index, parton ->
//        println("good evening, $parton - you're #${index + 1} in line")
//        com.bignerdranch.nyethack.placeOrder(parton, com.bignerdranch.nyethack.menuList.shuffled().first())
//    }
//    com.bignerdranch.nyethack.menuList.forEachIndexed { index, data ->
//        println("$index : $data")
//    }

    (0..9).forEach { _ ->
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
        uniquePatrons += name
//        println(name)
    }

    println(uniquePatrons)

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }
    println(patronGold)


    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(
            uniquePatrons.random(),
            menuList.random()
        )

        orderCount++
    }

    displayPatronBalances()

//    println(listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").toSet())
//    val patrons = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot")
//        .toSet()
//        .toList()
//
//    println(patrons[0])
//    val patrons = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot")
//        .distinct()

//    println(patrons[0])

//    println(com.bignerdranch.nyethack.patronGold)
//    println(com.bignerdranch.nyethack.patronGold["Eli"])
//    println(com.bignerdranch.nyethack.patronGold["Mordoc"])
//    println(com.bignerdranch.nyethack.patronGold["Sophie"])
}


fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
//    println("Madrigal speaks with $tavernMaster about their order.")
    println("$patronName speaks with $tavernMaster about their order.")

//    val data = menuData.split(",")
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]

    val (type, name, price) = menuData.split(",")
//    val message = "Madrigal buys a $name ($type) for $price"
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

    val gold = "5.91".toDoubleOrNull() ?: 0
    performPurchase(price.toDouble(), patronName)

//    val phrase = "Ah, delicious $name!"
//    val msg = phrase.replace(Regex("[aeiou]"), { t ->
//        when (t.value) {
//            "a" -> "4"
//            "e" -> "3"
//            "i" -> "1"
//            "o" -> "0"
//            "u" -> "|_|"
//            else -> t.value
//        }
//    })
//    println(msg)

    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims: ${com.bignerdranch.nyethack.toDragonSpeak("Ah, delicious $name!")}"
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
//        "Madrigal says: Thanks for the $name."
        "$patronName says: Thanks for the $name."
    }

    println(phrase)
}

fun toDragonSpeak(phrase: String) = phrase.replace(Regex("[aeiou]")) {
    when (it.value) {
        "a" -> "4"
        "e" -> "3"
        "i" -> "1"
        "o" -> "0"
        "u" -> "|_|"
        else -> it.value
    }
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

fun displayPatronBalances() {
    patronGold.forEach { (patron, balance) ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

//fun com.bignerdranch.nyethack.performPurchase(price: Double) {
//    displayBalance()
//
//    val totalPurse = com.bignerdranch.nyethack.playerGold + (com.bignerdranch.nyethack.playerSilver / 100.0)
//    println("Total purse: $totalPurse")
//    println("Purchasing item for $price")
//
//    val remainingBalance = totalPurse - price
//    println("remainingBalance - ${"%.2f".format(remainingBalance)}")
//
//    val remainingGold = remainingBalance.toInt()
//    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//    com.bignerdranch.nyethack.playerGold = remainingGold
//    com.bignerdranch.nyethack.playerSilver = remainingSilver
//    displayBalance()
//}

//fun displayBalance() {
//    println("com.bignerdranch.nyethack.Player's purse balance: Gold: $com.bignerdranch.nyethack.playerGold, Silver $com.bignerdranch.nyethack.playerSilver")
//}
