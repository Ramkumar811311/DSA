class Solution {
    static class DisjointSet {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();

        DisjointSet(int V) {
            for (int i = 0; i < V; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findUParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUParent(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUParent(u);
            int ulp_v = findUParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }

            else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet ds = new DisjointSet(m * n);
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int d_row = i + dr[k];
                    int d_col = j + dc[k];

                    if (d_row >= 0 && d_row < m && d_col >= 0 && d_col < n && grid[d_row][d_col] == 1) {
                        int nodeNo = i * n + j;
                        int adjNodeNo = d_row * n + d_col;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }

            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                HashSet<Integer> component = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int d_row = i + dr[k];
                    int d_col = j + dc[k];

                    if (d_row >= 0 && d_row < m && d_col >= 0 && d_col < n && grid[d_row][d_col] == 1) {
                        int adjNodeNo = d_row * n + d_col;
                        component.add(ds.findUParent(adjNodeNo));
                    }
                }
                int sizeTotal = 0;
                for (int element : component) {
                    sizeTotal += ds.size.get(element);
                }
                max = Math.max(sizeTotal + 1, max);

            }
        }
        for (int i = 0; i < m * n; i++) {
            if (ds.findUParent(i) == i) {
                max = Math.max(max, ds.size.get(i));
            }
        }

        return max;
    }
}