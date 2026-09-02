class Solution {
    static class State {
        int r;
        int c;
        int e;
        int m;
        int mov;

        State(int r, int c, int e, int m, int mov) {
            this.r = r;
            this.c = c;
            this.e = e;
            this.m = m;
            this.mov = mov;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterIndex = new int[m][n];
        int L_ind = 0;
        int totalL = 0;
        int s_row = 0;
        int s_col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'L') {
                    litterIndex[i][j] = L_ind;
                    L_ind++;
                    totalL++;
                } else if (ch == 'S') {
                    s_row = i;
                    s_col = j;
                }
            }
        }
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        boolean visited[][][][] = new boolean[m][n][energy + 1][1 << totalL];
        Queue<State> q = new LinkedList<>();
        q.add(new State(s_row, s_col, energy, 0, 0));
        visited[s_row][s_col][energy][0] = true;
        while (!q.isEmpty()) {
            State s = q.poll();
            int row = s.r;
            int col = s.c;
            int mask = s.m;
            int move = s.mov;
            int curr_energy = s.e;
            if (mask == (1 << totalL) - 1) {
                return move;
            }
            if (curr_energy == 0 && classroom[row].charAt(col) != 'R') {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n || classroom[nRow].charAt(nCol) == 'X') {
                    continue;
                }
                int new_energy = curr_energy - 1;
                if (classroom[nRow].charAt(nCol) == 'R') {
                    new_energy = energy;
                }
                int newMask = mask;

                if (classroom[nRow].charAt(nCol) == 'L') {
                    int index = litterIndex[nRow][nCol];
                    newMask = mask | (1 << index);
                }

                if (visited[nRow][nCol][new_energy][newMask] == false) {
                    q.add(new State(nRow, nCol, new_energy, newMask, move + 1));
                    visited[nRow][nCol][new_energy][newMask] = true;
                }

            }

        }
        return -1;
    }
}