class Solution {

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int tar = 1; tar <= target; tar++) {
            for (int i = 0; i < n; i++) {
                if (tar >= nums[i]) dp[tar] += dp[tar - nums[i]];
            }
        }

        return dp[target];
    }
}
