fun main() {

    val hashmap: LinkedHashMap<String, Int> = LinkedHashMap(5)

    hashmap.apply {
        put("Eithan", 6)
        put("Issac", 0)
        put("Lu", 32)
        put("Jona", 34)
        put("Gaty", 8)
        put("MIMO", 14)
    }

    val test = hashmap.get("Issac")

    for (key in hashmap.keys) {
        println("Elements at Key $key:  ${hashmap[key]}")
    }

    println("")

    hashmap.put("MIMO", 100)
    hashmap.put("1", 1)
    hashmap.put("2", 2)
    hashmap.put("3", 3)
    hashmap.put("4", 4)
    hashmap.put("5", 5)
    hashmap.put("6", 6)
    hashmap.put("7", 7)
    hashmap.put("8", 8)
    hashmap.put("9", 9)
    hashmap.put("10", 10)

    val name = hashmap.get("Eithan")

    println(name)

    for (key in hashmap.keys) {
        println("Elements at Key $key:  ${hashmap[key]}")
    }

    /*
    Based on the leetcode problem
    https://leetcode.com/problems/lru-cache/
    * */
//    LRUCacheTest()

}


fun LRUCacheTest(): Array<Int?> {

    val array : Array<Int?> = arrayOf(null,null,null,1,null,-1,null,-1,3,4)

    println(array)
    println(array.toList())

    return array

}

class LRUCache(capacity: Int): LinkedHashMap<Int?, Int?>(capacity, 0.75f, true) {

    operator fun get(key: Int): Int {
        return super.getOrDefault(key = key, -1)!!
    }

    fun put(key: Int, value: Int) {
        super.put(key, value)
    }

}