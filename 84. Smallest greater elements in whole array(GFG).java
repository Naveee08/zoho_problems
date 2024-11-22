class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] greaterElement (int arr[], int n) {
        Set<Integer> set=new HashSet<>();
        int max=0;
        for(int i:arr){
            set.add(i);
            if(i>max){
                max=i;
            }
        }
        
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=arr[i]+1;j<=max;j++){
                if(set.contains(j)){
                    arr[i]=j;
                    flag=true;
                    break;
                }
            }
            if(!flag){
                arr[i]=-10000000;
            }
        }
        return arr;
    }
