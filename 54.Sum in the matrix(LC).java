class Solution {
    public int matrixSum(int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        int res=0;
        for(int i=0;i<m;i++){
            Arrays.sort(nums[i]);
        }
            for(int j=0;j<n;j++){
                int temp=0;
                for(int i=0;i<m;i++){
                    temp=Math.max(temp, nums[i][j]);
            }
                    res+=temp;
        }
        return res;

    }
}
