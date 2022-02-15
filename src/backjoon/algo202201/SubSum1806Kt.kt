package backjoon.algo202201

import java.util.*

internal object SubSum1806Kt {
    var N = 0
    var S = 0
    var arr: IntArray = intArrayOf()
    var result = 0
    fun solution() {
        var r = 0
        var sum = 0
        for (i in 1..N) {
            sum -= arr[i - 1]
            while (r + 1 <= N && sum < S) {
                r++
                sum += arr[r]
            }
            if (sum >= S) {
                result = Math.min(result, r - i + 1)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        N = sc.nextInt()
        S = sc.nextInt()
        arr = IntArray(N + 1)
        result = N + 1
        for (i in 1..N) {
            arr[i] = sc.nextInt()
        }
        solution()
        if (result == N + 1) {
            println(0)
        } else {
            println(result)
        }
    }
}