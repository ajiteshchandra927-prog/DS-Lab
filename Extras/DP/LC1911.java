class Solution {
    int n;
    long [][]t;
    public long helper(int [] nums,int i, boolean flag){
        if(i>=n)return 0;
        int f = flag ? 1 : 0;
        if(t[i][f] != -1)return t[i][f];
        long skip = helper(nums,i+1,flag);
        long val = nums[i];
        if(!flag) val = -val;
        long take = helper(nums,i+1,!flag)+val;
        return t[i][f] = Math.max(skip,take);
    }
    public long maxAlternatingSum(int[] nums) {
        t = new long[100001][2];
        for(int i = 0; i<100001; i++){
            Arrays.fill(t[i],-1);
        }
        n = nums.length;
        return helper(nums,0,true);
    }
}