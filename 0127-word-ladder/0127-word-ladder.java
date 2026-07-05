class Solution {
    static class Pair {
        String s;
        int len;

        Pair(String s, int len) {
            this.s = s;
            this.len = len;
        }
    }

    public static int BFS(HashSet<String> set, String s, String e) {
        Queue<Pair> q = new LinkedList<>();
        set.remove(s);
        q.add(new Pair(s, 1));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < p.s.length(); i++) {
                StringBuilder sb = new StringBuilder(p.s);
                for (int j = 0; j < 26; j++) {
                    char ch = (char) ('a' + j);
                    if (ch == p.s.charAt(i))
                        continue;
                    sb.setCharAt(i, ch);
                    if (sb.toString().equals(e)) {
                        return p.len + 1;
                    }
                    String next = sb.toString();
                    if (set.contains(next)) {
                        set.remove(next);
                        q.add(new Pair(next, p.len + 1));
                    }
                }
            }
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String str : wordList) {
            set.add(str);
        }
        if (!set.contains(endWord)) {
            return 0;
        }
        int ans = BFS(set, beginWord, endWord);
        return ans;
    }
}