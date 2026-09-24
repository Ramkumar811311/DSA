class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
         TreeMap<Integer, Long> map = new TreeMap<>();
        List<List<Long>> ans = new ArrayList<>();

        for (int it[] : segments) {
            int start = it[0];
            int end = it[1];
            int color = it[2];
            map.put(start, map.getOrDefault(start, 0L) + color);
            map.put(end, map.getOrDefault(end, 0L) - color);
        }
        int start = map.firstKey();
        long sum = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            int key = entry.getKey();
            long value = entry.getValue();

            if (start != key && sum > 0) {
                ans.add(List.of((long) start, (long) key, sum));
            }
            sum += value;
            start = key;

        }
        return ans;
    }
}