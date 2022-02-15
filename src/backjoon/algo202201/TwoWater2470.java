import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoWater2470 {
    static int lower_bound(int[] arr, int l, int r, int x) {
        int result = r + 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= x) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int result = Integer.MAX_VALUE;
        int w1 = 0, w2 = 0;
        String[] inputStr = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(inputStr[i - 1]);
        }
        Arrays.sort(arr, 1, N + 1);
        for (int left = 1; left <= N - 1; left++) {
            int canNum = lower_bound(arr, left + 1, N, -arr[left]);

            if (left < canNum - 1 && Math.abs(arr[canNum - 1] + arr[left]) < result) {
                result = Math.abs(arr[canNum - 1] + arr[left]);
                w1 = arr[left];
                w2 = arr[canNum - 1];
            }

            if (canNum <= N && Math.abs(arr[canNum] + arr[left]) < result) {
                result = Math.abs(arr[canNum] + arr[left]);
                w1 = arr[left];
                w2 = arr[canNum];
            }
        }
        System.out.println(w1 + " " + w2);
    }
}
