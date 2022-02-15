package backjoon.algo202201

import java.util.*

/*
       사용 알고리즘: Parametric Search: 정답을 매개 변수로 만들고 y/s문제(결정 문제)로 바꿔보기
       아이디어: 어떤 높이로 잘랐을 때, 원하는 길이의 나무를 얻을 수 있는가? y or n
    */
internal object CutTree2805Kt {
    var N = 0
    var wantLength = 0
    var arr: IntArray = intArrayOf()
    var result: Long = 0L
    fun checkSum(h: Long): Boolean {
        var sum: Long = 0
        for (i in 1 until N + 1) {
            if (arr[i] > h) {
                sum += arr[i] - h
            }
        }
        return sum >= wantLength
    }

    fun solution() {
        var l: Long = 1
        var r: Long = 2000000000
        while (l <= r) {
            val mid = (l + r) / 2
            if (checkSum(mid)) {
                l = mid + 1
                result = mid
            } else {
                r = mid - 1
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) = with(Scanner(System.`in`)) {
        result = 0
        N = nextInt()
        wantLength = nextInt()
        arr = IntArray(N + 1)
        for (i in 1..N) {
            arr[i] = nextInt()
        }
        solution()
        println(result)
    }
}