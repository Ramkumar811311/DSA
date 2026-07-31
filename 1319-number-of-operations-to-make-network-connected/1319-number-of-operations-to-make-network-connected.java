class Solution {
    static class DisjointSet {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        int extraEdges = 0;

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
                extraEdges++;
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

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        for (int connection[] : connections) {
            int u = connection[0];
            int v = connection[1];
            ds.unionBySize(u, v);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == ds.parent.get(i)) {
                count++;
            }
        }

        if (ds.extraEdges >= count - 1) {
            return count - 1;
        }
        return -1;
    }
}