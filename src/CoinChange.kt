import java.lang.Integer.min

/*탐욕 알고리즘은 실패합니다.
    val coins = intArrayOf(186,419,83,408)
    val amount = 6249
    fun coinChange(coins: IntArray, amount: Int): Int {
    var index = coins.size - 1
    var count = 0
    var totAmount = amount
    coins.sort()
    while (true) {
        if(amount == 0){
            count = 0
            break
        } else if(index < 0){
            count = -1
            break
        } else if (coins[index] < totAmount) {
            totAmount -= coins[index]
            count++
        } else if (coins[index] == totAmount) {
            count++
            break
        } else {
            index--
        }
    }

    return count
}
*/
/*
    dp 방식
    Runtime: 304 ms, faster than 34.01% of Kotlin online submissions for Coin Change.
    Memory Usage: 62.4 MB, less than 8.16% of Kotlin online submissions for Coin Change.
 */
fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = Array<Int>(amount + 1) { 10001 }
    println(dp.contentDeepToString())

    dp[0] = 0
    for (checkAmount in 1..amount) {
        for (coin in coins) {
            if (coin <= checkAmount) {
                dp[checkAmount] = min(dp[checkAmount], dp[checkAmount - coin] + 1)
            }
        }
    }

    return if (dp[amount] == 10001) -1 else dp[amount]
}

fun main() {
    val coins = intArrayOf(1)
    val amount = 2
    print(coinChange(coins, amount))
}