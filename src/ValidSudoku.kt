/*
36. Valid Sudoku

brute force

Runtime: 228 ms, faster than 27.70% of Kotlin online submissions for Valid Sudoku.
Memory Usage: 42.9 MB, less than 22.30% of Kotlin online submissions for Valid Sudoku.
 */
fun isValidSudoku(board: Array<CharArray>): Boolean {
    for ( i  in board.indices) {
        val set = mutableSetOf<Char>()
        for ( j in board.indices){
            if(board[i][j] != '.'){
                if(set.contains(board[i][j])){
                    return false
                } else {
                    set.add(board[i][j])
                }
            }
        }
    }

    for ( i  in board.indices) {
        val set = mutableSetOf<Char>()
        for ( j in board.indices){
            if(board[j][i] != '.'){
                if(set.contains(board[j][i])){
                    return false
                } else {
                    set.add(board[j][i])
                }
            }
        }
    }

    for ( i in board.indices step 3) {
        for( j in board.indices step 3){
            val set = mutableSetOf<Char>()
            for( r in i..i+2){
                for ( l in j..j+2){
                    if(board[r][l] != '.'){
                        if(set.contains(board[r][l])){
                            return false
                        } else {
                            set.add(board[r][l])
                        }
                    }
                }
            }
        }
    }

    return true
}

fun main() {
   val board = arrayOf(charArrayOf('5','3','.','.','7','.','.','.','.')
       ,charArrayOf('6','.','.','1','9','5','.','.','.')
       ,charArrayOf('.','9','8','.','.','.','.','6','.')
       ,charArrayOf('8','.','.','.','6','.','.','.','3')
       ,charArrayOf('4','.','.','8','.','3','.','.','1')
       ,charArrayOf('7','.','.','.','2','.','.','.','6')
       ,charArrayOf('.','6','.','.','.','.','2','8','.')
       ,charArrayOf('.','.','.','4','1','9','.','.','5')
       ,charArrayOf('.','.','.','.','8','.','.','7','9'))

    print(isValidSudoku(board))
}