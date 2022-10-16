package leetcode

import kotlin.math.max

//554. Brick Wall
fun leastBricks(wall: List<List<Int>>): Int {
    //세로 기준으로 틈이 있는지 확인하기 위해 기록
    val gap: MutableMap<Int, Int> = HashMap()

    //한 라인당 체크
    for (bricks in wall) {
        var position = 0
        for (i in 0 until bricks.size - 1) {
            position += bricks[i]
            gap[position] = gap.getOrDefault(position, 0) + 1
        }
    }

    var maxGap = 0
    val gaps = gap.values
    //가장 많은 틈이 있는 곳을 찾는다.
    gaps.forEach {
        maxGap = max(maxGap, it)
    }
    //전체 개수에서 틈이 가장 많은 케이스를 뺀다.
    return wall.size - maxGap
}

fun main() {
    val wall = listOf(
        listOf(1, 2, 2, 1),
        listOf(3, 1, 2),
        listOf(1, 3, 2),
        listOf(2, 4),
        listOf(3, 1, 2),
        listOf(1, 3, 1, 1)
    )
    println(leastBricks(wall))
}