import java.util.Arrays;

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int C, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][C + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return knapSackUtill(C, wt, val, n - 1, dp);
    }

    static int knapSackUtill(int C, int[] wt, int[] val, int idx, int[][] dp) {
        if (idx < 0) return 0;
        if (dp[idx][C] != -1) {
            return dp[idx][C];
        }

        int a = 0;

        if (C - wt[idx] >= 0) {
            a = val[idx] + knapSackUtill(C - wt[idx], wt, val, idx - 1, dp);
        }

        int b = knapSackUtill(C, wt, val, idx - 1, dp);
        return dp[idx][C] = Math.max(a, b);
    }
}
