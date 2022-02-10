package backjoon.`202201`

import java.util.*

internal object LineUp1015Kt {
    class Point(var num: Int, var index: Int) : Comparable<Point> {
        override fun compareTo(o: Point): Int {
            if (num != o.num) return num - o.num
            return if (index != o.index) index - o.index else 0
        }
    }
    @JvmStatic
    fun main(args: Array<String>)= with(Scanner(System.`in`)) {
        val N = nextInt()
        val arr = arrayOfNulls<Point>(N)
        val result = IntArray(N)
        for (i in 0 until N) {
            arr[i] = Point(nextInt(), i)
        }
        Arrays.sort(arr)
        for (i in 0 until N) {
            result[arr[i]!!.index] = i
        }
        for (num in result) {
            print("$num ")
        }
        println()
    }
}