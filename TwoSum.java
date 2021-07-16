class Solution {
    public int[] twoSum(int[] nums, int target) {
    
        int numbersToSum[] = new int[2];
        
        for(int j = 1; j < nums.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[j] + nums[i] == target) {
                    numbersToSum[0] = i;
                    numbersToSum[1] = j;
                    
                    break;
                }
            }
        }
        
        return numbersToSum;
    }
}