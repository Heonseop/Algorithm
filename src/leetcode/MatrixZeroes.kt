import java.util.*

/*
73. Set Matrix Zeroes
Runtime: 528 ms, faster than 5.88% of Kotlin online submissions for Set Matrix Zeroes.
Memory Usage: 64.6 MB, less than 5.88% of Kotlin online submissions for Set Matrix Zeroes.
 */
fun setZeroes(matrix: Array<IntArray>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                queue.add(Pair(i, j))
            }
        }
    }
    queue.forEach {
        for (i in matrix.indices) {
            matrix[i][it.second] = 0
        }
        for (i in matrix[0].indices) {
            matrix[it.first][i] = 0
        }
    }
    print(matrix.contentDeepToString())
}

fun main() {
    val matrix = arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5))
    setZeroes(matrix)
}
