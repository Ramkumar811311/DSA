class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        pq.addAll(map.entrySet());
        while (!pq.isEmpty() && k > 0) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            int key = entry.getKey();
            int val = entry.getValue();
            if (k >= val) {
                map.remove(key);
                k -= val;
            } else {
                break;
            }
        }
        return map.size();
    }
}