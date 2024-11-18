class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int c=1;
        int max=0;
        Arrays.sort(nums);
        if(n==0) return 0;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i]==nums[i-1]+1){
                    c++;
                }
                else{
                    max=Math.max(max,c);
                    c=1;
                }
            }
        }
        return Math.max(max,c);
    }
}
