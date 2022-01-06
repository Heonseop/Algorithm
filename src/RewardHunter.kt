import java.util.*

/*
백준 문제: 15953번
상금 헌터
https://www.acmicpc.net/problem/15953
사실 함수를 이렇게 까지 안 나눠도 될것 같지만 연습 겸 나눠 보았다.
 */

fun getFirstCompetitionRewards(): List<Pair<Int, Int>> {
    return listOf(
        Pair(500, 1),
        Pair(300, 2),
        Pair(200, 3),
        Pair(50, 4),
        Pair(30, 5),
        Pair(10, 6),
    )
}

fun getSecondCompetitionRewards(): List<Pair<Int, Int>> {
    return listOf(
        Pair(512, 1),
        Pair(256, 2),
        Pair(128, 4),
        Pair(64, 8),
        Pair(32, 16),
    )
}

fun getReward(ranking: Int, competitionRewards: List<Pair<Int, Int>>): Int {
    var result = 0
    var checkRaking = 0

    if(ranking == 0) return 0

    run {
        competitionRewards.forEach { i ->
            checkRaking += i.second
            if (ranking <= checkRaking) {
                result = i.first
                return@run
            }
        }
    }
    return result * 10000
}

fun getResult(
    input: Pair<Int,Int>,
    firstCompetitionRewards: List<Pair<Int, Int>>,
    secondCompetitionRewards: List<Pair<Int, Int>>
) = getReward(input.first, firstCompetitionRewards) + getReward(input.second, secondCompetitionRewards)

fun main() = with(Scanner(System.`in`)) {
    val case = nextInt()
    val firstCompetitionRewards = getFirstCompetitionRewards()
    val secondCompetitionRewards = getSecondCompetitionRewards()
    for (i in 0 until case) {
        val input: Pair<Int,Int> = Pair(nextInt(),nextInt())
        println(getResult(input, firstCompetitionRewards, secondCompetitionRewards))
    }
}