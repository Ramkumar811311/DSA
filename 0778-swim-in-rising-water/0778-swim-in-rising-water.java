class Solution {
    static class Pair {
        int r;
        int c;
        int t;

        Pair(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public static int Dijkstra(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int time[][] = new int[m][n];
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        for (int i = 0; i < m; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.t - b.t);

        pq.add(new Pair(0, 0, grid[0][0]));
        time[0][0]=0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int row = p.r;
            int col = p.c;
            int tm = p.t;
            if (row == m - 1 && col == n - 1) {
                return tm;
            }

            for (int i = 0; i < 4; i++) {
                int nR = dr[i] + row;
                int nC = dc[i] + col;
                if (nR < 0 || nR >= m || nC < 0 || nC >= n) {
                    continue;
                }
                int newTime = Math.max(grid[nR][nC], tm);
                if (newTime < time[nR][nC]) {
                    time[nR][nC] = newTime;
                    pq.add(new Pair(nR, nC, newTime));
                }
            }
        }
        return -1;
    }

    public int swimInWater(int[][] grid) {
        return Dijkstra(grid);
    }
}