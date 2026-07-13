class Solution {
    static class Pair {
        int n;
        long d;

        Pair(int n, long d) {
            this.n = n;
            this.d = d;
        }
    }

    public static int findNoOfWayToArriveAtDestination(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int MOD = 1_000_000_007;
        int n = adj.size();
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int ways[] = new int[n];
        ways[0] = 1;
        distance[0] = 0;
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.n;
            long dist = p.d;
            if (dist > distance[node]) {
                continue;
            }

            for (ArrayList<Integer> list : adj.get(node)) {
                int next = list.get(0);
                int wt = list.get(1);

                if (dist + wt < distance[next]) {
                    ways[next] = ways[node];
                    distance[next] = dist + wt;
                    pq.add(new Pair(next, dist + wt));
                } else if (dist + wt == distance[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : roads) {
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];

            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(d);
            adj.get(u).add(temp1);

            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.add(u);
            temp2.add(d);
            adj.get(v).add(temp2);
        }
        return findNoOfWayToArriveAtDestination(adj);
    }
}