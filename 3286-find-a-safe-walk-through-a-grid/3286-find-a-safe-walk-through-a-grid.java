class Solution {
    public static class Pair {
        int r;
        int c;
        int h;

        Pair(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] maxHealth = new int[m][n];

        for (int[] row : maxHealth) {
            Arrays.fill(row, -1);
        }
        Queue<Pair> q = new LinkedList<>();
        if (grid.get(0).get(0) == 1) {
            health--;
        }
        if (health <= 0) {
            return false;
        }

        q.add(new Pair(0, 0, health));
        maxHealth[0][0] =health;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.r;
            int col = p.c;
            int currHealth = p.h;
            if (row == m - 1 && col == n - 1 && currHealth >= 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nRow = dr[i] + row;
                int nCol = dc[i] + col;
                int newHealth = currHealth;

                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n) {
                    continue;
                }
                if (grid.get(nRow).get(nCol) == 1) {
                    newHealth--;
                }
                if (newHealth <= 0) {
                    continue;
                }
                if (newHealth <= maxHealth[nRow][nCol]) {
                    continue;
                }
                maxHealth[nRow][nCol] = newHealth;
                q.add(new Pair(nRow, nCol, newHealth));
            }
        }

        return false;

    }
}