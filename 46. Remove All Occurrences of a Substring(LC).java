class Solution {
    public String removeOccurrences(String s, String part) {
        return sub(s, part);
    }
    public String sub(String s, String part){
        int i=s.indexOf(part);
        if(i==-1){
            return s;
        }
        return sub(s.substring(0,i)+s.substring(i+part.length(), s.length()), part);
    }
}
