public class LargestRectangle {
    /*
        Runtime: 10 ms, faster than 57.62% of Java online submissions for Largest Rectangle in Histogram.
        Memory Usage: 50.9 MB, less than 21.06% of Java online submissions for Largest Rectangle in Histogram.
     */
    static int c_left = 0;
    static int c_right = 0;
    static int c_height = 0;
    static int maxWide = 0;
    public static void findRectangleArea(int startIndex, int [] heights) {
        int left = startIndex;
        int right = startIndex;
        int currentHeight = heights[startIndex];

        // left
        for (int i = startIndex+-1; i >= 0; i--) {
            if(heights[i] < currentHeight){
                break;
            }else{
                left = i;
            }
        }
        // right
        for (int i = startIndex+1; i < heights.length; i++) {
            if(heights[i] < currentHeight){
                break;
            }else{
                right = i;
            }
        }
        if(maxWide <= (right - left + 1) * currentHeight){
            c_left = left;
            c_right = right;
            c_height = currentHeight;
            maxWide = (right - left + 1) * currentHeight;
        }

    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;

        maxWide = 0;
        c_left = heights.length;
        c_right = -1;
        for (int i = 0; i < heights.length; i++) {
            //최대 높이 기준 으로 이미 이전에 파악한 우측 index보다 현재 위치가 값이 같다면 스킵
           if(c_height == heights[i] && c_right >= i){
               continue;
           }
           findRectangleArea(i,heights);
        }

        return maxWide;
    }

    public static void main(String[] args) {
        int [] heights = {4,3};
        System.out.println(largestRectangleArea(heights));
    }
}
