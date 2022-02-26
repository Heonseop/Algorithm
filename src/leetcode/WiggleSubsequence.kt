package leetcode


/*
Runtime: 156 ms, faster than 63.64% of Kotlin online submissions for Wiggle Subsequence.
Memory Usage: 33.8 MB, less than 72.73% of Kotlin online submissions for Wiggle Subsequence.
 */
fun checkState(num1: Int, num2: Int): Int {
    return when {
        num2 > num1 -> 1
        num2 < num1 -> -1
        else -> 0
    }
}

fun wiggleMaxLength(nums: IntArray): Int {
    //size 1일경우 비교 필요없음
    if (nums.size == 1) {
        return 1
    }
    var result = 0
    var isState = -2
    var currentState: Int
    //체크해야되는 부분 0 일경우 체크하면 안 됨
    for (index in (0 until nums.size - 1)) {
        currentState = checkState(nums[index], nums[index + 1])
        //두 개의 사이값이 0이 아니고, 아직 기준 잡지 않을 경우
        if (isState == -2 && currentState != 0) {
            isState = currentState
            result += 1
        }
        //기존 상태와 체크하는 상태가 다를 경우만 result 증가
        if ((isState == -1 && currentState == 1) || (isState == 1 && currentState == -1)) {
            result += 1
            isState = currentState
        }
    }

    return result + 1
}

fun main() {
    val nums = intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)
    println(wiggleMaxLength(nums))
}