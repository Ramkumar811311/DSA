class Solution {
    static class Pair {
        int r;
        int c;
        int d;

        Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static int DijkstraAlgo(int ro, int co, int mat[][], int dist[][]) {
        int m = mat.length;
        int n = mat[0].length;

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.d - b.d);

        pq.add(new Pair(ro, co, 1));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (p.d > dist[p.r][p.c]) {
                continue;
            }
            for (int i = 0; i < 8; i++) {
                int nRow = p.r + dr[i];
                int nCol = p.c + dc[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && mat[nRow][nCol] == 0) {
                    if (nRow == m - 1 && nCol == n - 1) {
                        return p.d + 1;
                    }
                    if (p.d + 1 < dist[nRow][nCol]) {
                        dist[nRow][nCol] = p.d + 1;
                        pq.add(new Pair(nRow, nCol, p.d + 1));
                    }
                }
            }
        }
        return -1;

    }

    public int shortestPathBinaryMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (mat[0][0] == 1 || mat[m - 1][n - 1] == 1) {
            return -1;
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        int dist[][] = new int[m][n];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 1;

        int minDist = DijkstraAlgo(0, 0, mat, dist);
        return minDist;
    }
}