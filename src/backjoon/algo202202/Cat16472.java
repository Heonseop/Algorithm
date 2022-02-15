package backjoon.algo202202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Cat16472 {
    static int N;
    static char[] inputArr;
    static int result = 0;
    static HashMap<Character, Integer> map = new HashMap<>();

    static void solution() {
        map.put(inputArr[0], 1);
        for (int L = 0, R = 0; L < inputArr.length; L++) {
            while (R < inputArr.length - 1) {
                if (!map.containsKey(inputArr[R + 1]) && map.size() == N) {
                    break;
                }

                if (map.containsKey(inputArr[R + 1])) {
                    map.put(inputArr[R + 1], map.get(inputArr[R + 1]) + 1);
                } else {
                    map.put(inputArr[R + 1], 1);
                }
                R++;
            }
            result = Math.max(result, R - L + 1);
            if (map.containsKey(inputArr[L])) {
                if (map.get(inputArr[L]) == 1) {
                    map.remove(inputArr[L]);
                } else {
                    map.put(inputArr[L], map.get(inputArr[L]) - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputArr = br.readLine().toCharArray();
        solution();
        System.out.println(result);
    }
}
