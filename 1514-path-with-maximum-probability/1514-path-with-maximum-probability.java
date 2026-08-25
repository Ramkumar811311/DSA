class Solution {
    static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        double probability[] = new double[n];
        Arrays.fill(probability, 0.0);
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            double p = succProb[i];

            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }
        probability[start] = 1.0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.prob, a.prob));

        pq.add(new Pair(start, 1));
        while (!pq.isEmpty()) {

            Pair p = pq.poll();
            if (p.node == end) {
                return p.prob;
            }
            for (Pair li : adj.get(p.node)) {
                double newProb = p.prob * li.prob;
                if (newProb > probability[li.node]) {
                    probability[li.node] = newProb;
                    pq.add(new Pair(li.node, newProb));
                }
            }
        }
        return 0.00001;
    }
}