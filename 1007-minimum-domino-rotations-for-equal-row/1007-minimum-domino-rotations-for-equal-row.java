class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int topFreq[] = new int[7];
        int bottomFreq[] = new int[7];
        int n = tops.length;
        for (int i = 0; i < tops.length; i++) {
            topFreq[tops[i]]++;
            bottomFreq[bottoms[i]]++;
        }
        int maxFreq = 0;
        int number = 0;
        for (int i = 0; i < 7; i++) {
            if (topFreq[i] + bottomFreq[i] > maxFreq) {
                maxFreq = topFreq[i] + bottomFreq[i];
                number = i;
            }
        }
        if (maxFreq < n) {
            return -1;
        }
        int topRotation = 0;
        int bottomRoatation = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] == number && bottoms[i] == number) {
                continue;
            } else if (tops[i] == number && bottoms[i] != number) {
                bottomRoatation++;
            } else if (bottoms[i] == number && tops[i] != number) {
                topRotation++;
            }else{
                return -1;
            }
        }
        int minRotation = Math.min(topRotation, bottomRoatation);
        return minRotation;
    }
}