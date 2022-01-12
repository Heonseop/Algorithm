package backjoon;

import java.util.Scanner;
/*
   백준 문제 : https://www.acmicpc.net/problem/15652
 */
public class NAndMFour {
    static int N;
    static int M;
    static StringBuilder sb;
    static int[] arr;
    static int[] selectArr;

    public static void solution(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selectArr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            int startIndex = selectArr[k - 1];
            if (startIndex == 0) startIndex = 1;
            for (int index = startIndex; index <= N; index++) {
                selectArr[k] = index;
                solution(k + 1);
                selectArr[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M + 1];
        selectArr = new int[N + 1];
        sb = new StringBuilder();
        solution(1);
        System.out.println(sb.toString());
    }
}
