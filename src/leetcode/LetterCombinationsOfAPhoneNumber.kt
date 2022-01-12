/*
    17. Letter Combinations of a Phone Number
    Runtime: 176 ms, faster than 51.68% of Kotlin online submissions for Letter Combinations of a Phone Number.
    Memory Usage: 36.3 MB, less than 45.64% of Kotlin online submissions for Letter Combinations of a Phone Number.
 */
fun letterCombinations(digits: String): List<String> {
    val map: HashMap<Char, List<String>> = hashMapOf()
    map['2'] = listOf("a", "b", "c")
    map['3'] = listOf("d", "e", "f")
    map['4'] = listOf("g", "h", "i")
    map['5'] = listOf("j", "k", "l")
    map['6'] = listOf("m", "n", "o")
    map['7'] = listOf("p", "q", "r", "s")
    map['8'] = listOf("t", "u", "v")
    map['9'] = listOf("w", "x", "y", "z")

    var result = emptyList<String>()
    val wordList = mutableListOf<List<String>>()
    if (digits.isEmpty()) {
        return emptyList()
    } else {
        if (digits.length == 1) {
            return map[digits[0]] ?: emptyList()
        } else {
            for (digit in digits) {
                wordList.add(map[digit] ?: emptyList())
            }
        }
    }
    var prevWordList = wordList[0]

    for (index in 1 until digits.length) {
        result = makeWord(prevWordList,map[digits[index]] ?: emptyList())
        prevWordList = result
    }

    return result
}

fun makeWord(prevList:List<String>, nextList:List<String>):List<String>{
    val result = mutableListOf<String>()
    for(word in prevList){
        for(word2 in nextList){
            result.add(word+word2)
        }
    }
    return result
}

fun main() {
    val digits = "23"
    println(letterCombinations(digits).toString())
}