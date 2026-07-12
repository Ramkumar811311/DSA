class Solution {
    static class Pair {
        int s;
        int n;
        int c;

        Pair(int s, int n, int c) {
            this.s = s;
            this.n = n;
            this.c = c;
        }
    }

    public static int findMinimumCost(int src, int dst, int k, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        int distance[] = new int[adj.size()];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, src, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.n;
            int cost = p.c;
            int stop = p.s;

            if (stop > k)
                continue;
            for (ArrayList<Integer> list : adj.get(node)) {
                int element = list.get(0);
                int wt = list.get(1);

                if (cost + wt < distance[element]) {
                    distance[element] = cost + wt;
                    q.add(new Pair(stop + 1, element, cost + wt));
                }
            }
        }

        return distance[dst];

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : flights) {
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            temp.add(d);
            adj.get(u).add(temp);
        }

        int ans = findMinimumCost(src, dst, k, adj);
        return ans==Integer.MAX_VALUE ? -1: ans;
    }
}