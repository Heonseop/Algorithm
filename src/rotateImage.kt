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
    println(matrix.contentDeepToString())
    //0<=i<matrixSize
    for (i in 0 until matrixSize) {
        //i<=j<matrixSize
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
    //0 <= i < (matrixSize + 1)/2 (홀짝 관계없도록 +1 사전 추가)
    for ( i in 0 until (matrixSize + 1)/2){
        //0 <= i < (matrixSize)/2
        for ( j in 0 until (matrixSize / 2)){
            //swap을 위해 테두리 값중 하나를 저장 이후 각 테두리 위치 이동
            val temp = matrix[matrixSize - 1 - j][i]
            matrix[matrixSize - 1 - j][i] = matrix[matrixSize - 1 - i][matrixSize - j - 1]
            matrix[matrixSize - 1 - i][matrixSize - j - 1] = matrix[j][matrixSize - 1 - i]
            matrix[j][matrixSize - 1 - i] = matrix[i][j]
            matrix[i][j] = temp
        }
    }
}
/*
    Runtime: 168 ms, faster than 80.88% of Kotlin online submissions for Rotate Image.
    Memory Usage: 35.4 MB, less than 59.31% of Kotlin online submissions for Rotate Image.
 */
fun rotate3(matrix: Array<IntArray>){
    val matrixSize = matrix.size
    //matrix와 동일한 사이즈로 초기화
    val temp = Array(matrixSize){Array(matrixSize){0} }

    //temp에 행과 열을 바꾸는 방식으로 값 변경
    for (i in 0 until matrixSize){
        for (j in 0 until matrixSize){
            temp[j][i] = matrix[matrixSize-1-i][j]
        }
    }

    //temp의 값을 기존 matrix에 복사
    for (i in 0 until matrixSize){
        for (j in 0 until matrixSize){
            matrix[j][i] = temp[j][i]
        }
    }
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

    val matrix3: Array<IntArray> = arrayOf(
        intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16)
    )
    rotate3(matrix3)
}