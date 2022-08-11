fun main() {

    val number = 1700896918

    val hashTable : HashMap<Int, Int> = hashMapOf()
//    val list :ArrayList<Int> = arrayListOf()

    println(happyNumber(number, hashTable))

}

private fun happyNumber(number: Int, hashTable: HashMap<Int, Int>): Boolean {

    var sum = 0

    numberToArray(number).asReversed().forEach {
        sum += it * it
    }


    /* contains function is based on indexOf, Big O(n)
     * indexOf is a linear search implementation
     */
    if(hashTable.contains(sum)) {
        println("Hash Table power")
        return false
    }

    hashTable[sum] = sum

    if (sum == 1) {
        return true
    }else{
        return happyNumber(sum, hashTable)
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