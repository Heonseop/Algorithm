package leetcode
import java.util.Stack
/*
LeetCode : 946. Validate Stack Sequences

Runtime: 320 ms, faster than 51.28% of Kotlin online submissions for Validate Stack Sequences.
Memory Usage: 39.8 MB, less than 76.19% of Kotlin online submissions for Validate Stack Sequences.
 */
fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {

    val stack = Stack<Int>()
    var pushIndex = 0
    var popIndex = 0
    val result:Boolean
    stack.push(pushed[pushIndex++])

    while(true){

        if(pushIndex == pushed.size && popIndex == popped.size  && stack.size > 0){
            result = false
            break
        }

        if(pushIndex == pushed.size && popIndex == popped.size){
            result = true
            break
        }

        if(pushIndex == pushed.size && stack.peek() != popped[popIndex]){
            result = false
            break
        }

        if(!stack.empty() && stack.peek() == popped[popIndex]){
            popIndex++
            stack.pop()
        } else {
            stack.push(pushed[pushIndex++])
        }
    }

    return result
}

fun main(){
    val pushed = intArrayOf(1,2,3,4,5)
    val popped = intArrayOf(4,5,3,2,1)

    println(validateStackSequences(pushed,popped))
}