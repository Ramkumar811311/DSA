class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int noOfIceCream = 0;
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                noOfIceCream++;
                coins -= costs[i];
            } else {
                break;
            }
        }
        return noOfIceCream;
    }
}