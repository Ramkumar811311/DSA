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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DisjointSet ds = new DisjointSet(accounts.size());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    ds.unionBySize(map.get(email), i);
                }
            }
        }

        List<List<String>> mergeAccount = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            mergeAccount.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int parent = ds.findUParent(entry.getValue());

            mergeAccount.get(parent).add(email);

        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < mergeAccount.size(); i++) {
            if (mergeAccount.get(i).isEmpty()) {
                continue;
            }
            Collections.sort(mergeAccount.get(i));
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            list.addAll(mergeAccount.get(i));
            ans.add(list);
        }
        return ans;
    }
}