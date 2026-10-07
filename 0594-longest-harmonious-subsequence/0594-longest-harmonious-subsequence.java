class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        int maxLen = 0;
        for (int element : nums) {
            int len = map.get(element) + map.getOrDefault(element+1, -map.get(element));
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}