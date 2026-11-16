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
            }
            int remainder = val % 3;
            int qoutient = val / 3;
            if (remainder == 0 || remainder == 1) {
                minRound += (remainder + qoutient);
            } else {
                minRound += (remainder + qoutient) - 1;
            }
        }
        return minRound;
    }
}