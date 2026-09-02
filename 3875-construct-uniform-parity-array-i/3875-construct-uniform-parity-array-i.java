class Solution {
    public static boolean isPossibleToConstruct(int nums[]) {
        int even[] = new int[nums.length];
        int odd[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int oddNo = 0;
            int evenNo = 0;
            for (int j = 0; j < nums.length; j++) {
                if (oddNo != 0 && evenNo != 0) {
                    break;
                }
                if (i == j) {
                    continue;
                }
                if (nums[j] % 2 == 0) {
                    evenNo = nums[j];
                } else {
                    oddNo = nums[j];
                }
            }
            if (nums[i] % 2 == 0) {
                even[i] = nums[i];
                odd[i] = nums[i] - oddNo;
            } else {
                odd[i] = nums[i];
                even[i] = nums[i] - oddNo;
            }
        }
        boolean isEven = true;
        boolean isOdd = true;
        for (int i = 0; i < nums.length; i++) {
            if (even[i] % 2 != 0) {
                isEven = false;
            }
            if (odd[i] % 2 == 0) {
                isOdd = false;
            }
        }
        return isEven || isOdd;
    }

    public boolean uniformArray(int[] nums1) {
        return isPossibleToConstruct(nums1);
    }
}