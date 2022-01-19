package backjoon;

import java.util.Scanner;
import java.util.Arrays;
class Point implements Comparable<Point>{
    int num;
    int index;
    Point(int n, int index){
        this.num = n;
        this.index = index;
    }
    @Override
    public int compareTo(Point o){
        if(this.num != o.num) return this.num - o.num;
        if(this.index != o.index) return this.index - o.index;
        return 0;
    }
}
public class LineUp1015 {
    static int N;
    static Point [] arr;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new Point[N];
        int [] result = new int [N];
        for(int i=0;i<N;i++){
            arr[i] = new Point(sc.nextInt(),i);
        }
        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            result[arr[i].index] = i;
        }

        for(int num:result){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
