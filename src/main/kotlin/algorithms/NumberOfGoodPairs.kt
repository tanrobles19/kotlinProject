fun main() {

    val nums: IntArray = intArrayOf(1,2,3,1,1,3)

    println(test(nums))

}

fun test(nums: IntArray): Int {

    val hashMap: HashMap<Int, Int> = hashMapOf()

    nums.forEach { number ->

        hashMap[number]?.let {
            var item = it
            item+=1
            hashMap.put(number, item)
        }?: hashMap.put(number, 1)

    }

    var count = 0

    hashMap.values.forEach {
        if(it > 2) {
            val sum = ( it * ( it -1) ) / 2
            count+= sum
        }else if(it == 2){
            count+=1
        }
    }

    return count
}// end fun test()