package leetcode

/*
49. Group Anagrams : anagram을 그룹핑하라
ex) "eat","tea","ate" -> (a,e,t) 를 기준으로 그룹핑 가능하다.
HashMap을 이용하는게 제일 나을듯 하다.
key: 각각의 문자열 정렬값
value: 각 키 값에 할당되는 그룹 value

주의 : 이 문구 때문에 가능한 풀이이다.
일반적으로 모든 원본 글자를 정확히 한 번 사용합니다.
 */

/*
방법 1. key를 mutableMapOf<Char, Int>() 으로 사용
Runtime: 465 ms, faster than 88.37% of Kotlin online submissions for Group Anagrams.
Memory Usage: 44.8 MB, less than 91.15% of Kotlin online submissions for Group Anagrams.
 */
fun groupAnagrams1(strs: Array<String>): List<List<String>> {
    val results = mutableMapOf<Map<Char, Int>, List<String>>()

    //1. 배열 내 문자열을 비교한다.
    strs.forEach { str ->
        val key = mutableMapOf<Char, Int>()
        //2. 문자열의 char를 기준으로 key를 생성한다.
        str.forEach {
            //2.1 ?: kotlin 문법으로 값이 없을 경우 ?: 뒤의 값을 default 값으로 처리
            //key 정보 세팅
            key[it] = (key[it] ?: 0) + 1
            //println("$str $it ${key[it]}")
        }
        // kotlin 에서는 자동으로 Map이더라도 동일 key로 인식하는 것으로 보인다.
        // 다른 언어에서도 동일한지는 확인이 필요합니다.
        results[key] = (results[key] ?: listOf()) + str
        // println("   $key ${results[key]} $str")

        /*
        예제 프로세스
        eat e 1
        eat a 1
        eat t 1
           {e=1, a=1, t=1} [eat] eat
        tea t 1
        tea e 1
        tea a 1
        {t=1, e=1, a=1} [eat, tea] tea
        tan t 1
        tan a 1
        tan n 1
           {t=1, a=1, n=1} [tan] tan
        ate a 1
        ate t 1
        ate e 1
           {a=1, t=1, e=1} [eat, tea, ate] ate
        nat n 1
        nat a 1
        nat t 1
           {n=1, a=1, t=1} [tan, nat] nat
        bat b 1
        bat a 1
        bat t 1
           {b=1, a=1, t=1} [bat] bat
        result : [[eat, tea, ate], [tan, nat], [bat]]
         */

    }

    return results.values.toList()
}

/*
방법2. 혹시나 map이 key로 인식안되는 언어를 위한 방법
sorting한 후에 key를 String으로 넣는다.
확실히 sorting을 하는 로직이 있다보니 느리다.

Runtime: 780 ms, faster than 40.98% of Kotlin online submissions for Group Anagrams.
Memory Usage: 75 MB, less than 58.68% of Kotlin online submissions for Group Anagrams.
 */
fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val results = mutableMapOf<String, List<String>>()

    //1. 배열 내 문자열을 비교한다.
    strs.forEach { str ->
        // 문자열을 sorting 한다.
        val key = str.toCharArray().sorted().toString()
        // 다른 언어에서도 동일한지는 확인이 필요합니다.
        results[key] = (results[key] ?: listOf()) + str
    }

    return results.values.toList()
}

fun main() {
    val s = arrayOf(
        "eat", "tea", "tan", "ate", "nat", "bat"
    )
    println(groupAnagrams1(s).toString())
    println(groupAnagrams2(s).toString())
}