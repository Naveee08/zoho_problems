class Solution {
    public int addDigits(int num) {
      while(num>=10){
        num=recursive(num);
      }
      return num;
    } 
public int recursive(int temp){
    int sum=0;
    while(temp>0){
        sum+=temp%10;
        temp/=10;
    }
    return sum;
}
    
}

