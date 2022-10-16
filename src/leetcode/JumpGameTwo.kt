package leetcode

//45. Jump Game II: 그리디 사용
fun jump(nums: IntArray): Int {
    var count = 0
    var currentMaxCount = 0
    var nextMaxIndex = 0

    for (i in 0 until nums.size - 1) {
        nextMaxIndex = nextMaxIndex.coerceAtLeast(i + nums[i])
        if (i == currentMaxCount) {
            //도달할 때마다 count 증가
            count++
            currentMaxCount = nextMaxIndex
        }
    }

    return count
}

fun main() {
    val nums = intArrayOf(2, 3, 1, 1, 4)
    println(jump(nums))
}