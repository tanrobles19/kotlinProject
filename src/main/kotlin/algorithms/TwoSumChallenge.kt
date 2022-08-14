fun main( ) {

    val nums : IntArray = intArrayOf(2,7,11,15)

    println(sumTwo2(nums, 9).toList())

}

fun sumTwo2(nums: IntArray, target: Int): IntArray {

    val index : IntArray = IntArray(2)

    for (i in nums.indices) {
        for (x in nums.indices) {
            if( i != x && (nums[i] + nums[x]) == target ) {
                index[0] = i
                index[1] = x
                return index
            }// end if
        }// end for
    }// end for

    return index

}// end sum