package backjoon.algo202201

import java.util.*

internal object NQueenKt {
    var N = 0
    var result = 0
    private var map: IntArray = intArrayOf()
    private fun isAttack(row1: Int, col1: Int, row2: Int, col2: Int): Boolean {
        return col1 == col2 || row1 - col1 == row2 - col2 || row1 + col1 == row2 + col2
    }

    private fun solution(k: Int) {
        if (k == N + 1) {
            result++
        } else {
            for (i in 1..N) {
                var isSelect = true
                for (j in 1 until k) {
                    if (isAttack(k, i, j, map[j])) {
                        isSelect = false
                        break
                    }
                }
                if (isSelect) {
                    map[k] = i
                    solution(k + 1)
                    map[k] = 0
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) =  with(Scanner(System.`in`)) {
        N = nextInt()
        map = IntArray(N + 1)
        result = 0
        solution(1)
        println(result)
    }
}