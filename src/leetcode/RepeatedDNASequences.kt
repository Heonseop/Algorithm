package leetcode

import java.util.*


/*
    187. Repeated DNA Sequences
    DNA 서열은 'A', 'C', 'G', 'T'로 축약된 일련의 뉴클레오타이드로 구성
    반복되는 DNA의 시퀀스를 찾는 문제, 결국 Hash를 이용해 푸는 문제다.
    return 값: DNA 분자에서 한 번 이상 발생하는 10글자 길이의 모든 시퀀스(서브스트링)를 반환합니다.
    1) map을 이용하는 방법이 있다
    2) set을 이용하는 방법
    막상 돌려보면 set이 더 빠르다
    : 이유는 추측해보자면 map의 경우 한번 더 값을 저장하는 로직이 있기 때문인것 같다.
 */

/*
    HashMap을 이용하는 문제
    Runtime: 460 ms, faster than 42.31% of Kotlin online submissions for Repeated DNA Sequences.
    Memory Usage: 51.4 MB, less than 67.31% of Kotlin online submissions for Repeated DNA Sequences.
 */
fun findRepeatedDnaSequencesToMap(s: String): List<String> {
    val result: MutableList<String> = LinkedList()
    val map: MutableMap<String, Int> = HashMap()
    //input값이 10미만이면 빈값을 리턴
    if (s.length < 10) return result
    val len = s.length
    //1. 문자열을 돌면서
    for (i in 0..len - 10) {
        //1.1 subString을 이용해 부분 문자열을 추출
        val sub = s.substring(i, i + 10)
        //1.2 포함되어 있지 않다면 우선 map에 저장
        if (!map.containsKey(sub)) {
            map[sub] = 1
        }
        //1.3 포함되어있을 경우 result값에 저장
        else if (map[sub] == 1) {
            result.add(sub)
            map[sub] = map[sub]!! + 1
        } else continue
    }
    //2. result 반환
    return result
}


/*
    HashSet을 이용하는 문제
    Runtime: 274 ms, faster than 94.23% of Kotlin online submissions for Repeated DNA Sequences.
    Memory Usage: 45.9 MB, less than 80.77% of Kotlin online submissions for Repeated DNA Sequences.
 */
fun findRepeatedDnaSequencesToSet(s: String): List<String> {
    val finder: MutableSet<String> = HashSet()
    val result: MutableSet<String> = HashSet()
    var i = 0
    while (i + 9 < s.length) {
        val ten: String = s.substring(i, i + 10)
        if (!finder.add(ten)) {
            result.add(ten)
        }
        i++
    }
    return ArrayList(result)
}

fun main() {
    val s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    println(findRepeatedDnaSequencesToSet(s).toString())
    println(findRepeatedDnaSequencesToMap(s).toString())
}