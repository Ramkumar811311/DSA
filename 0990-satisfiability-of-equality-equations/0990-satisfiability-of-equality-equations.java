class Solution {
     static class DisjointSet {
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                rank.add(0);
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

        public void UnionByRank(int u, int v) {
            int ulp_u = findUParent(u);
            int ulp_v = findUParent(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

    }
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet(26);

        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';
            if (s.charAt(1) == '=') {
                ds.UnionByRank(u, v);
            }
        }
        for (int i = 0; i < equations.length; i++) {
            String s = equations[i];
            int u = s.charAt(0) - 'a';
            int v = s.charAt(3) - 'a';
            if (s.charAt(1) == '!') {
                if (ds.findUParent(u) == ds.findUParent(v)) {
                    return false;
                }
            }
        }
        return true;
    }
}