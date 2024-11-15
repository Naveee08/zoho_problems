class Main {
    
    public static String addDigit(int dig, int n) {
        String num = String.valueOf(n);  // Convert the number to a string
        StringBuilder sb = new StringBuilder();  // StringBuilder to build the result
        
        // Iterate through each character of the string
        for (char ch : num.toCharArray()) {
            int currEle = Character.getNumericValue(ch);  // Get the numeric value of the character
            int newDig = currEle + dig;  // Add the specified digit to the current digit
            sb.append(newDig);  // Append the new digit to the result
        }
        
        return sb.toString();  // Return the final result as a string
    }

    public static void main(String[] args) {
        int n = 2875;
        int d = 4;
        // Call the addDigit method and print the result
        System.out.println(addDigit(d, n));  // Output: 612119
    }
}
