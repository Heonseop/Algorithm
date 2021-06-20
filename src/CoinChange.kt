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
    /*최대값이 10000이어서 혹시몰라 10001로 전체를 초기화 합니다.
      해당 코드는 int 형 배열을 amount+1 크기로 초기화
      (우리의 목적은 amount일때 코인값이기 때문에 +1)
    * */
    val dp = Array<Int>(amount + 1) { 10001 }

    dp[0] = 0
    //1<= x <= amount
    for (checkAmount in 1..amount) {
        //코인들의 배열을 순회합니다.
        for (coin in coins) {
            /*현재 값기준에서 coin값이 적다면
              즉, 코인을 변환할 수 있다면
             */
            if (coin <= checkAmount) {
                /*
                   현재 값기준으로 최소로 변환 할수 있는 값을 구합니다.
                 */
                dp[checkAmount] = min(dp[checkAmount], dp[checkAmount - coin] + 1)
            }
        }
    }
    //최종 목적지 값이 변경 안됬을 경우는 요청사항에 따라 -1 로 변경합니다.
    return if (dp[amount] == 10001) -1 else dp[amount]
}

fun main() {
    val coins = intArrayOf(1)
    val amount = 2
    print(coinChange(coins, amount))
}