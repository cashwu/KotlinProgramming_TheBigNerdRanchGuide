fun main() {

//    println({
//        val currentYear = 2018
//        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
//    }())

//    val greetingFunction: () -> String = {
//        val currentYear = 2018
//        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
//    }

//    val greetingFunction: (String) -> String = { playerName ->
//        val currentYear = 2018
//        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
//    }

    val greetingFunction: (String) -> String = {
        val currentYear = 2018
        "Welcome to SimVillage, $it! (copyright $currentYear)"
    }
    println(greetingFunction("Guyal"))

}