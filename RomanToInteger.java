class Solution {
    public int romanToInt(String s) {
        s.toLowerCase();
        s.replaceAll("[^a-z]", "");
        String[] splitS = s.split("");
        
        List<String> numerals = parseNumeralPairsFromComponents(splitS);
        List<Integer> baseTenNumbers = parseBaseTenNumbersFromNumeralPairs(numerals);
        
        int count = 0;
        
        for (Integer currentNum : baseTenNumbers) {
            System.out.println("Current : " + currentNum);
            count = count + currentNum;
        }
        
        return count;
    }
    
    private List<String> parseNumeralPairsFromComponents(String[] numeralComponents) {
        
        List<String> orderedNumerals = new ArrayList();
        
        String previousComponent = null;
        
        for (String currentComponent : numeralComponents) {
            
            if (previousComponent == null) {
                previousComponent = currentComponent;
                orderedNumerals.add(currentComponent);
            } else {
                if (previousComponent.equals("I") && currentComponent.equals("V")) {
                    orderedNumerals.remove(orderedNumerals.size() - 1);
                    orderedNumerals.add("IV");
                } else if (previousComponent.equals("I") && currentComponent.equals("X")) {
                    orderedNumerals.remove(orderedNumerals.size() - 1);
                    orderedNumerals.add("IX");
                } else if (previousComponent.equals("X") && currentComponent.equals("L")) {
                    orderedNumerals.remove(orderedNumerals.size() - 1);
                    orderedNumerals.add("XL");
                } else if (previousComponent.equals("X") && currentComponent.equals("C")) {
                    orderedNumerals.remove(orderedNumerals.size() - 1);
                    orderedNumerals.add("XC");
                } else if (previousComponent.equals("C") && currentComponent.equals("D")) {
                    orderedNumerals.remove(orderedNumerals.size() - 1);
                    orderedNumerals.add("CD");
                } else if (previousComponent.equals("C") && currentComponent.equals("M")) {
                    orderedNumerals.remove(orderedNumerals.size() - 1);
                    orderedNumerals.add("CM");
                } else {
                    orderedNumerals.add(currentComponent);
                }
                
                previousComponent = currentComponent;
            }
        }
        
        return orderedNumerals;
    }
    
    private List<Integer> parseBaseTenNumbersFromNumeralPairs(List<String> numeralPairs) {
        List<Integer> baseTenNumbers = new ArrayList();
        
        for (String numeralPair : numeralPairs) {
            if (numeralPair.equals("I")) { // Basics
                baseTenNumbers.add(1);
            } else if (numeralPair.equals("V")) {
                baseTenNumbers.add(5);
            } else if (numeralPair.equals("X")) {
                baseTenNumbers.add(10);
            } else if (numeralPair.equals("L")) {
                baseTenNumbers.add(50);
            } else if (numeralPair.equals("C")) {
                baseTenNumbers.add(100);
            } else if (numeralPair.equals("D")) {
                baseTenNumbers.add(500);
            } else if (numeralPair.equals("M")) {
                baseTenNumbers.add(1000);
            } else if (numeralPair.equals("IV")) { // Special compound numerals
                baseTenNumbers.add(4);
            } else if (numeralPair.equals("IX")) {
                baseTenNumbers.add(9);
            } else if (numeralPair.equals("XL")) {
                baseTenNumbers.add(40);
            } else if (numeralPair.equals("XC")) {
                baseTenNumbers.add(90);
            } else if (numeralPair.equals("CD")) {
                baseTenNumbers.add(400);
            } else if (numeralPair.equals("CM")) {
                baseTenNumbers.add(900);
            }
        }
        
        return baseTenNumbers;
    }
}