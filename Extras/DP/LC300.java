class Solution {
    int n;
    int [][] dp;
    public int helper(int [] nums, int prev, int curr){
        if(curr>=n){
            return 0;    
        }
        if(dp[prev+1][curr] != -1)return dp[prev+1][curr];
        int take = 0;
        if(prev==-1 || nums[curr] > nums[prev]){
            take = 1+helper(nums,curr,curr+1);
        }
        int skip = helper(nums,prev,curr+1);
        return dp[prev+1][curr] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[2500][2500];
        for(int i = 0; i<2500; i++)Arrays.fill(dp[i],-1);
        n = nums.length;
        return helper(nums,-1,0);
    }
}
public class LC300 {
    
}
