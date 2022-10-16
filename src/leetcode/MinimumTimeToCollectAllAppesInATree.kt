package leetcode

//1443. Minimum Time to Collect All Apples in a Tree
fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
    val visitedData: HashSet<Int> = HashSet()
    val nearMap: MutableMap<Int, MutableSet<Int>> = HashMap()
    for (i in 0 until n) {
        nearMap[i] = HashSet()
    }
    val e: Int = edges.size
    for (i in 0 until e) {
        nearMap[edges[i][0]]?.add(edges[i][1])
        nearMap[edges[i][1]]?.add(edges[i][0])
    }
    val res: Int = visit(0, visitedData, nearMap, hasApple)
    return if (res == 0) {
        res
    } else res - 2
}

private fun visit(
    node: Int,
    visitedData: HashSet<Int>,
    nearMap: Map<Int, Set<Int>>,
    hasApple: List<Boolean>
): Int {
    if (visitedData.contains(node)) {
        return 0
    }
    visitedData.add(node)
    var res = 0
    for (neighbor in nearMap[node]!!) {
        res += visit(neighbor, visitedData, nearMap, hasApple)
    }
    if (res != 0 || hasApple[node]) {
        res += 2
    }
    return res
}

fun main() {
    val n = 7
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
        intArrayOf(2, 3),
        intArrayOf(2, 6),
    )
    val hasApple = listOf(
        false, false, true, false, true, true, false
    )
    println(minTime(n, edges, hasApple))
}