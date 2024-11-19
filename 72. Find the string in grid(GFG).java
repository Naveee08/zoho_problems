class Solution
{
    static int[] dx={1,0,1,-1,0,-1,-1,1};
    static int[] dy={0,1,1,0,-1,-1,1,-1};
    
    public boolean isFound(int i, int j, String word, char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int len=word.length();
        for(int dir=0;dir<8;dir++){
            int xx=i;
            int xy=j;
            int k;
            for( k=0;k<len;k++){
                if(xx<0 || xy<0 || xx>=n || xy>=m || grid[xx][xy]!=word.charAt(k)){
                    break;
                }
                xx+=dx[dir];
                xy+=dy[dir];
            }
            if(k==len) return true;
        }
        return false;
    }
    
    
    
    public int[][] searchWord(char[][] grid, String word)
    {
        List<int[]> result=new ArrayList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==word.charAt(0) && isFound(i, j, word, grid)){
                    result.add(new int[]{i,j});
                }
            }
        }
        int[][] ans=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}
