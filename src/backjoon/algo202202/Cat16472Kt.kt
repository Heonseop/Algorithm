package backjoon.algo202202

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

internal object Cat16472Kt {
    var N = 0
    var inputArr: CharArray = charArrayOf()
    var result = 0
    var map = HashMap<Char, Int>()
    fun solution() {
        map[inputArr[0]] = 1
        var L = 0
        var R = 0
        while (L < inputArr.size) {
            while (R < inputArr.size - 1) {
                if (!map.containsKey(inputArr[R + 1]) && map.size == N) {
                    break
                }
                if (map.containsKey(inputArr[R + 1])) {
                    map[inputArr[R + 1]] = map[inputArr[R + 1]]!! + 1
                } else {
                    map[inputArr[R + 1]] = 1
                }
                R++
            }
            result = Math.max(result, R - L + 1)
            if (map.containsKey(inputArr[L])) {
                if (map[inputArr[L]] == 1) {
                    map.remove(inputArr[L])
                } else {
                    map[inputArr[L]] = map[inputArr[L]]!! - 1
                }
            }
            L++
        }
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        N = br.readLine().toInt()
        inputArr = br.readLine().toCharArray()
        solution()
        println(result)
    }
}