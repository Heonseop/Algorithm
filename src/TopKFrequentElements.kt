/*
347. Top K Frequent Elements

Runtime: 264 ms, faster than 44.26% of Kotlin online submissions for Top K Frequent Elements.
Memory Usage: 40.1 MB, less than 97.27% of Kotlin online submissions for Top K Frequent Elements.
 */

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map: MutableMap<Int, Int> = mutableMapOf()

    for (num in nums) {
        if (map.containsKey(num)) {
            map[num] = map[num]?.plus(1) ?: 1
        } else {
            map[num] = 1
        }
    }
    val sortedMap =
        map.toList().sortedWith(compareBy<Pair<Int, Int>> { it.second }.reversed().thenBy { it.first }).toMap()

    return sortedMap.keys.toList().subList(0, k).toIntArray()
}

fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    val k = 2

    print(topKFrequent(nums, k).contentToString())
}