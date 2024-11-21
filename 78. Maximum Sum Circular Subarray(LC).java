public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0; // To calculate the sum of all elements
        int maxSum = Integer.MIN_VALUE; // Initialize max sum for non-circular case
        int curMax = 0; // Current maximum subarray sum ending at current element
        int minSum = Integer.MAX_VALUE; // Initialize min sum for circular case
        int curMin = 0; // Current minimum subarray sum ending at current element

        // Iterate over each element in the array
        for (int num : nums) {
            // Kadane's algorithm to find maximum subarray sum in a non-circular array
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            // Kadane's algorithm to find minimum subarray sum
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);

            // Calculate the total sum of the array
            totalSum += num;
        }

        // If all numbers are negative, return maxSum (non-circular case only)
        // This handles the edge case where totalSum - minSum would be 0
        if (maxSum < 0) {
            return maxSum;
        }

        // The result is the maximum between the non-circular max sum and the circular max sum
        return Math.max(maxSum, totalSum - minSum);
    }
}
