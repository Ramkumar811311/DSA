class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> b - a);
        for (int i = 0; i < n - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            int diff = heights[i + 1] - heights[i];
            if (diff <= bricks) {
                bricks -= diff;
                pq.add(diff);
            } else if (ladders > 0) {
                if (!pq.isEmpty() && pq.peek() > diff) {
                    int maxBricksInPast = pq.poll();
                    ladders--;
                    bricks += maxBricksInPast;
                    pq.add(diff);
                    bricks-=diff;
                } else {
                    ladders--;
                }
            } else {
                return i;
            }

        }
        return n - 1;
    }
}