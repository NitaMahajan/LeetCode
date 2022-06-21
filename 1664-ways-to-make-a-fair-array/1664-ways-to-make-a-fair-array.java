class Solution {
    public int waysToMakeFair(int[] nums) {
        int prefixEvenSum[] = new int[nums.length];
        int prefixOddSum[] = new int[nums.length];
        prefixEvenSum[0] = nums[0];
        for(int i = 1;i < nums.length;i++) {
            if(i%2==0) {
                prefixEvenSum[i] = prefixEvenSum[i-1]+nums[i];
                prefixOddSum[i] = prefixOddSum[i-1];
            } else {
                prefixEvenSum[i] = prefixEvenSum[i-1];
                prefixOddSum[i] = prefixOddSum[i-1]+nums[i];
            }
        }
        int prefixEvenSumBack = 0, prefixOddSumBack = 0, count = 0;
        for(int i = nums.length - 1; i>=1;i--) {
            if((prefixEvenSumBack + prefixEvenSum[i-1]) == (prefixOddSumBack + prefixOddSum[i-1])) {
                count++;
            }
            if(i%2 == 0) {
                prefixOddSumBack += nums[i];
            } else {
                prefixEvenSumBack += nums[i];
            }
        }
        if(prefixEvenSumBack == prefixOddSumBack) {
            count++;
        }
        return count;
    }
    //[2,1,6,4]
    //sum=13
    //sumEven=8, sumOdd=5
    //sumEvenBack=0, sumOddBack=0;
    //[2,1,6,4] sumEven=2+sumEvenBack=6, sumOdd=5, sumEvenBack=4,sumOddBack=0
    //[1,2,3,4,...,p,...,n]
    //sumEven=sE, sumOdd=sO, sum=s;
    //let sumEvenTillP, sumOddTillP
    //let sumEvenBackTillP, sumOddBackTillP
    //condition: sumEvenTillP+sumEvenBackTillP == sumOddTillP+sumOddBackTillP
    // if p is even, sumEven-p = 
    //prefixSumEven = [2,2,8,8];
    //prefixSumOdd = [0,1,1,5];
    //[2,1,6,4] //sumEvenBack=0, sumOddBack=0; 8+0 == 1+0? no, if(i%2==1)sumEvenBack+=nums[i]
    //[2,1,6,4] //sumEvenBack=4, sumOddBack=0; 4+2 === 0+1? no sumOddBack=6
    //[2,1,6,4]//sumEvenBack=4,sumOddBack=6;4+2 == 6+0 ? yes count++ sumEvenBack+=nums[i]=4+1=5
    
    
    
}