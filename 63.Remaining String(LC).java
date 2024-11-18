class Solution {
    public String printString(String s, char ch, int count) {
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(count==0){
                sb.append(s.charAt(i));
            }
            else{
                if(s.charAt(i)==ch){
                    count--;
                }
            }
        }
        return sb.toString();
    }
}
