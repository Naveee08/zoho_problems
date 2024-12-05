public class GFG{
  public static boolean shouldSwap(char[]str, int start, int curr){
      for(int i=start; i<curr;i++){
      if(str[i]==str[curr]){
        return false;
      }
      }
    return true;
  
  } 
  public static void findPermutation(char[] str, int index, int n){
        if(index>=n){
        System.out.println(str);
          return;
        }  
    for(int i=index;i<n;i++){
       boolean check=shouldSwap(str, index, i);
      if(check){
        swap(str,index,i);
        findPermutation(str,index+1,n);
        swap(str,index,i);
      }
    }
  }
  public static void swap(char[] str, int i, int j){
    char c=str[i];
    str[i]=str[j];
    str[j]=c;
  }
  public static void main(String args[]){
  char[] str={'A','B', 'C', 'A'};
    int n=str.length;
    findPermutation(str, 0, n);
  }
}
