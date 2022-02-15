import java.util.Scanner;

class SumOfPartialSequences {
    static int N;
    static int S;
    static int result;
    static int[] arr;

    static void solution(int k, int currentNum) {
        if (k == N) {
            if (currentNum == S) {
                result++;
            }
        } else {
            //현재 값을 선택한 경우
            solution(k + 1, currentNum + arr[k]);

            //현재 값을 선택하지 않은 경우
            solution(k + 1, currentNum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        result = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        solution(0, 0);
        if (S == 0) {
            result--;
        }
        System.out.println(result);
    }
}
