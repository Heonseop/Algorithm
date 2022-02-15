package backjoon.algo202202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Like1253 {
    static int N;
    static int[] inputArr;
    static int result;

    static boolean isLikeNums(int targetIdx) {
        int targetNum = inputArr[targetIdx];
        int L = 0;
        int R = N - 1;
        while (L < R) {
            if (L == targetIdx) {
                L++;
                continue;
            }
            if (R == targetIdx) {
                R--;
                continue;
            }
            if (targetNum == inputArr[L] + inputArr[R]) {
                return true;
            } else if (targetNum < inputArr[L] + inputArr[R]) {
                R--;
            } else {
                L++;
            }
        }

        return false;
    }

    static void solution() {
        Arrays.sort(inputArr);
        for (int i = 0; i < N; i++) {
            if (isLikeNums(i)) {
                result++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputArr = new int[N];
        inputArr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        solution();
        System.out.println(result);
    }
}
