import java.util.Scanner;

class NAndMThree {
    //백준 15651: https://www.acmicpc.net/problem/15651
    static int N,M;
    static int [] result;
    static StringBuilder resultStr;

    public static void solution(int k){
        if (k == M + 1){

            for(int i=1; i<=M;i++){
                resultStr.append(result[i]).append(" ");
            }
            resultStr.append("\n");
        } else {
            for (int i = 1; i<=N; i++){
                result[k] = i;
                solution(k+1);
                result[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int [M + 1];
        resultStr = new StringBuilder();
        solution(1);
        System.out.println(resultStr.toString());
    }
}
