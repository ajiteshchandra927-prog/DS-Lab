class Solution {
    int t[];
    public int helper(int [] nums, int i){
        if(i>=nums.length)return 0;
        if(t[i]!=-1)return t[i];
        int steal = nums[i]+helper(nums,i+2);
        int skip = helper(nums,i+1);
        return t[i] = Math.max(steal,skip);
    }
    public int rob(int[] nums) {
        t = new int[101];
        Arrays.fill(t,-1);
        return helper(nums,0);
    }
}