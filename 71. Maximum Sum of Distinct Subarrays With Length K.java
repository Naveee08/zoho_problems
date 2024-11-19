class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       int maxSum=0;
       for(int num:nums){
        maxSum=Math.max(maxSum, num);
       }
       int[] count=new int[maxSum+1];
       int dupCount=0;
       long totalSum=0;
       long currSum=0;

       for(int i=0;i<k;i++){
           if(count[nums[i]]>=1){
            dupCount++;
           }
           count[nums[i]]++;
           currSum+=nums[i];
       }
       if(dupCount==0){
        totalSum=currSum;
       }

       for(int i=k;i<nums.length;i++){
         if(count[nums[i]]>=1){
            dupCount++;
           }
           count[nums[i]]++;
           currSum+=nums[i];

           if(count[nums[i-k]]>1){
            dupCount--;
           }
           count[nums[i-k]]--;
           currSum-=nums[i-k];

           if(dupCount==0){
            totalSum=Math.max(totalSum, currSum);
           }
       }
       return totalSum;

    }
}
