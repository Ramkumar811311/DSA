class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        int sum = 0;
        int ans = 0;
        int num = 1;
        while (num <= n) {
            if (set.contains(num)) {
                num++;
            } else {
                if (sum + num > maxSum) {
                    break;
                }
                ans++;
                sum += num;
                num++;
            }

        }

        return ans;
    }
}