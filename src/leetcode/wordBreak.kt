package leetcode

/*
leetCode 139. Word Break
Runtime: 178 ms, faster than 93.85% of Kotlin online submissions for Word Break.
Memory Usage: 35.7 MB, less than 81.15% of Kotlin online submissions for Word Break.
 */
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val dp = BooleanArray(s.length + 1) { false }
    dp[0] = true
    //순서대로 문자길이까지 검사하고난 뒤 wordDict에서 있으면 true로 반환
    for (i in 1..s.length) {
        for (j in 0 until i) {
            //문자열 s의 j번째 인덱스부터 n 번째 인덱스까지의 부분 문자열이 wordDict에 있으면 True, 이때 j는 dp[j]의 값이 True여야 한다.
            if (dp[j] && s.substring(j, i) in wordDict) {
                println("j: $j, i: $i, dp[j] : ${dp[j]}, substring : ${s.substring(j, i)}")
                dp[i] = true
                break
            }
        }
    }
    println(dp.contentToString())
    return dp[dp.size - 1]
}

fun main() {
    val s = "leetcode"
    val wordDict = listOf("leet", "code")

//    val s = "applepenapple"
//    val wordDict = listOf("apple","pen")

//    val s = "catsandog"
//    val wordDict = listOf("cats","dog","sand","and","cat")
    println(wordBreak(s, wordDict))
}