package backjoon;

import java.util.Scanner;
import java.util.Arrays;
public class Eat7795 {
    static int N;
    static int [] bArr;
    static int lowerBound(int [] A, int L, int R, int X){
        int result = L - 1;
        while(L<=R){
            int mid = (L+R)/2;
            if(A[mid]<X){
                result = mid;
                L = mid + 1;
            }else if(A[mid]>=X){
                R = mid - 1;
            }
        }
        return result;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=0;i<N;i++){
            int result = 0;
            int aRange = sc.nextInt();
            int bRange = sc.nextInt();
            int [] aArr = new int [aRange+1];
            bArr = new int [bRange+1];

            for(int j=1;j<=aRange;j++){
                aArr[j] = sc.nextInt();
            }

            for(int j=1;j<=bRange;j++){
                bArr[j] = sc.nextInt();
            }

            Arrays.sort(bArr,1,bRange+1);

            for(int j=1;j<=aRange;j++){
                result += lowerBound(bArr,1,bRange,aArr[j]);
            }
            System.out.println(result);
        }
    }
}
