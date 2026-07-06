class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][1]<=end) {
                len--;
            } else {
                end = intervals[i][1];
            }
        }
        return len;
    }
}