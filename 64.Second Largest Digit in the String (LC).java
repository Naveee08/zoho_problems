class Solution {
    public int secondHighest(String s) {
        int second=2;
        for(char i='9';i>='0';i--){
            if(s.indexOf(i)!=-1){
                second--; 
            }
            if(second==0){
                return i-'0';
            }
        }
        return -1;
    }}
