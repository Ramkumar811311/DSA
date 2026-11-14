class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int maxTime = neededTime[0];
        for (int i = 1; i < colors.length(); i++) {
            char curCol = colors.charAt(i);
            char prevCol = colors.charAt(i - 1);
            if (curCol == prevCol) {
                totalTime += Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {

                maxTime = neededTime[i];
            }
        }
        return totalTime;
    }
}