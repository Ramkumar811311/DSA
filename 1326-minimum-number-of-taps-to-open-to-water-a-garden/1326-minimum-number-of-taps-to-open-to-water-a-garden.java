class Solution {
    public int minTaps(int n, int[] ranges) {
        int startEnd[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            startEnd[left] = Math.max(startEnd[left], right);
        }
        int tap = 0;
        int maxEnd = 0;
        int currEnd = 0;
        for (int i = 0; i <= n; i++) {
            if (i > maxEnd) {
                return -1;
            }
            if (i > currEnd) {
                tap++;
                currEnd = maxEnd;
            }
            maxEnd = Math.max(maxEnd, startEnd[i]);
        }
        return tap;
    }
}