class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum%3 == 0) return sum;
        
        int numberToRemove = 100001;
        int smallerNumberToRemove = 100001;
        int largerNumberToRemove = 100001;
        for(int num: nums) {
            if(num%3 == 1) {
                numberToRemove = sum%3 == 1 ? Math.min(numberToRemove, num): numberToRemove;
                if(sum %3==2) {
                    if(num < smallerNumberToRemove) {
                        largerNumberToRemove = smallerNumberToRemove;
                        smallerNumberToRemove = num;
                    } else if(num >= smallerNumberToRemove && num < largerNumberToRemove) {
                        largerNumberToRemove = num;
                    }
                }
            }
            else if(num%3 == 2) {
                numberToRemove = sum%3 == 2 ? Math.min(numberToRemove, num): numberToRemove;
                if(sum%3 == 1){
                    if(num < smallerNumberToRemove) {
                        largerNumberToRemove = smallerNumberToRemove;
                        smallerNumberToRemove = num;
                    } else if(num >= smallerNumberToRemove && num < largerNumberToRemove) {
                        largerNumberToRemove = num;
                    }
                }
            }
        }
        if(numberToRemove < 100001) {
            if(smallerNumberToRemove < 100001 && largerNumberToRemove < 100001) {
                return (sum - Math.min(numberToRemove,smallerNumberToRemove + largerNumberToRemove));
            } else{ 
                return sum - numberToRemove;
            }
            
        }
        if(smallerNumberToRemove < 100001 && largerNumberToRemove < 100001) {
            return sum - (smallerNumberToRemove + largerNumberToRemove);
        }
        return -1;
    }
    
}