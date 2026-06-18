class Solution {
    int []t;
    public int helper(int [] nums, int i, int n){
        if(i>=n)return 0;
        if(t[i]!=-1)return t[i];
        int steal = nums[i]+helper(nums,i+2,n);
        int skip = helper(nums,i+1,n);
        return t[i] = Math.max(steal,skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        t = new int[101];
        Arrays.fill(t,-1);
        int a = helper(nums,0,n-1);
        Arrays.fill(t,-1);
        int b = helper(nums,1,n);
        return Math.max(a,b);
    }
}