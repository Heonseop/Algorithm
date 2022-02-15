package backjoon.algo202202

import java.io.BufferedReader
import java.io.InputStreamReader

internal object Loun13144Kt {
    var N = 0
    private var inputArr: IntArray = intArrayOf()
    fun solution(): Long {
        var R = 0
        var result: Long = 0
        val countArr = IntArray(100001)
        for (L in 0 until N) {
            while (R < N) {
                if (countArr[inputArr[R]] == 0) {
                    countArr[inputArr[R]]++
                    R++
                } else {
                    break
                }
            }
            result += (R - L).toLong()
            countArr[inputArr[L]]--
        }
        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        N = br.readLine().toInt()
        inputArr = IntArray(N)
        val input = br.readLine().split(" ".toRegex()).toTypedArray()
        for (i in 0 until N) {
            inputArr[i] = input[i].toInt()
        }
        println(solution())
        br.close()
    }
}