fun main() {

//    var beverage = readLine()?.capitalize()
//    var beverage = readLine()?.let {
//        if (it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "Buttered Ale"
//        }
//    }

//    var beverage = readLine()!!.capitalize()

    var beverage = readLine()

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }

//    beverage = null

    val beverageServed: String = beverage ?: "Buttered Ale"
    println(beverageServed)
//    println(beverage)
}