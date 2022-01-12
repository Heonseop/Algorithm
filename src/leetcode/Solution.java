package leetcode;

public class Solution {
    /*
        leetcode 문제: trapping-rain-water
        풀이 방법 의도: 우선 해당 맵에서 최대 높이를 기준점으로 좌와 우의 기준점을 잡아 고이는 물의 높이를 찾는다.

        Runtime: 1 ms, faster than 83.85% of Java online submissions for Trapping Rain Water.
        Memory Usage: 38.8 MB, less than 27.43% of Java online submissions for Trapping Rain Water.
        시간 복잡도: O(3n), Java가 아닐경우 더 줄일 수 있을것 같다.
     */

    public static int trap(int[] height) {
        //넓이가 2일경우 물이 고일 공간이 없음으로 0으로 return;
        if (height.length < 2) {
            return 0;
        }

        int result = 0;
        int maxHeightIndex = 0;
        int pivotIndex = height[0];

        //최대 높이값을 구하는 for문, Java의 경우 Collection max가 없으므로 직접 구현
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }

        //기준점 왼쪽 범위
        for (int i = 1; i < maxHeightIndex; i++) {
            //높이가 같으면 물이 고이지 않으므로 왼쪽 기준점을 변경하고 진행
            if (height[i] >= pivotIndex) {
                pivotIndex = height[i];
            } else {
                result += pivotIndex - height[i];
            }
        }

        //기준점 오른쪽 범위
        pivotIndex = height[height.length - 1];
        for (int i = height.length - 2; i > maxHeightIndex; i--) {
            //높이가 같으면 물이 고이지 않으므로 오른쪽 기준점을 변경하고 진행
            if (height[i] >= pivotIndex) {
                pivotIndex = height[i];
            } else {
                result += pivotIndex - height[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
