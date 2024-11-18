class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8){
            return false;
        }
        boolean hasUpper=false;
        boolean hasLower=false;
        boolean hasDigit=false;
        boolean hasSpec=false;
        char prev=' ';
        for(int i=0;i<password.length();++i){
            char c=password.charAt(i);
            if(c==prev) return false;

            if('A'<=c && c<='Z'){
                hasUpper= true;
            }
            else if('a'<=c && c<='z'){
                hasLower= true;
            }
            else if('0'<=c && c<='9'){
                hasDigit= true;
            }
            else{
                hasSpec=true;
            }
            prev=c;
        }
        return hasUpper && hasLower && hasDigit && hasSpec;
    }
}
