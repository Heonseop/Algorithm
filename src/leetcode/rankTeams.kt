package leetcode

/*
leetCode 1366
Runtime: 368 ms, faster than 78.57% of Kotlin online submissions for Rank Teams by Votes.
Memory Usage: 42.7 MB, less than 78.57% of Kotlin online submissions for Rank Teams by Votes.
 */
internal class Team(var name: Char, var ranks: IntArray) : Comparable<Team> {
    override fun compareTo(other: Team): Int {
        val checkRanks = checkRanks(this.ranks, other.ranks)
        return if (checkRanks != 0) {
            checkRanks
        } else {
            this.name - other.name
        }
    }

    // list를 비교하여 등수 확인
    private fun checkRanks(ranks1: IntArray, ranks2: IntArray): Int {
        for (index in ranks1.indices) {
            if (ranks1[index] < ranks2[index]) {
                return 1
            } else if (ranks1[index] > ranks2[index]) {
                return -1
            }
        }
        return 0
    }
}

fun rankTeams(votes: Array<String>): String {
    var result = ""
    val maps = mutableMapOf<Char, IntArray>()
    val lists = mutableListOf<Team>()
    /*
        해당 문제에서는 투표마다 등장하는 팀 이름이 같으므로 처음에 다음과 같이 초기화
     */
    votes[0].forEach {
        maps[it] = IntArray(votes[0].length)
    }
    /*
        투표 등수를 각각 팀 이름 기준으로 초기화
     */
    votes.forEach { str ->
        str.forEachIndexed { index, name ->
            maps[name]?.let {
                it[index] += 1
            }
        }
    }
    /*
        list에 넣고 위에서 선언한 sort값으로 sorting
     */
    maps.forEach {
        lists.add(Team(it.key, it.value))
    }

    lists.sort()
    lists.forEach {
        result += it.name
    }

    return result
}

fun main() {
    val votes = arrayOf("WXYZ", "XYZW")
    println(rankTeams(votes))
}