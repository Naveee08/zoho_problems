class Solution
{
    public static int closestToZero (int arr[], int n)
    {
        Arrays.sort(arr);
        int tot=0;
        int sum=arr[0]+arr[n-1];
        int i=0;
        int j=n-1;
        while(i<j){
            tot=arr[i]+arr[j];
            if(Math.abs(tot)<Math.abs(sum) || Math.abs(tot)==Math.abs(sum) && tot>sum){
                sum=tot;
            }
            if(tot<0){
                i++;
            }
            else{
                j--;
            }
        }
        return sum;
    }
}
