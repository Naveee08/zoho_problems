class Solution {
    boolean twoSum(int arr[], int target) {
       HashSet<Integer> s=new HashSet<>();
       
       for(int num:arr){
           int c=target-num;
           
           if(s.contains(c)){
               return true;
           }
           s.add(num);
       }
       return false;
    }
}
