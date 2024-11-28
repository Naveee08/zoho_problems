class Solution {

    ArrayList<Integer> findSubarray(int n, int arr[]) {
        ArrayList<Integer> data = new ArrayList<>();
        
        int start = 0;
        int end = 0;
        int tempStart = 0;
        int sum = 0;
        int max = -1;  // Use -1 to handle cases where all numbers are negative.

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {  // Include non-negative numbers in the sum.
                sum += arr[i];
                if (sum > max || (sum == max && i - tempStart > end - start)) {
                    max = sum;
                    start = tempStart;
                    end = i;
                }
            } else {  // Reset on encountering a negative number.
                sum = 0;
                tempStart = i + 1;
            }
        }

        // Add the elements of the maximum subarray to the result.
        for (int i = start; i <= end; i++) {
            data.add(arr[i]);
        }

        // If no subarray found (all elements are negative), return -1.
        if (data.isEmpty()) {
            data.add(-1);
        }

        return data;
    }
}
