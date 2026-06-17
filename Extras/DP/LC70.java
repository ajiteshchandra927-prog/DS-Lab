//brute force:
class Solution {
    public int helper(int steps, int n){
        if(steps > n)return 0;
        if(steps == n) return 1;
        return helper(steps+1,n)+helper(steps+2,n);
    }
    public int climbStairs(int n) {
        return helper(0,n);
    }
}

//rec + memo
class Solution {
    int [] dp;
    public int helper(int steps, int n){
        if(steps > n)return 0;
        if(steps == n) return 1;
        if(dp[steps] != -1)return dp[steps];
        return dp[steps] = helper(steps+1,n)+helper(steps+2,n);
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,n);
    }
}