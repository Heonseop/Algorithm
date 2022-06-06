package leetcode

import java.lang.Integer.min

/*
Runtime: 398 ms, faster than 13.51% of Kotlin online submissions for Restore IP Addresses.
Memory Usage: 37.5 MB, less than 45.95% of Kotlin online submissions for Restore IP Addresses.
*/
fun restoreIpAddresses(s: String): List<String> {
    if (s.length < 4) return emptyList()

    val result = mutableListOf<String>()
    val temp = mutableListOf<String>()
    val ip = mutableListOf<String>()
    recurve(0, s, ip, temp, result)
    return result
}

//back트래킹을 이용해 문제 품
private fun recurve(
    index: Int,
    inputStr: String,
    ip: MutableList<String>,
    temp: MutableList<String>,
    result: MutableList<String>
) {
    if (ip.size > 4) return
    else if (index == inputStr.length && ip.size == 4) {
        val res = ip.joinToString(".")
        result.add(res)
        return
    }
    val idx = index + 3
    for (i in index until min(inputStr.length, idx)) {
        val numberStr = inputStr.substring(index, i + 1)
        if (validIp(numberStr)) {
            temp.add(numberStr)
            recurve(index + numberStr.length, inputStr, temp, temp, result)
            //removeLast로 대체가능 하나 leetcode에서 인식 안됨
            temp.removeAt(temp.size - 1)
        }
    }
}

private fun validIp(str: String): Boolean {
    if (str.length == 1) {
        return true
    }
    if (str.toInt() > 255 || str[0] == '0') {
        return false
    }
    return true
}

fun main() {
    val s = "101023"
    print(restoreIpAddresses(s))
}