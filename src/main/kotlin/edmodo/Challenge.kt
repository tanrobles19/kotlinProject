fun main() {

    val number = 2
    val list :ArrayList<Int> = arrayListOf()

    println(happyNumber(number, list))

}

private fun happyNumber(number: Int, list: ArrayList<Int>): Boolean {

    var sum = 0

    numberToArray(number).asReversed().forEach {
        sum += it * it
    }

    if(list.contains(sum)) {
        return false
    }

    list.add(sum)

    if (sum == 1) {
        return true
    }else{
        return happyNumber(sum, list)
    }

}// end fun happyNumber()

private fun numberToArray(number: Int): ArrayList<Int> {

    var source = number

    val list: ArrayList<Int> = arrayListOf()

    while (source > 0) {
        list.add(source % 10)
        source /= 10
    }

    return list

}// end fun numberToArray()