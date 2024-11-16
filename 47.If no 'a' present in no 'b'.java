class Solution {
    public boolean isNumberPresent(int a, int b) {
        // Convert both numbers to strings
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        
        // Check if strA is a substring of strB
        return strB.contains(strA);
    }
}
