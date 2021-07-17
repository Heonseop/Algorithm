/*
    Advantage Shuffle(870)
    Runtime: 2066 ms, faster than 20.00% of Kotlin online submissions for Advantage Shuffle.
    Memory Usage: 72.6 MB, less than 80.00% of Kotlin online submissions for Advantage Shuffle.
 */

fun advantageCount(nums1: IntArray, nums2: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val sortNums1 = nums1.sortedArray().toMutableList()
    nums2.forEach { value1 ->
        run lit@{
            sortNums1.forEach { value2 ->
                if (value1 < value2) {
                    result.add(value2)
                    sortNums1.remove(value2)
                    return@lit
                }
            }
            if(sortNums1.size > 0) {
                result.add(sortNums1.first())
                sortNums1.removeAt(0)
            }
        }
    }

    return result.toIntArray()
}

fun main() {
    val nums1 = intArrayOf(2,7,11,15)
    val nums2 = intArrayOf(1,10,4,11)
    print(advantageCount(nums1, nums2).contentToString())
}