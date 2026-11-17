class Solution {
    public int partitionString(String s) {
        boolean visited[] = new boolean[26];
        int minPartition = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int ind = ch - 'a';
            if (visited[ind]) {
                minPartition++;
                visited = new boolean[26];
            }
            visited[ind] = true;
        }
        return minPartition;
    }
}