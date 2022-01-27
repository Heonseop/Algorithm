package backjoon;

import java.util.Scanner;
import java.util.Arrays;

/*
    아이디어: 파라미터 서치(조건과 타겟을 바꾸고, y/n문제로 바꾸자)(주로 최대 혹은 최소값 구하기)
    어떤 거리 만큼 거리를 둘때, 공유기 c개를 설치할 수 있는가? y/n
 */
public class ShareMachine2110 {
    static int N;
    static int C;
    static int[] arr;
    static int result;

    static boolean isInstallShare(int distance) {
        int startIndex = arr[0];
        int shareMachineNum = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - startIndex >= distance) {
                shareMachineNum++;
                startIndex = arr[i];
            }
        }
        return shareMachineNum >= C;
    }

    static void solution() {
        int l = 0;
        int r = 1000000000;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (isInstallShare(mid)) {
                l = mid + 1;
                result = mid;
            } else {
                r = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        solution();
        System.out.println(result);
    }
}
