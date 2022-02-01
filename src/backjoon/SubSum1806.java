package backjoon;

import java.util.Scanner;

public class SubSum1806 {
    static int N;
    static int S;
    static int[] arr;
    static int result;

    static void solution() {
        int r = 0;
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum -= arr[i - 1];
            while (r + 1 <= N && sum < S) {
                r++;
                sum += arr[r];
            }
            if (sum >= S) {
                result = Math.min(result, r - i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N + 1];
        result = N + 1;
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        solution();
        if (result == N + 1) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
