class Solution {
    public static int findLowerBound(int arr[], int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int count = 0;
        int n = arr2.length;

        for (int i = 0; i < arr1.length; i++) {

            int j = findLowerBound(arr2, arr1[i]);

            if (j == 0) {

                count += (arr2[0] - arr1[i] > d) ? 1 : 0;

            } else if (j >= n) {

                count += (arr1[i] - arr2[n - 1] > d) ? 1 : 0;

            } else {

                count += ((arr2[j] - arr1[i] > d) &&
                        (arr1[i] - arr2[j - 1] > d)) ? 1 : 0;
            }
        }

        return count;
    }
}