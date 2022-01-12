import kotlin.math.max
/*
    128. Longest Consecutive Sequence
    Runtime: 280 ms, faster than 92.31% of Kotlin online submissions for Longest Consecutive Sequence.
    Memory Usage: 45.9 MB, less than 94.87% of Kotlin online submissions for Longest Consecutive Sequence.
 */
fun longestConsecutive(nums: IntArray): Int {
    if(nums.isEmpty()){
        return 0
    }
    var result = 0
    var consecutive = 1
    var tempNum = nums[0]
    nums.sort()
    for (num in nums) {
        if (tempNum + 1 == num) {
            consecutive++
        } else if(tempNum == num){
            continue
        } else {
            consecutive = 1
        }

        result = max(consecutive, result)
        tempNum = num
    }
    result = max(consecutive, result)
    return result
}

fun main() {
    val nums = intArrayOf(0)
    print(longestConsecutive(nums))
}