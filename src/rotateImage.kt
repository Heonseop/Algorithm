/*
48. rotate Image
Runtime: 184 ms, faster than 37.75% of Kotlin online submissions for Rotate Image.
Memory Usage: 36.6 MB, less than 6.37% of Kotlin online submissions for Rotate Image.
 */

fun rotate(matrix: Array<IntArray>) {
    transpose(matrix)
    reflect(matrix)
    println(matrix.contentDeepToString())
}

fun transpose(matrix: Array<IntArray>) {
    val matrixSize = matrix.size
    for (i in 0 until matrixSize) {
        for (j in i until matrixSize) {
            val temp = matrix[j][i]
            matrix[j][i] = matrix[i][j]
            matrix[i][j] = temp
        }
    }
}

fun reflect(matrix: Array<IntArray>) {
    val matrixSize = matrix.size
    for (i in 0 until matrixSize) {
        for (j in 0 until matrixSize / 2) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[i][matrixSize - j - 1]
            matrix[i][matrixSize - j - 1] = temp
        }
    }
}

/*
    Runtime: 184 ms, faster than 37.75% of Kotlin online submissions for Rotate Image.
    Memory Usage: 36.4 MB, less than 6.37% of Kotlin online submissions for Rotate Image.
 */
fun rotate2(matrix: Array<IntArray>) {
    val matrixSize = matrix.size
    for ( i in 0 until (matrixSize + 1)/2){
        for ( j in 0 until (matrixSize / 2)){
            val temp = matrix[matrixSize - 1 - j][i]
            matrix[matrixSize - 1 - j][i] = matrix[matrixSize - 1 - i][matrixSize - j - 1]
            matrix[matrixSize - 1 - i][matrixSize - j - 1] = matrix[j][matrixSize - 1 - i]
            matrix[j][matrixSize - 1 - i] = matrix[i][j]
            matrix[i][j] = temp
        }
    }
    println(matrix.contentDeepToString())
}

fun main() {
    val matrix: Array<IntArray> = arrayOf(
        intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16)
    )
    rotate(matrix)

    val matrix2: Array<IntArray> = arrayOf(
        intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16)
    )
    rotate2(matrix2)
}