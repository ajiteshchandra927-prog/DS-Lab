//recursion
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
//iterative dp
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+2];
        for(int i = n-1; i>=0; i--){
            dp[i] = Math.max(nums[i]+dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}