class Solution {
    public int maxArea(int[] height) {
        int maxWaterArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int currentArea = (end - start) * Math.min(height[start], height[end]);
            maxWaterArea = Math.max(maxWaterArea, currentArea);
            if (height[start] < height[end]) {
                start++;
            } else if (height[end] < height[start]) {
                end--;
            } else {
                start++;
                end--;
            }
        }
        return maxWaterArea;
    }
}