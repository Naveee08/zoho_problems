class Solution {
    public static void convertToWave(int[] arr) {
        for(int i=0;i<arr.length-1;i=i+2){
            if(arr[i]<arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
    }
}
