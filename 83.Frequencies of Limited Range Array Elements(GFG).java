class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
       int d=arr.length+1;
       
       for(int i=0;i<arr.length;i++){
           int idx=(arr[i]%d)-1;
           arr[idx]+=d;
       }
       List<Integer> list =new ArrayList<>();
       for(int i=0;i<arr.length;i++){
           list.add(arr[i]/d);
       }
       return list;
    }
}
