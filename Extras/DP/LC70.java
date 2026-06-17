//brute force:
class Solution {
    int ways = 0;
    public void helper(int steps, int n){
        if(steps > n)return;
        if(steps == n){
            ways++;
            return;
        }
        helper(steps+1,n);
        helper(steps+2,n);
    }
    public int climbStairs(int n) {
        helper(0,n);
        return ways;
    }
}
