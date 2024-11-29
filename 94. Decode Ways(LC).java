class Solution {
    public static int numDecodings(String s) {
     int n=s.length();
     int dp[] = new int[n+1];
     dp[0]=1;

     if(s.charAt(0)!='0'){
        dp[1]=1;
     }   
     else{
        return 0;
     }

     for(int i=2;i<n;++i){
        if(s.charAt(i-1)=='0'){
            dp[i]+=dp[i-1];
        }
        if(s.charAt(i-2)=='1' || s.charAt(i-2)=='2' || s.charAt(i-2)=='6'){
            dp[i]+=dp[i-1];
        }
     }
     return dp[n];
    }
}
