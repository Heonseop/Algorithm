package backjoon

import java.util.Scanner
import java.util.ArrayList
import kotlin.math.abs

internal object DrawArrow15970Kt {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val N = sc.nextInt()
        var result = 0
        val lists = ArrayList<ArrayList<Int>>()
        for (i in 0..N + 1) {
            lists.add(ArrayList())
        }
        var index: Int
        var color: Int
        for (i in 0 until N) {
            index = sc.nextInt()
            color = sc.nextInt()
            lists[color].add(index)
        }
        for (list in lists) {
            if (list.size == 0) {
                continue
            }
            list.sort()
            for (i in list.indices) {
                result += when {
                    (i == 0) -> {
                        abs(list[i] - list[i + 1])
                    }
                    (i == list.size - 1) -> {
                        abs(list[i] - list[i - 1])
                    }
                    else -> {
                        abs(list[i] - list[i - 1]).coerceAtMost(abs(list[i] - list[i + 1]))
                    }
                }
            }
        }
        println(result)
    }
}