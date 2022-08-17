import kotlin.random.Random

fun main() {

    val hashMap: HashMap<Int, Int> = hashMapOf()

    hashMap.apply {
        put(1,10)
        put(2,20)
        put(3,30)
        put(4,40)
        put(5,50)
        put(6,60)
        put(7,70)
        put(8,80)
        put(9,90)
        put(10,100)
    }

    generateRandomValue(hashMap)

}

fun generateRandomValue(hashMap: HashMap<Int,Int>) {

//    Based on Uber interview Question.

    (1..100).forEach {
        val key = hashMap.keys.elementAt(Random.nextInt(hashMap.size))
        println(hashMap[key])
    }

    //OR

    (1..100).forEach {
        println(hashMap[hashMap.keys.random()])
    }



}