class Solution {
    static class DisjointSet {
        ArrayList<Integer> size = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
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
    public long countPairs(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            ds.unionBySize(u,v);
        }
        long ans=0;
        long leftNode=n;
        for(int i=0;i<n; i++){
            if (ds.findUParent(i)==i) {
                long size=ds.size.get(i);
                ans+=size*(leftNode-size);
                leftNode-=size;
            }
        }
        return ans;
    }
}