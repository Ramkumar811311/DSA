class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        int i = 0;
        int j = 1;
        while (i < intervals.length && j < intervals.length) {
            int end1 = intervals[i][1];
            int start2 = intervals[j][0];
            int end2 = intervals[j][1];
            if (start2 < end1) {
                // Overlap → remove interval with larger end
                ans++;

                if (end1 > end2) {
                    i = j;
                    j++;
                } else {
                    j++;
                }

            } else {

                // No overlap → move both forward
                i = j;
                j++;
            }
        }
        return ans;
    }
}