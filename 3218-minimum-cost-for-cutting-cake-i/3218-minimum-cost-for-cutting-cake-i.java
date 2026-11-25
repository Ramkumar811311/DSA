class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int minCost = 0;
        int noOfHozCut = 1;
        int noOfVerCut = 1;
        int i = verticalCut.length - 1;
        int j = horizontalCut.length - 1;

        while (i >= 0 && j >= 0) {
            if (verticalCut[i] > horizontalCut[j]) {
                minCost += verticalCut[i] * noOfHozCut;
                noOfVerCut++;
                i--;
            } else {
                minCost += horizontalCut[j] * noOfVerCut;
                noOfHozCut++;
                j--;
            }
        }
        while (j < 0 && i >= 0) {
            minCost += verticalCut[i] * noOfHozCut;
            noOfVerCut++;
            i--;
        }
        while (i < 0 && j >= 0) {
            minCost += horizontalCut[j] * noOfVerCut;
            noOfHozCut++;
            j--;
        }
        return minCost;
    }
}