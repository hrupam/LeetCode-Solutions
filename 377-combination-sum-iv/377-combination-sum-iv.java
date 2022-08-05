class Solution {

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return f(target, nums, n, dp);
    }

    private static int f(int target, int[] nums, int n, int[] dp) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (dp[target] != -1) return dp[target];

        int ctr = 0;
        for (int i = 0; i < n; i++) ctr += f(target - nums[i], nums, n, dp);

        return dp[target] = ctr;
    }
}
