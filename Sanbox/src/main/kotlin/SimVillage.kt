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

//    val greetingFunction: (String) -> String = {
//        val currentYear = 2018
//        "Welcome to SimVillage, $it! (copyright $currentYear)"
//    }

    val greetingFunction: (String, Int) -> String = { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction("Guyal", 2))
}