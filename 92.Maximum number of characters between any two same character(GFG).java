class Solution
{
    public int maxChars(String s)
    {
        int firstIdx[]=new int[256];
        
        for(int i=0;i<256;i++){
            firstIdx[i]=-1;
        }
        
        int maxDis=-1;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(firstIdx[ch]==-1){
                firstIdx[ch]=i;
            }
            else{
                int dis=i-firstIdx[ch]-1;
                maxDis=Math.max(dis, maxDis);
            }
        }
        return maxDis;
    }
}
