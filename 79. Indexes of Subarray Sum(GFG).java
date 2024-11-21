class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
          ArrayList<Integer> a=new ArrayList<Integer>();
          int left=0;
          int sum=0;
          
          for(int right=0;right<arr.length;right++){
              sum+=arr[right];
              while(sum>target && left<=right){
                  sum-=arr[left];
                  left++;
              }
              if(sum==target){
                  a.add(left+1);
                  a.add(right+1);
                  return a;
              }
          }    
              a.add(-1);
              return a;
    }
}
