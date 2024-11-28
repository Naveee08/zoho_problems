class Solution {
    // Function to reverse words in a given string
    public String reverseWords(String s) {
        s=s.trim();
        String words[]=s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
        
    }
}
