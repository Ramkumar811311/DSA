class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxLen = 0;
        PriorityQueue<int[]> min_pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> max_pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0]));
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            max_pq.add(new int[] { nums[r], r });
            min_pq.add(new int[] { nums[r], r });

            while (max_pq.peek()[0] - min_pq.peek()[0] > limit) {
                l = Math.min(max_pq.peek()[1], min_pq.peek()[1]) + 1;

                while (max_pq != null && max_pq.peek()[1] < l) {
                    max_pq.poll();
                }

                while (min_pq != null && min_pq.peek()[1] < l) {
                    min_pq.poll();
                }

            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}