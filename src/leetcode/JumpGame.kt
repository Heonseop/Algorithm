/*
    55. Jump Game
    Runtime: 560 ms, faster than 14.51% of Kotlin online submissions for Jump Game.
    Memory Usage: 68.6 MB, less than 6.45% of Kotlin online submissions for Jump Game.
 */
fun canJump(nums: IntArray): Boolean {
    var result = true
    var range = 1
    for( i  in nums.size-2 downTo 0){
        if(nums[i] < range){
            if(i == 0){
                result = false
                break
            }
            range++
            continue
        } else {
            range = 1
            continue
        }
    }
    return result
}

fun main(){
    val nums:IntArray = intArrayOf(3,2,1,0,4)
    //val nums:IntArray = intArrayOf(2,3,1,1,4)

    print(canJump(nums))
}