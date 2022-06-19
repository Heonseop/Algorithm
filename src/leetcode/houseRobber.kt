package leetcode

/*
leetcode 198 : House Robber
Runtime: 160 ms, faster than 89.84% of Kotlin online submissions for House Robber.
Memory Usage: 35.9 MB, less than 21.39% of Kotlin online submissions for House Robber.
 */
fun rob(nums: IntArray): Int = when (nums.size) {
    //1차원 dp로 풀기 가능
    //털데가 없으니 0
    0 -> 0
    //한곳만 있으니 1
    1 -> nums.first()
    else -> {
        //첫 번째는 0과 1중 최대값
        nums[1] = maxOf(nums[0], nums[1])

        //n-1 의 최대값과 n-2의 최대값+ 지금 집을 터는 케이스의 최대값 체크
        //연속된 집 털기는 안되기 때문
        for (i in 2..nums.lastIndex) {
            nums[i] = maxOf(nums[i - 1], nums[i - 2] + nums[i])
        }

        nums.last()
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 1)
    println(rob(nums))
}