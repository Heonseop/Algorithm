package leetcode

import kotlin.math.max

/*
leetCode 56: Merge Intervals
Runtime: 584 ms, faster than 64.75% of Kotlin online submissions for Merge Intervals.
Memory Usage: 76.6 MB, less than 45.81% of Kotlin online submissions for Merge Intervals.
*/
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result: MutableList<IntArray> = mutableListOf()
    intervals.sortWith(compareBy { it[0] })
    if (intervals.size < 2) {
        return intervals
    }
    var startInterval = intervals[0]
    for (interval in intervals) {
        if (startInterval[1] < interval[0]) {
            result.add(startInterval)
            startInterval = interval
        } else {
            startInterval[1] = max(startInterval[1], interval[1])
        }
    }
    result.add(startInterval)
    return result.toTypedArray()
}

fun main() {
//    val intervals = arrayOf(
//        intArrayOf(1,3),
//        intArrayOf(2,6),
//        intArrayOf(8,10),
//        intArrayOf(15,18)
//    )
    val intervals = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(5, 6)
    )
    println(merge(intervals).contentDeepToString())
}