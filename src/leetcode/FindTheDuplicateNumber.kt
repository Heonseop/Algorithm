/*
    287. Find the Duplicate Number
    Runtime: 762 ms, faster than 13.68% of Kotlin online submissions for Find the Duplicate Number.
    Memory Usage: 77.1 MB, less than 21.05% of Kotlin online submissions for Find the Duplicate Number.
 */

fun findDuplicate(nums: IntArray): Int {
    var result = 0
    val set = mutableSetOf<Int>()
    run lit@{
        nums.forEach { value ->
            if (set.contains(value)) {
                result = value
                return@lit
            } else {
                set.add(value)
            }
        }
    }

    return result
}

fun main() {
    val nums = intArrayOf(1, 3, 4, 2, 2)
    print(findDuplicate(nums))
}