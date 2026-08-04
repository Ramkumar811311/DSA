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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = maxRow + stones[i][1] + 1;
            ds.unionBySize(nodeRow, nodeCol);

            map.put(nodeRow, 1);
            map.put(nodeCol, 1);

        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (ds.findUParent(it.getKey()) == it.getKey()) {
                cnt++;
            }
        }
        return n-cnt;
    }
}