class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int earliestBloomDay = 0;
        int totalPlantingDays = 0;
        Integer index[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> growTime[b] - growTime[a]);
        for (int i = 0; i < n; i++) {
            int ind = index[i];
            totalPlantingDays += plantTime[ind];
            int bloomDay = totalPlantingDays + growTime[ind];
            earliestBloomDay = Math.max(earliestBloomDay, bloomDay);
        }
        return earliestBloomDay;
    }
}