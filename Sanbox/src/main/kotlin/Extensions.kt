fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

//fun Any.easyPrint() : Any {
//    println(this)
//    return this
//}

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

val String.numVowels
    get() = count { "aeiou".contains(it) }

fun main() {
    "Madrigal has left the building"
        .easyPrint()
        .addEnthusiasm()
        .easyPrint()

    42.easyPrint()

    "How manay vowels".numVowels.easyPrint()
}