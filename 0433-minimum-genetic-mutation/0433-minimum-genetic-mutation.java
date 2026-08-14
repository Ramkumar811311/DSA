class Solution {
    static class Pair {
        String s;
        int stp;

        Pair(String s, int stp) {
            this.s = s;
            this.stp = stp;
        }
    }

    public static int BFS(String startGene, String endGene, HashSet<String> set) {
        if (set.contains(startGene)) {
            set.remove(startGene);
        }
        String choices = "ACGT";

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startGene, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            StringBuilder sb = new StringBuilder(p.s);
            int step = p.stp;
            if (sb.toString().equals(endGene)) {
                return step;
            }

            for (int i = 0; i < sb.length(); i++) {
                char original = sb.charAt(i);
                for (int j = 0; j < choices.length(); j++) {
                    if (original == choices.charAt(j)) {
                        continue;
                    }
                    sb.setCharAt(i, choices.charAt(j));
                    if (set.contains(sb.toString())) {
                        set.remove(sb.toString());
                        q.add(new Pair(sb.toString(), step + 1));
                    }

                }
                sb.setCharAt(i, original);
            }
        }
        return -1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }
        if (!set.contains(endGene)) {
            return -1;
        }
        return BFS(startGene, endGene, set);
    }
}