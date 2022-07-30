
// A compile-time constant must be defined outside any function
const val HERO_NAME = "Madrigal"

fun main() {

    println(HERO_NAME.reversed())

    var playerLevel = 0
//    playerLevel+=4
    println(playerLevel)

    test(playerLevel)

}

private fun test(playerLevel : Int) {
    val message = if( playerLevel in 1..6) "Eithan" else "Issac"
    println(message)
}