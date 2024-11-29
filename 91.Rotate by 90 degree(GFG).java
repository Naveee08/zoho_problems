class Solution {
 static void rotateby90(int mat[][]) {
        int n=mat.length;
        //transporse the matrix
        for (int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
        //reverse the matrix
        for(int i=0;i<n;i++){
            int top=0;
            int bottom=n-1;
            while(top<bottom){
            int temp=mat[top][i];
            mat[top][i]=mat[bottom][i];
            mat[bottom][i]=temp;
            top++;
            bottom--;
        }
        }
       }
}
