class Solution {
    String findSum(String X, String Y) {
        int i=X.length()-1;
        int j=Y.length()-1;
        StringBuilder s=new StringBuilder();
        int carry=0;
        
        while(i>=0 || j>=0 || carry!=0){
            int d1=(i>=0)?X.charAt(i)-'0':0;
            int d2=(j>=0)?Y.charAt(j)-'0':0;
            
            int sum=d1+d2+carry;
            carry=sum/10;
            s.append(sum%10);
            i--;
            j--;
        }
        s.reverse();
        int idx=0;
        while(idx<s.length() && s.charAt(idx)=='0'){
            idx++;
        }
        
        if(idx==s.length()){
            return "0";
        }
        return s.substring(idx).toString();
    }
}
