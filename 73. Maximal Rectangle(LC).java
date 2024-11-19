import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }

      int n=matrix.length;
      int m=matrix[0].length;
      int pSum[][]=new int[n][m];
      int maxArea=0;

     
    for(int j=0;j<m;j++){
        int sum=0;
       for(int i=0;i<n;i++){
            if(matrix[i][j]=='1'){
                sum+=1;
            }
            else{
                sum=0;
            }
            pSum[i][j]=sum;
        }
      }
        for(int i=0;i<n;i++){
            maxArea=Math.max(maxArea, largestHistogram(pSum[i]));
        }
        return maxArea;
    }

    private int largestHistogram(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int n=heights.length;
        int maxArea=0;

        for(int i=0;i<=n;i++){
            int currSum=(i==n) ? 0:heights[i];
            while(!stack.isEmpty() && currSum<heights[stack.peek()]){
                int height=heights[stack.pop()];
                int width=stack.isEmpty() ? i:i-stack.peek()-1;
                maxArea=Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
