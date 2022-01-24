package backjoon;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
public class DrawArrow15970 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result=0;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i=0;i<=N+1;i++){
            lists.add(new ArrayList<>());
        }
        int index;
        int color;
        for(int i=0;i<N;i++){
            index = sc.nextInt();
            color = sc.nextInt();
            lists.get(color).add(index);
        }

        for(ArrayList<Integer> list : lists){
            if(list.size() == 0){
                continue;
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                if(i==0){
                    result += Math.abs(list.get(i)-list.get(i+1));
                }else if(i==list.size()-1){
                    result += Math.abs(list.get(i)-list.get(i-1));
                }else{
                    result += Math.min(Math.abs(list.get(i)-list.get(i-1)),Math.abs(list.get(i)-list.get(i+1)));
                }
            }
        }
        System.out.println(result);
    }
}
