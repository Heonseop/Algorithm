import java.util.Scanner;

public class NAndMOne {
    static int N;
    static int M;
    static int[] arr;
    static int[] usedArr;
    static StringBuilder sb;

    /*
    백준 알고리즘: 15649
     */
    static void solution(int k) {
        if (k == M + 1) {
            for(int i =1;i<=M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            //index 값과 실제 출력값 맞추기 위해 index 0은 사용 하지 않는다.
            for (int i = 1; i <= N; i++) {
                if (usedArr[i] == 1){
                    continue;
                }
                arr[k] = i;
                usedArr[i] = 1;

                solution(k + 1);

                arr[k] = 0;
                usedArr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M + 1];
        usedArr = new int [N + 1];
        sb = new StringBuilder();
        solution(1);
        System.out.println(sb.toString());
    }
}
