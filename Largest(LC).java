class Solution {
    public int searchInsert(int[] arr, int target) {
       int s = 0;
       int l = arr.length-1;
       while(s<=l){
        int mid = s + (l-s)/2;
        if(arr[mid]>=target){
            l=mid-1;
       }else{
         s=mid+1;
       }
    }
    return s;
  }
}
