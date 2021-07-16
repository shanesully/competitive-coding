class Solution {
    public int reverse(int x) {
        String intStr = String.valueOf(x);
        String reversedIntStr = new StringBuilder(intStr).reverse().toString();
    
        int result = 0;
        
        if (reversedIntStr.contains("-")) {
            reversedIntStr = reversedIntStr.replace("-", "");
            
            try {
                return Integer.parseInt("-" + reversedIntStr);
            } catch (NumberFormatException e) {
                return result;
            }
        } else {
            try {
                return Integer.parseInt(reversedIntStr);
            } catch (NumberFormatException e) {
                return result;
            }
        }
    }
}