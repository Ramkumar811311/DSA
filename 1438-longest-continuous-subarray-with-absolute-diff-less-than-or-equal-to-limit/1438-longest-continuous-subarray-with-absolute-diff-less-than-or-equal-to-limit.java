class Solution {
    public static void findMinIndex(Deque<Integer> dq, int nums[], int ind) {
        while (!dq.isEmpty() && nums[dq.peekLast()] > nums[ind]) {
            dq.removeLast();
        }
        dq.addLast(ind);

    }

    public static void findMaxIndex(Deque<Integer> dq, int nums[], int ind) {
        while (!dq.isEmpty() && nums[dq.peekLast()] < nums[ind]) {
            dq.removeLast();
        }
        dq.addLast(ind);

    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min_dq = new ArrayDeque<>();
        Deque<Integer> max_dq = new ArrayDeque<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            findMinIndex(min_dq, nums, r);
            findMaxIndex(max_dq, nums, r);

            while (nums[max_dq.peekFirst()] - nums[min_dq.peekFirst()] > limit) {
                l++;
                while (!min_dq.isEmpty() && min_dq.peekFirst() < l) {
                    min_dq.removeFirst();
                }
                while (!max_dq.isEmpty() && max_dq.peekFirst() < l) {
                    max_dq.removeFirst();
                }

            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}