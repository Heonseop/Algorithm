package backjoon.algo202201

import java.util.*

internal object ShareMachine2110Kt {
    var N = 0
    var C = 0
    var arr: IntArray = intArrayOf()
    var result = 0
    fun isInstallShare(distance: Int): Boolean {
        var startIndex = arr[0]
        var shareMachineNum = 1
        for (i in 1 until arr.size) {
            if (arr[i] - startIndex >= distance) {
                shareMachineNum++
                startIndex = arr[i]
            }
        }
        return shareMachineNum >= C
    }

    fun solution() {
        var l = 0
        var r = 1000000000
        while (l <= r) {
            val mid = (l + r) / 2
            if (isInstallShare(mid)) {
                l = mid + 1
                result = mid
            } else {
                r = mid - 1
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        N = sc.nextInt()
        C = sc.nextInt()
        arr = IntArray(N)
        for (i in 0 until N) {
            arr[i] = sc.nextInt()
        }
        Arrays.sort(arr)
        solution()
        println(result)
    }
}