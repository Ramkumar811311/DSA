class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int arr[] = new int[1001];
        for (int it[] : trips) {
            int noOfPassenger = it[0];
            int from = it[1];
            int to = it[2];

            arr[from] += noOfPassenger;
            arr[to] -= noOfPassenger;
        }
        int totalNoPassenger = 0;
        for (int value : arr) {
            totalNoPassenger += value;
            if (totalNoPassenger > capacity) {
                return false;
            }
        }
        return true;
    }
}