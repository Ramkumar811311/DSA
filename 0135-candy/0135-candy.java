class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n==1){
            return 1;
        }
        Integer index[] = new Integer[n];
        int candy[] = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
            candy[i] = 1;
        }
        Arrays.sort(index, (a, b) -> ratings[a] - ratings[b]);
        for (int i = 0; i < n; i++) {
            int ind = index[i];
            if (ind == 0 && ind + 1 < n) {
                if (ratings[ind] > ratings[ind + 1]) {
                    candy[ind] = candy[ind + 1] + 1;
                }
            } else if (ind == n - 1 && ind-1>=0) {
                if (ratings[ind] > ratings[ind - 1]) {
                    candy[ind] = candy[ind - 1] + 1;
                }
            } else {
                if (ratings[ind] > ratings[ind + 1] && ratings[ind] > ratings[ind - 1]) {
                    candy[ind] = Math.max(candy[ind - 1], candy[ind + 1]) + 1;
                } else if (ratings[ind] > ratings[ind + 1]) {
                    candy[ind] = candy[ind + 1] + 1;
                } else if (ratings[ind] > ratings[ind - 1]) {
                    candy[ind] = candy[ind - 1] + 1;
                }
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            ans+=candy[i];
        }
        return ans;
    }
}