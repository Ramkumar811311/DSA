class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
		
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		int noOfNonOvlapp = 0;
		int end = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int start = intervals[i][0];
			if (start >= end) {
				noOfNonOvlapp++;
				end = intervals[i][1];
			}
		}
		int minRemove = n - noOfNonOvlapp;
		return minRemove;
    }
}