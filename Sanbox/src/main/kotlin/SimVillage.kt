fun main() {

//    println({
//        val currentYear = 2018
//        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
//    }())

    val greetingFunction: () -> String = {
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }

    println(greetingFunction())

}