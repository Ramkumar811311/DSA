class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < arrays.size(); i++) {
            int len = arrays.get(i).size();
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(len - 1);
            result = Math.max(result, Math.max(Math.abs(max - currMin), Math.abs(min - currMax)));

            min=Math.min(min, currMin);
            max=Math.max(max, currMax);

        }
        return result;
    }
}