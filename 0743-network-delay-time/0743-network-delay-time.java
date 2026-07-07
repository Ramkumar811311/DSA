class Solution {
     static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void DijkstraAlgo(int src, ArrayList<ArrayList<ArrayList<Integer>>> adj, int dist[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance);

        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (p.distance > dist[p.node]) {
                continue;
            }

            for (ArrayList<Integer> next : adj.get(p.node)) {
                int wt = next.get(1);
                int element = next.get(0);
                if (p.distance + wt < dist[element]) {
                    dist[element] = p.distance + wt;
                    pq.add(new Pair(element, p.distance + wt));
                }
            }
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];

            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(d);

            adj.get(u).add(temp1);
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;
        DijkstraAlgo(k, adj, dist);
        int minTime = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            minTime = Math.max(minTime, dist[i]);
        }
        return minTime;
    }
}