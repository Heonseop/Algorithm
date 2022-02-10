package backjoon.`202201`

import java.util.*

private var bArr: IntArray = intArrayOf()
private fun lowerBound(A: IntArray, L: Int, R: Int, X: Int): Int {
    var l = L
    var r = R
    var result = L - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (A[mid] < X) {
            result = mid
            l = mid + 1
        } else if (A[mid] >= X) {
            r = mid - 1
        }
    }
    return result
}

fun main() = with(Scanner(System.`in`)){
    val N = nextInt()
    for (i in 0 until N) {
        var result = 0
        val aRange = nextInt()
        val bRange = nextInt()
        val aArr = IntArray(aRange + 1)
        bArr = IntArray(bRange + 1)
        for (j in 1..aRange) {
            aArr[j] = nextInt()
        }
        for (j in 1..bRange) {
            bArr[j] = nextInt()
        }
        bArr.sort(1,bRange+1)
        for (j in 1..aRange) {
            result += lowerBound(bArr, 1, bRange, aArr[j])
        }
        println(result)
    }
}
