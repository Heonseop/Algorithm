package backjoon

import java.util.*

internal object  WordSort1181Kt {
    fun main() {
        val sc = Scanner(System.`in`)
        val N = sc.nextInt()
        val set = HashSet<String>()
        for (i in 0 until N) {
            set.add(sc.nextLine())
        }
        val lists = ArrayList(set)
        lists.sortWith { o1: String, o2: String ->
            if (o1.length != o2.length) {
                o1.length - o2.length
            }else{
                o1.compareTo(o2)
            }
        }
        for (str in lists) {
            println(str)
        }
    }
}