
// A compile-time constant must be defined outside any function
const val HERO_NAME = "Madrigal"

data class Vowel(val vowel : Char, val index : Int )

fun main() {

    val text = "MMI"

    println(romanToNumber(text))

}
private fun romanToNumber(roman: String): Int {

    var number1 = -1
    var number2 = -1
    var count = 0

    roman.forEach {

        if(number1 == -1) {
            number1 = matchRoman(it)
        } else if(number2 == -1) {
            number2 = matchRoman(it)
        }

        if(number1 != -1 && number2 != -1) {
            if(number1 < number2) {
                count += (number2 - number1)
                //initialization
                number1 = -1
                number2 = -1
            }else{
                count += number1
                number1 = number2
                number2 = -1
            }
        }// end if

    }// end foreach

    if(number1 != -1) count += number1

    if(number2 != -1) count += number2

    return count

}// end fun romanToNumber()

private fun matchRoman(romanValue: Char): Int{

    val number  = when(romanValue) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        else -> 1000
    }

    return number

}// fun matchRoman()

private fun validParentheses(s: String): Boolean {

    val stack : ArrayList<Char> = arrayListOf()

    s.forEach { character ->
        when(character) {
            '(','{','[' -> stack.add(0, character)
            else -> {

                if(stack.isEmpty()) return false

                if( stack.get(0) == '[' && character == ']' )
                    stack.removeAt(0)
                else if( stack.get(0) == '{' && character == '}' )
                    stack.removeAt(0)
                else if( stack.get(0) == '(' && character == ')' )
                    stack.removeAt(0)
                else
                    return false
            }
        }// end when
    }// end for

    return stack.isEmpty()

}// end fun validParentheses()
private fun longestSubstringWithoutRepeatingCharacters(s: String): Int {

    val builder = StringBuilder()

    var longestSize = if(s.isEmpty()) 0 else 1

    s.forEach {

        if (builder.contains(it)) builder.replace(0, builder.indexOf(it) + 1 ,"")

        builder.append(it)

        if(builder.length > longestSize) longestSize = builder.length

    }// end foreach

    return longestSize

}
private fun removeVowels(stringValue: String): String {

    val builder = StringBuilder()

    stringValue.forEach { character ->

        when(character) {
            'a', 'e', 'i', 'o', 'u' -> ""
            else -> builder.append(character)
        }// end when

    }// end forEach

    return builder.toString()

}// end fun

fun reverseVowelsOfString(source: String): String {

    val builder = StringBuilder(source)

    val vowelList :ArrayList<Vowel> = arrayListOf()

    builder.forEachIndexed { index, character ->

        when(character) {
            'a', 'e','i','o','u' -> vowelList.add(Vowel(character, index))
            'A', 'E','I','O','U' -> vowelList.add(Vowel(character, index))
        }

    }// end foreach

    vowelList.forEachIndexed { index, vowel ->

        if(index < (vowelList.size /2)) {

            val position = vowelList.get(vowelList.size - (index + 1))

            builder.replace(vowel.index, vowel.index + 1, position.vowel.toString())
            builder.replace(position.index, position.index + 1, vowel.vowel.toString())

        }

    }// end foreach

    return builder.toString()

}// end fun reverseVowelsOfString()
private fun cutVowelsBunches(word: String): Int {

    var newVowelSubString = ""
    var countVowels = 0

    word.forEach {character ->
        val isVowel = when(character) {
            'a','e', 'i', 'o','u'  -> true
            else -> {
                if(newVowelSubString.length >= 5)
                    countVowels+=countVowelSubstring(newVowelSubString)
                newVowelSubString = ""
                false
            }
        }// end when

        if(isVowel) newVowelSubString+=character

    }// end foreach

    if(newVowelSubString.length >= 5)
        countVowels+=countVowelSubstring(newVowelSubString)

    return countVowels

}// fun cutVowelsBunches()
private fun countVowelSubstring(word: String): Int {

    var countSubString = 0
    var newWord = ""

    val keepTrackVowel = Array(5) { 0 }

    word.forEach{ character ->

        when(character) {
            'a'-> keepTrackVowel[0]++
            'e'-> keepTrackVowel[1]++
            'i'-> keepTrackVowel[2]++
            'o'-> keepTrackVowel[3]++
            'u'-> keepTrackVowel[4]++
        }// end when

        newWord+= character

        if(keepTrackVowels(keepTrackVowel)) countSubString++

    }// end forEach

    if(newWord.length > 5)
        countSubString += countVowelSubstring(newWord.substring(1, newWord.length))

        return countSubString

}// end fun
private fun keepTrackVowels(keepTrackVowel: Array<Int>): Boolean {
    keepTrackVowel.forEach {
        if (it < 1)
            return false
    }
    return true
}

//https://leetcode.com/tag/string/
//private fun testNothing(): String {
//    TODO("you must implement this function for the release")
//}

private fun newFunction() {
    println(HERO_NAME.reversed())

    var playerLevel = 0
//    playerLevel+=4
//    println(playerLevel)

    testWhen(playerLevel)
}

private fun test(playerLevel : Int) {
    val message = if( playerLevel in 1..6) "Eithan" else "Issac"
    println(message)
}
private fun testWhen(score : Int) {


//    val rangeTest = Version(1,11)..Version(1,30)

//    for (i in 1 until   10 ) println(i)

//    val finalScore = score / 100 +1
//
//    val nickName = when(finalScore) {
//        1, 0 -> "terrible"
//        in 2..5-> "bad"
//        in 5..7 -> "almost there"
//        in 7..9 -> "good"
//        else -> "Extraordinary"
//    }
//
//    println(nickName)

}