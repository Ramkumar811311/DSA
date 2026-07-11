class Solution {
    static class Pair {
        int r;
        int c;
        int distance;

        Pair(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    public static int FindMinEffortUsingDijkstra(int ro, int co, int heights[][]) {
        int m = heights.length;
        int n = heights[0].length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        int dist[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[ro][co] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance);

        pq.add(new Pair(ro, co, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int row = p.r;
            int col = p.c;
            int effort = p.distance;
            if (row == m - 1 && col == n - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = p.r + dr[i];
                int nCol = p.c + dc[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n) {
                    int newEffort = Math.max(
                            Math.abs(heights[row][col] - heights[nRow][nCol]), effort);

                    if (newEffort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = newEffort;
                        pq.add(new Pair(nRow, nCol, newEffort));
                    }
                }
            }
        }
        return -1;
    }

    public int minimumEffortPath(int[][] heights) {
        int minEffort = FindMinEffortUsingDijkstra(0, 0, heights);
        return minEffort;
    }
}