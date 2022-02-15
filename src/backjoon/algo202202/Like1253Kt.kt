package backjoon.algo202202

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

internal object Like1253Kt {
    var N = 0
    var inputArr: IntArray = intArrayOf()
    var result = 0
    fun isLikeNums(targetIdx: Int): Boolean {
        val targetNum = inputArr[targetIdx]
        var L = 0
        var R = N - 1
        while (L < R) {
            if (L == targetIdx) {
                L++
                continue
            }
            if (R == targetIdx) {
                R--
                continue
            }
            if (targetNum == inputArr[L] + inputArr[R]) {
                return true
            } else if (targetNum < inputArr[L] + inputArr[R]) {
                R--
            } else {
                L++
            }
        }
        return false
    }

    fun solution() {
        Arrays.sort(inputArr)
        for (i in 0 until N) {
            if (isLikeNums(i)) {
                result++
            }
        }
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        N = br.readLine().toInt()
        inputArr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        solution()
        println(result)
    }
}