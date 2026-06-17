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

//bottom up iterative:
class Solution {
    public int climbStairs(int n) {
        int [] arr = new int[n+1];
        arr[0] = 0;
        if(n>=1)arr[1] = 1;
        if(n>=2)arr[2] = 2;
        for(int i = 3; i<=n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}