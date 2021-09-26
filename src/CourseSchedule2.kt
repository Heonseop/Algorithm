import java.util.*

//위상정렬 문제
/*
    위상정렬(Topology Sort): 순서가 정해져 있는 작업을 차례로 수행할 때, 그 순서를 결정해 주기 위해 사용하는 알고리즘

    위상정렬 복잡도: O(V+E)
    210. Course Schedule II
    Runtime: 200 ms, faster than 100.00% of Kotlin online submissions for Course Schedule II.
    Memory Usage: 41.3 MB, less than 90.29% of Kotlin online submissions for Course Schedule II.
 */
fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val adjacencyList: MutableList<MutableList<Int>> = ArrayList()

    for (i in 0 until numCourses) {
        adjacencyList.add(ArrayList())
    }

    val queue: Queue<Int> = LinkedList()

    val inDegree = IntArray(numCourses)

    for (index in prerequisites.indices) {
        val prev = prerequisites[index][1]
        val next = prerequisites[index][0]
        adjacencyList[prev].add(next)
        inDegree[next]++
    }

    //정점을 찾아서 넣는다.
    for (i in 0 until numCourses) {
        if (inDegree[i] == 0) {
            queue.offer(i)
        }
    }

    var idx = 0
    val ans = IntArray(numCourses)

    while (!queue.isEmpty()) {
        val top: Int = queue.poll()
        ans[idx] = top

        //numCourses와 비교하기 위해 값을 정의합니다.
        idx++
        for (i in adjacencyList[top]) {
            //간선을 제거, 정점 빼고
            inDegree[i]--
            if (inDegree[i] == 0) {
                //그 다음 정점을 추가합니다.
                queue.offer(i)
            }
        }
    }

    //결과가 조건에 부합하지 못할 경우 빈값을 보낸다.
    return if (idx != numCourses) {
        intArrayOf()
    } else ans
}

fun main() {
    val numCourses = 1
    val prerequisites = arrayOf(
        intArrayOf(1,0),
        intArrayOf(2,0),
        intArrayOf(3,1),
        intArrayOf(3,2)
    )
    print(findOrder(numCourses, prerequisites).contentToString())
}