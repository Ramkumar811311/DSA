class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
       List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            if (Math.max(start1, start2) <= Math.min(end1, end2)) {
                ans.add(new int[]{Math.max(start1, start2), Math.min(end1, end2)});
            }
            if (end2 > end1) {
                i++;
            } else if (end1 > end2) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}