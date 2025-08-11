package Solutions.PrefixSum.RangeSumQuery;

public class Solution {


    class NumArray {
    int [] nums;
    int [] processed;

    public NumArray(int[] nums) {
        this.nums = nums;

        this.processed = new int[nums.length];
        for(int i =0; i < this.nums.length; i++){
            if(i == 0){
                this.processed[i] = this.nums[i]; 
                
                continue;

            }
            this.processed[i] = this.nums[i] + this.processed[i-1];

        }
        

        

        
    }
    
    public int sumRange(int left, int right) {
        if(left ==0){
            return this.processed[right];
        }
        return this.processed[right] - this.processed[left-1];
        
    }

   
}

/*
[1,2,3,4, 5,  6]
[1,3,6,10,15,21]


[2,4,6,8]
[2,6,12,20]

[-2,0,3,-5,2,-1]
[-2,-2,]
*/

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

}
