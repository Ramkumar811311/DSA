class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                ans++;
                i++;
            }
            j++;

        }
        return ans;
    }
}