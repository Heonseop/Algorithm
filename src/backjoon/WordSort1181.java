package backjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class WordSort1181 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(sc.nextLine());
        }

        ArrayList<String> lists = new ArrayList<>(set);
        lists.sort((o1, o2) -> {
            if (o1.length() != o2.length()) return o1.length() - o2.length();
            return o1.compareTo(o2);
        });
        for(String str:lists){
            System.out.println(str);
        }
    }
}
