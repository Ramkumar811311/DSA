class Solution {
    public int sumCounts(List<Integer> nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans=0;
        for(int i=0; i<nums.size(); i++){
            for(int j=i; j<nums.size(); j++){
                set.add(nums.get(j));
                int distinct = set.size();
                ans+=distinct*distinct;
            }
            set.clear();
        }
        return ans;
    }
}