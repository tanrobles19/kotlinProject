fun main( ) {

    val nums : IntArray = intArrayOf(2,7,11,15)

    println(sumTwo(nums, 9).toList())

}
// Big O(n2) time complexity(Linear time)
fun sumTwo(nums: IntArray, target: Int): IntArray {

    val hash : HashMap<Int, Int> = hashMapOf()

    for (i in nums.indices) {

        val hashNumber = hash[target - nums[i]]

        if(hashNumber != null) return intArrayOf(hashNumber, i) else hash[nums[i]] = i

    }// end for

    return IntArray(2)

}// end fun sumTwo

//Big O(n2) Worst solution(two for loop)
fun sumTwo2(nums: IntArray, target: Int): IntArray {

    val index : IntArray     = IntArray(2)

    for (i in nums.indices) {

        if(nums[i] > target) continue

        for (x in nums.indices) {

            if((nums[i] + nums[x + i + 1]) == target ) {
                index[0] = i
                index[1] = x + i + 1
                return index
            }// end if

            if((x + i + 2) >= nums.size)
                break
        }// end for
    }// end for

    return index

}// end sum