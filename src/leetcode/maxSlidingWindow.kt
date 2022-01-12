import java.util.*

/*
    Time Limit
 */
fun maxSlidingWindowWhenBruteForce(nums: IntArray, k: Int): IntArray {
    val result = mutableListOf<Int>()
    for (i in nums.indices) {
        if (i > nums.size - k) {
            break
        }
        val addNum = nums.filterIndexed { index, _ -> index >= i && index < i + k }.maxOrNull() ?: -9999999
        result.add(addNum)
    }
    return result.toIntArray()
}

/*
    Time Limit
 */

fun maxSlidingWindowWhenDeque(nums: IntArray, k: Int): IntArray {
    val dq = ArrayDeque<Int>()
    val result = mutableListOf<Int>()
    for (i in nums.indices) {
        dq.addLast(nums[i])
        if (dq.size < k) {
            continue
        }
        if (dq.size > k) {
            dq.removeFirst()
        }
        result.add(dq.maxOrNull() ?: -999999)
    }
    return result.toIntArray()
}

/*
    Runtime: 952 ms, faster than 60.53% of Kotlin online submissions for Sliding Window Maximum.
    Memory Usage: 52.7 MB, less than 94.74% of Kotlin online submissions for Sliding Window Maximum.
    maxSlidingWindowWhenDeque 함수가 Deque에 값을 저장했다면
    해당 함수는 Deque에 index를 저장하는 방법
 */
fun maxSlidingWindowWhenDeque2(nums: IntArray, k: Int): IntArray {
    val dq = ArrayDeque<Int>()
    val result = mutableListOf<Int>()

    for ((index, value) in nums.withIndex()) {
        while (dq.isNotEmpty() && value > nums[dq.last]) {
            dq.removeLast()
        }
        dq.addLast(index)

        if (dq.first == index - k) {
            dq.removeFirst()
        }
        if (index >= k - 1) {
            result.add(nums[dq.first])
        }
    }
    return result.toIntArray()
}

fun main() {
    val numArr = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3
    val result = maxSlidingWindowWhenBruteForce(numArr, k)
    println(result.contentToString())
    val resultDeque = maxSlidingWindowWhenDeque(numArr, k)
    println(resultDeque.contentToString())

    val resultDeque2 = maxSlidingWindowWhenDeque2(numArr, k)
    println(resultDeque2.contentToString())
}
