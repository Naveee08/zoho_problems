class GfG
{
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        Set<ArrayList<Integer>> set =new LinkedHashSet<>();
        for(int i=0;i<r;i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<c;j++){
                row.add(a[i][j]);
            }
            set.add(row);
        }
        return new ArrayList<>(set);
    }
}
