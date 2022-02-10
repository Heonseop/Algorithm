package backjoon.`202201`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

internal object GukyoungsuKt {
    var N = 0

    internal class ExamInfo(var name: String, var korean: Int, var english: Int, var math: Int) :
        Comparable<ExamInfo> {

        override fun compareTo(other: ExamInfo): Int {
            //version 1
            /*if (this.korean > o.korean){
            return -1;
        }else if(this.korean == o.korean){
            if(this.english < o.english){
                return -1;
            } else if(this.english == o.english){
                if(this.math > o.math){
                    return -1;
                } else if(this.math == o.math){
                    return Integer.compare(this.name.compareTo(o.name), 0);
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        } else{
            return 1;
        }*/
            //version 2
            if (korean != other.korean) {
                return other.korean - korean
            }
            if (english != other.english) {
                return english - other.english
            }
            return if (math != other.math) {
                other.math - math
            } else name.compareTo(other.name)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

        N = readLine().toInt()
        val exams = arrayOfNulls<ExamInfo>(N)
        for (i in 0 until N) {
            val input = readLine().split(" ".toRegex()).toTypedArray()
            exams[i] = ExamInfo(
                input[0], input[1].toInt(), input[2].toInt(), input[3].toInt()
            )
        }
        Arrays.sort(exams)
        for (ei in exams) {
            println(ei!!.name)
        }
    }
}