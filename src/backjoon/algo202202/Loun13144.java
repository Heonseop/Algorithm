package backjoon.algo202202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loun13144 {
    static int N;
    static int[] inputArr;

    static long solution() {
        int R = 0;
        long result = 0;
        int[] countArr = new int[100001];
        for (int L = 0; L < N; L++) {
            while (R < N) {
                if (countArr[inputArr[R]] == 0) {
                    countArr[inputArr[R]]++;
                    R++;
                } else {
                    break;
                }
            }
            result += R - L;
            countArr[inputArr[L]]--;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        inputArr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(input[i]);
        }
        System.out.println(solution());
        br.close();
    }
}
