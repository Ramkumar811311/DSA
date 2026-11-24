class Solution {
    public int leastInterval(char[] tasks, int n) {
        int frq[] = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            frq[tasks[i] - 'A']++;
        }
        Arrays.sort(frq);
        int gaddhe = frq[25] - 1;
        int idleSpot = gaddhe * n;
        for (int i = 24; i >= 0; i--) {
            if (frq[i] == 0) {
                break;
            }
            idleSpot -= Math.min(gaddhe, frq[i]);
        }
        if (idleSpot > 0) {
            return tasks.length + idleSpot;
        }
        return tasks.length;
    }
}