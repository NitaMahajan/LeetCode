class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int forwardSum[] = new int[n];
        int backwardSum[] = new int[n];
        for(int i = 0; i < n; i++) {
            forwardSum[i%2] += nums[i];
        }
        int count = 0;
        for(int i = nums.length - 1; i>=0;i--) {
            forwardSum[i%2] -= nums[i];
            if((forwardSum[0] + backwardSum[1]) == (forwardSum[1] + backwardSum[0])) count++;
            backwardSum[i%2] += nums[i];
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