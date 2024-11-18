class Solution {
    int countFreq(int[] arr, int target) {
        int c=0;
        for(int ch:arr){
            if(ch==target){
                c++;
            }
        }
        return c;
    }
}
