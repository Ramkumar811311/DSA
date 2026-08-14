class Solution {
    static class Pair {
        String s;
        int stp;

        Pair(String s, int stp) {
            this.s = s;
            this.stp = stp;
        }
    }

    public static int BFS(ArrayList<ArrayList<Character>> adj, HashSet<String> dead, HashSet<String> visited,
            String target) {
        StringBuilder route = new StringBuilder("0000");
        if (dead.contains(route.toString())) {
            return -1;
        }
        visited.add(route.toString());
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(route.toString(), 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            StringBuilder str = new StringBuilder(p.s);
            int step = p.stp;
            if (str.toString().equals(target)) {
                return step;
            }
            for (int i = 0; i < str.length(); i++) {
                char original = str.charAt(i);
                int index = original - '0';
                for (Character it : adj.get(index)) {
                    str.setCharAt(i, it);
                    if (!visited.contains(str.toString()) && !dead.contains(str.toString())) {
                        visited.add(str.toString());
                        q.add(new Pair(str.toString(), step + 1));
                    }
                }
                str.setCharAt(i, original);
            }
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) {
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                adj.get(i).add((char) (9 + '0'));
                adj.get(i).add((char) (1 + '0'));
            } else if (i == 9) {
                adj.get(i).add((char) (8 + '0'));
                adj.get(i).add((char) (0 + '0'));
            } else {
                adj.get(i).add((char) (i - 1 + '0'));
                adj.get(i).add((char) (i + 1 + '0'));
            }

        }
        HashSet<String> dead = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            dead.add(deadends[i]);
        }
        HashSet<String> visited = new HashSet<>();
        return BFS(adj,dead,visited,target);
    }
}