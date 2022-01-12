import java.lang.Math.floor

/*
33. Search in Rotated Sorted Array
 */
//완전 탐색
//o(N)
fun searchBruteForce(nums: IntArray, target: Int): Int {
    var result = -1
    for ((index, value) in nums.withIndex()) {
        if (value == target) {
            result = index
            break
        }
    }

    return result
}

fun getSortLastIndex(nums: IntArray): Int {
    var l = 0
    var r = nums.size - 1
    var result = 0
    val firstIndexValue = nums[0]
    while (l <= r) {
        val mid = (l + r) / 2
        if (firstIndexValue <= nums[mid]) {
            result = mid
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return result
}

//binarySearch 응용
/*
    pivot 찾고 binarySearch 돌려버리기
    Runtime: 188 ms, faster than 49.31% of Kotlin online submissions for Search in Rotated Sorted Array.
    Memory Usage: 36.9 MB, less than 18.97% of Kotlin online submissions for Search in Rotated Sorted Array.
 */
fun searchBinarySearch(nums: IntArray, target: Int): Int {
    if(nums.isEmpty()) {
        return -1
    }
    if(nums.size == 1) {
        return if (nums[0] == target) 0 else -1
    }

    //오름차순이 되는 가장 마지막 index를 찾는다(pivot을 찾는다.)
    val sortLastIndex = getSortLastIndex(nums)

    //kotlin 라이브러리에 있는 binarySearch를 이용해 푼다.
    //binarySearch(찾는값, 시작 index, 끝 index)
    //sortLastIndex의 값보다 작으면 왼쪽에서, 아니면 오른쪽에서 찾는다.
    val result = when {
        nums[sortLastIndex] == target -> sortLastIndex
        sortLastIndex == (nums.size - 1) -> nums.binarySearch(target,0, nums.size)
        nums[sortLastIndex] > target && target >= nums[0] -> nums.binarySearch(target,0, sortLastIndex)
        else -> nums.binarySearch(target, sortLastIndex + 1, nums.size)
    }
    return if(result <= -1) -1 else result
}


fun main() {
    val nums = intArrayOf(3,1)
//    val nums = intArrayOf(4,5,6,7,0,1,2)
    val target = 1

//    println(searchBruteForce(nums,target))
    println(nums.contentToString())
    println(searchBinarySearch(nums, target))
}