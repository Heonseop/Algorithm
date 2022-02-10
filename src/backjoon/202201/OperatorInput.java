/*
https://www.acmicpc.net/problem/14888
 */
import java.util.Scanner;
public class OperatorInput {
    static int N, maxNum, minNum;
    static int [] inputArr;
    static int [] operatorArr;
    static int [] selectedOperatorArr;
    public static int calculate(int a, int b, int type){
        switch (type){
            case 1:
                return a+b;
            case 2:
                return a-b;
            case 3:
                return a*b;
            case 4:
                return a/b;
        }
        return -1;
    }
    public static void solution(int k){
        if(k==N){
            int currentNum = inputArr[1];
            for(int i = 1; i<=N-1; i++){
                currentNum = calculate(currentNum,inputArr[i+1], selectedOperatorArr[i]);
            }
            maxNum = Math.max(maxNum,currentNum);
            minNum = Math.min(minNum,currentNum);
        } else {
            for (int index = 1; index <=4; index ++){
                if(operatorArr[index]>=1){
                    operatorArr[index]--;
                    selectedOperatorArr[k] = index;
                    solution(k+1);
                    operatorArr[index]++;
                    selectedOperatorArr[k] = 0;
                }
            }
        }
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        maxNum = Integer.MIN_VALUE;
        minNum = Integer.MAX_VALUE;

        inputArr = new int[N+1];
        selectedOperatorArr = new int[N];
        operatorArr = new int [5];
        for (int i = 1; i<=N; i++){
            inputArr[i] = sc.nextInt();
        }

        for (int i = 1; i<=4; i++){
            operatorArr[i] = sc.nextInt();
        }
        solution(1);
        System.out.println(maxNum);
        System.out.println(minNum);
    }
}
