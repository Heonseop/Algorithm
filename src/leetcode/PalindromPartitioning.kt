package leetcode


/*
    131. Palindrome Partitioning
    주어진 문자열 s를 이용해 회문을 모두 찾는 문제
    재귀호출을 이용해서 회문의 조합을 확인하고 넣어준다
    Runtime: 1201 ms, faster than 50.00% of Kotlin online submissions for Palindrome Partitioning.
    Memory Usage: 186.1 MB, less than 36.11% of Kotlin online submissions for Palindrome Partitioning.
 */
fun partition(s: String): List<List<String>> {
    val result: MutableList<List<String>> = ArrayList()
    recursive(s, 0, result, ArrayList<String>())
    return result
}

private fun recursive(s: String, index: Int, result: MutableList<List<String>>, temp: MutableList<String>) {
    //다 찾았을 경우 결과에 넣어준다.
    if (index == s.length) {
        result.add(ArrayList(temp))
    } else {
        for (i in index until s.length) {
            //회문일 경우
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1))
                //재귀호출 다시 수행
                recursive(s, i + 1, result, temp)
                //완료되면 마지막 입력된 문자열을 제거하고 다시 반복문 수행
                temp.removeAt(temp.size - 1)
            }
        }
    }
}

//회문인지 확인 하는 문자열
private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
    var startIndex = start
    var endIndex = end
    while (startIndex < endIndex) {
        //양끝이 같지 않다면 false
        if (s[startIndex++] != s[endIndex--]) {
            return false
        }
    }
    return true
}

fun main() {
    val s = "a"
    println(partition(s))
}