class Solution {
    public int minOperations(int[] nums) {
        int minRound = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int val : freq.values()) {
            if (val < 2) {
                return -1;
            } else if (val % 3 == 0) {
                minRound += val / 3;
            } else {
                minRound += val / 3 + 1;
            }
        }
        return minRound;
    }
}