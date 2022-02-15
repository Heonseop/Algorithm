import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class CardInfo implements Comparable<CardInfo> {
    long num;
    int cnt;

    CardInfo(long num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(CardInfo o) {
        if (this.cnt != o.cnt) return o.cnt - this.cnt;

        return Long.compare(this.num, o.num);
    }
}

public class Card11652 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        ArrayList<CardInfo> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long currentNm = sc.nextLong();
            if (map.containsKey(currentNm)) {
                map.put(currentNm, map.get(currentNm) + 1);
            } else {
                map.put(currentNm, 1);
            }
        }
        ArrayList<Long> keys = new ArrayList<>(map.keySet());
        ArrayList<Integer> values = new ArrayList<>(map.values());

        for (int i = 0; i < map.size(); i++) {
            arr.add(new CardInfo(keys.get(i), values.get(i)));
        }
        Collections.sort(arr);
        System.out.println(arr.get(0).num);
    }
}
