package backjoon

import java.util.*

object Card11652Kt {
    class CardInfo(var num: Long, private var cnt: Int) : Comparable<CardInfo> {
        override fun compareTo(other: CardInfo): Int {
            return if (cnt != other.cnt) other.cnt - cnt else num.compareTo(other.num)
        }
    }

    var N = 0

    @JvmStatic
    fun main(args: Array<String>) = with(Scanner(System.`in`)) {
        N = nextInt()
        val map = HashMap<Long, Int>()
        val arr = ArrayList<CardInfo>()
        for (i in 0 until N) {
            val currentNm = nextLong()
            if (map.containsKey(currentNm)) {
                map[currentNm] = map[currentNm]!! + 1
            } else {
                map[currentNm] = 1
            }
        }
        val keys = ArrayList(map.keys)
        val values = ArrayList(map.values)
        for (i in 0 until map.size) {
            arr.add(CardInfo(keys[i], values[i]))
        }
        arr.sort()
        println(arr[0].num)
    }
}