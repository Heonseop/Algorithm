package backjoon.`202201`

import java.util.*

var N = 0
var S = 0
var result = 0
private var arr: IntArray = intArrayOf()

private fun solution(k: Int, currentNum: Int) {
    if (k == N) {
        if (currentNum == S) {
            result++
        }
    } else {
        //현재 값을 선택한 경우
        solution(k + 1, currentNum + arr[k])

        //현재 값을 선택하지 않은 경우
        solution(k + 1, currentNum)
    }
}

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    S = nextInt()
    arr = IntArray(N)
    result = 0
    for (i in 0 until N) {
        arr[i] = nextInt()
    }
    solution(0, 0)
    if (S == 0) {
        result--
    }
    println(result)
}
