class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 1;
        boolean isGreater = false;
        boolean isSmaller = false;
        int l = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (!isSmaller) {
                    l = i - 1;
                }
                isGreater = true;
                isSmaller = false;
            } else if (arr[i] < arr[i - 1]) {
                if (!isGreater) {
                    l = i - 1;
                }
                isGreater = false;
                isSmaller = true;
            } else {
                l = i;
                isGreater = false;
                isSmaller = false;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}