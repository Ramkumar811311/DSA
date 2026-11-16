class Solution {
    public int minimumRounds(int[] tasks) {
        int minRound = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
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