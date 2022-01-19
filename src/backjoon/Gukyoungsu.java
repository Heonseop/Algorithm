package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gukyoungsu {
    static int N;
    static class ExamInfo implements Comparable<ExamInfo>{
        String name;
        int korean;
        int english;
        int math;
        ExamInfo(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(ExamInfo o) {
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
            if(this.korean != o.korean){
                return o.korean - this.korean;
            }
            if(this.english != o.english){
                return this.english - o.english;
            }
            if(this.math != o.math){
                return o.math - this.math;
            }
            return this.name.compareTo(o.name);
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ExamInfo [] exams = new ExamInfo[N];
        for(int i=0;i<N;i++){
            String [] input = br.readLine().split(" ");
            exams[i] = new ExamInfo(
                    input[0],
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2]),
                    Integer.parseInt(input[3])
            );
        }
        Arrays.sort(exams);
        for(ExamInfo ei : exams){
            System.out.println(ei.name);
        }
    }
}
