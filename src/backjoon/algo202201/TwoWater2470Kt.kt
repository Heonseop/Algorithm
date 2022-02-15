package backjoon.algo202201

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

fun lower_bound(arr: IntArray, l: Int, r: Int, x: Int): Int {
    var l = l
    var r = r
    var result = r + 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (arr[mid] >= x) {
            result = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    return result
}

@Throws(IOException::class)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arr = IntArray(N + 1)
    var result = Int.MAX_VALUE
    var w1 = 0
    var w2 = 0
    val inputStr = readLine().split(" ".toRegex()).toTypedArray()
    for (i in 1..N) {
        arr[i] = inputStr[i - 1].toInt()
    }
    Arrays.sort(arr, 1, N + 1)
    for (left in 1 until N) {
        val canNum = lower_bound(arr, left + 1, N, -arr[left])
        if (left < canNum - 1 && Math.abs(arr[canNum - 1] + arr[left]) < result) {
            result = Math.abs(arr[canNum - 1] + arr[left])
            w1 = arr[left]
            w2 = arr[canNum - 1]
        }
        if (canNum <= N && Math.abs(arr[canNum] + arr[left]) < result) {
            result = Math.abs(arr[canNum] + arr[left])
            w1 = arr[left]
            w2 = arr[canNum]
        }
    }
    println("$w1 $w2")
}