class Solution {
    public static int findUnion(int a[], int b[]) {
        HashSet<Integer> s=new HashSet<>();
        for(int i=0;i<a.length;i++){
            s.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            s.add(b[i]);
        }
        return s.size();
    }
}
