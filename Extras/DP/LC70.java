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