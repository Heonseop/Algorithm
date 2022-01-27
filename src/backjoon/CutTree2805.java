package backjoon;

import java.util.Scanner;

public class CutTree2805 {
    /*
        사용 알고리즘: Parametric Search: 정답을 매개 변수로 만들고 y/s문제(결정 문제)로 바꿔보기
        아이디어: 어떤 높이로 잘랐을 때, 원하는 길이의 나무를 얻을 수 있는가? y or n
     */
    static int N;
    static int wantLength;
    static int[] arr;
    static long result = 0;

    static boolean checkSum(long h) {
        long sum = 0;
        for (int i = 1; i < N + 1; i++) {
            if (arr[i] > h) {
                sum += arr[i] - h;
            }
        }
        return sum >= wantLength;
    }

    static void solution() {
        long l = 1;
        long r = 2000000000;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (checkSum(mid)) {
                l = mid + 1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        result = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        wantLength = sc.nextInt();
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        solution();
        System.out.println(result);
    }
}
