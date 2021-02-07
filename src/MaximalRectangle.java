public class MaximalRectangle {
    /*
    *   Runtime: 18 ms, faster than 13.30% of Java online submissions for Maximal Rectangle.
        Memory Usage: 42.7 MB, less than 30.51% of Java online submissions for Maximal Rectangle.
        공간복잡도 O(n^4)
     */

    public static int findRectangle(int x, int y, char[][] matrix) {
        int result = 0;
        int maxHeight = matrix.length;
        int maxWidth = matrix[0].length;

        for (int i = x; i < maxHeight; i++) {
            for (int j = y; j < maxWidth; j++) {
                if (matrix[i][j] == '0') {
                    maxWidth = j;
                    break;
                }
                int tempSize = (i - x + 1) * (j - y + 1);
                result = Math.max(result, tempSize);
            }
        }

        return result;
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0;

        int maxWide = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    maxWide = Math.max(maxWide, findRectangle(i, j, matrix));
                }
            }
        }

        return maxWide;
    }

    public static void main(String[] args) {
        char[][] arr = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(arr));
    }
}
