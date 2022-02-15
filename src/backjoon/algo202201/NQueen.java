import java.util.*;

class NQueen {
    static int N;
    static int result;
    static int [] map;

    static boolean isAttack(int row1, int col1, int row2, int col2) {
        return col1 == col2 || (row1 - col1 == row2 - col2) || (row1 + col1 == row2 + col2);
    }

    static void solution(int k) {
        if (k == N + 1) {
            result++;
        } else {
            for (int i = 1; i <= N; i++) {
                boolean isSelect = true;

                for (int j = 1; j <= k - 1; j++) {
                    if(isAttack(k,i, j,map[j])) {
                        isSelect = false;
                        break;
                    }
                }

                if(isSelect) {
                    map[k] = i;
                    solution(k + 1);
                    map[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N + 1];
        result = 0;
        solution(1);
        System.out.println(result);
    }
}
