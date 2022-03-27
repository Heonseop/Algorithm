package leetcode

/*
LEETCODE 934. Shortest Bridge
Runtime: 809 ms, faster than 55.56% of Kotlin online submissions for Shortest Bridge.
Memory Usage: 83.5 MB, less than 66.67% of Kotlin online submissions for Shortest Bridge.
 */
val bfs:MutableList<Pair<Int,Int>> = mutableListOf()
val dx = intArrayOf( -1,1,0,0 )
val dy = intArrayOf( 0,0,-1,1 )

fun getFirst(grid: Array<IntArray>):Pair<Int,Int>{
    for (i in grid.indices){
        for (j in grid[0].indices){
            if(grid[i][j] == 1){
                return i to j
            }
        }
    }
    return -1 to -1
}

fun dfs(grid: Array<IntArray>, x:Int, y:Int){
    grid[x][y] = -1
    //bfs를 위해 위치값을 저장한다.
    bfs.add(x to y)
    for (i in 0 until 4){
        val cx = x + dx[i]
        val cy = y + dy[i]
        if((0 <= cx) && (cx < grid.size) && 0 <= cy && cy < grid[0].size && grid[cx][cy] == 1){
            dfs(grid, cx,cy)
        }
    }
}

fun shortestBridge(grid: Array<IntArray>): Int {
    //첫번째 섬을 찾는다.
    val (i,j) = getFirst(grid)
    val newBfs:MutableList<Pair<Int,Int>> = mutableListOf()

    //첫번째 섬과 연결된 육지를 전부 -1로 변경한다.
    dfs(grid,i,j)

    // 0을 변경한 개수의 값, 결과값
    var step = 0

    //bfs 알고리즘 사용
    while(bfs.isNotEmpty()){
        for( (x, y) in bfs){
            for (index in 0 until 4){
                val cx = x + dx[index]
                val cy = y + dy[index]
                if(0<=cx && cx < grid.size && 0<=cy && cy < grid[0].size){
                    if(grid[cx][cy] == 1){
                        //다른 육지가 접근된 경우 결과 종료
                        return step
                    }else if(grid[cx][cy] == 0){
                        //아닌 경우 -1로 대체하고 새로운 bfs를 위해 위치값 저장
                        grid[cx][cy] = -1
                        newBfs.add(cx to cy)
                    }
                }

            }
        }
        step++

        //새로운 bfs를 위해 처리
        bfs.clear()
        bfs.addAll(newBfs)
    }
    return 0
}

fun main(){
    val grid = arrayOf(
        intArrayOf(0,1),
        intArrayOf(1,0)
    )
    print(shortestBridge(grid))
}