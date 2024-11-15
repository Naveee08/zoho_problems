class Solution {
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(int arr[]) {
       int rsum=0;
       for(int i:arr){
           rsum+=i;
       }
       int lsum=0;
       for(int i=0;i<arr.length;i++){
           if(lsum==(rsum-lsum-arr[i])){
               return i+1;
           }
           lsum+=arr[i];
       }
       return -1;
    }
}
