//using rec + memo
class Solution {
    int [] dp;
    public int helper(int n){
        if(n<=1)return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = helper(n-1)+helper(n-2);
    }
    public int fib(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(n>=0)dp[0]=0;
        if(n>=1)dp[1]=1;
        helper(n);
        return dp[n];
    }
}

//using bottom up:
class Solution {
    public int fib(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        if(n>=1)dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}