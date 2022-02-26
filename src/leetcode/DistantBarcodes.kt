package leetcode

import java.util.*

/*
Runtime: 1081 ms, faster than 100.00% of Kotlin online submissions for Distant Barcodes.
Memory Usage: 73.1 MB, less than 100.00% of Kotlin online submissions for Distant Barcodes.
 */
fun rearrangeBarcodes(barcodes: IntArray): IntArray {
    val map: MutableMap<Int, Int> = HashMap()
    val result = IntArray(barcodes.size)
    Arrays.fill(result, -1)
    Arrays.sort(barcodes)

    //map으로 각 숫자의 개수 카운팅 시작
    for (i in barcodes.size - 1 downTo 0) {
        map[barcodes[i]] = map.getOrDefault(barcodes[i], 0) + 1
    }

    //map의 value값의 크기를 기준으로 하는 우선순위 큐를 선언
    val pq = PriorityQueue { (_, value1): Map.Entry<Int, Int>, (_, value2): Map.Entry<Int, Int> ->
        value2 - value1
    }

    //map의 key value 를 우선순위 큐에 모두 추가
    pq.addAll(map.entries)

    var index = 0
    while (!pq.isEmpty()) {
        val (curKey, curValue) = pq.poll()
        val key = curKey
        val value = curValue
        var j = value
        while (j > 0) {
            //해당 index에 선언되지 않았다면 값을 넣고, 같은 값이 근처에 없게 하기 위해 index를 +2
            //이미 해당 index에 값이 있다면 index+1
            //index를 기준으로 찾아봤는데 끝까지 다 돌았으면 다시 처음부터 다시 찾기 시작
            //해당 숫자의 카운팅만큼 계속 진행
            if (result[index] == -1) {
                result[index] = key
                index += 2
                j--
            } else {
                index++
            }
            if (index >= result.size) {
                index = 0
            }
        }
    }
    return result
}

fun main() {
    val barcodes = intArrayOf(1, 4, 1, 1, 2, 2, 3)
    println(rearrangeBarcodes(barcodes).contentToString())
}