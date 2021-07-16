class Solution {
    public boolean isValid(String s) {
        String[] splitStr = s.split("");
        
        List<Boolean> truthiness = new ArrayList();
        
        if (splitStr.length % 2 != 0) {
            return false;
        } else {
            for (int i = 0; i < splitStr.length; i++) {
                for (int j = splitStr.length - 1; j > i; j--) {
                    if (splitStr[i].equals("(") && splitStr[j].equals(")")) {
                        truthiness.add(true);
                    } else if (splitStr[i].equals("{") && splitStr[j].equals("}")) {
                        truthiness.add(true);
                    } else if (splitStr[i].equals("[") && splitStr[j].equals("]")) {
                        truthiness.add(true);
                    } else {
                        truthiness.add(false);
                    }
                }
                
                break;
            }
        }
        
        for (Boolean truth : truthiness) {
            if (truth == false) { 
                return false;
            }
        }
        
        return true;
    }
}