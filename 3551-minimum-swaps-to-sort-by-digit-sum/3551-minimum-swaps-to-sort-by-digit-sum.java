class Solution {
    public static int sumOfDigit(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        HashMap<Integer, Integer> digitSumMap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer sorted[] = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            digitSumMap.put(nums[i], sumOfDigit(nums[i]));
            sorted[i] = nums[i];
            map.put(nums[i], i);
        }
        Arrays.sort(sorted, (a, b) -> {
            int sumA = digitSumMap.get(a);
            int sumB = digitSumMap.get(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a, b);
        });
        int swap = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                int index = map.get(sorted[i]);
                int current = nums[i];
                int target = nums[index];
                // Swap elements
                nums[i] = target;
                nums[index] = current;

                // Update positions
                map.put(current, index);
                map.put(target, i);
                swap++;
            }
        }
        return swap;
    }
}