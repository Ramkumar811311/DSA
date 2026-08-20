class Solution {
     static class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void BFS(int ro, int co, int land[][], int visited[][], List<int[]> ans) {
        int r1 = ro;
        int c1 = co;
        int r2 = ro;
        int c2 = co;
        int m = land.length;
        int n = land[0].length;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        Queue<Pair> q = new LinkedList<>();
        visited[ro][co] = 1;
        q.add(new Pair(ro, co));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            r2 = Math.max(r2, row);
            c2 = Math.max(c2, col);
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + row;
                int nc = dc[i] + col;
                if (nr >= 0 && nr <= m - 1 && nc >= 0 && nc <= n - 1 && land[nr][nc] == 1 && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    q.add(new Pair(nr, nc));
                }
            }

        }
        ans.add(new int[] { r1, c1, r2, c2 });

    }
    public int[][] findFarmland(int[][] land) {
         int m = land.length;
        int n = land[0].length;
        List<int[]> ans = new ArrayList<>();
        int visited[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    BFS(i, j, land, visited, ans);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}