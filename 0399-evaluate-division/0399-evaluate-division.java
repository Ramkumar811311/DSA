class Solution {
    static class Pair {
        String s;
        double val;

        Pair(String s, double val) {
            this.s = s;
            this.val = val;
        }

    }

    public static double BFS(String u, String v, HashMap<String, ArrayList<Pair>> map) {
        if (!map.containsKey(u) || !map.containsKey(v)) {
            return -1.0;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(u, 1.0));
        visited.add(u);

        while (!q.isEmpty()) {

            String str = q.peek().s;
            double value = q.peek().val;
            q.poll();
            if (str.equals(v)) {
                return value;
            }
            for (Pair p : map.get(str)) {
                if (!visited.contains(p.s)) {
                    visited.add(p.s);
                    q.add(new Pair(p.s, value * p.val));
                }
            }

        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double ans[] = new double[queries.size()];

        HashMap<String, ArrayList<Pair>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {

            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<Pair>());
            }
            map.get(u).add(new Pair(v, values[i]));
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<Pair>());
            }
            map.get(v).add(new Pair(u, 1 / values[i]));
        }

        for (int i = 0; i < queries.size(); i++) {
            ans[i] = BFS(queries.get(i).get(0), queries.get(i).get(1), map);

        }
        return ans;
    }
}