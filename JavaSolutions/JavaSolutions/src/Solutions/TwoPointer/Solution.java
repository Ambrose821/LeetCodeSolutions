package Solutions.TwoPointer;

public class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int [2];    
        int p1 =0;
        int p2 =numbers.length-1;
        for(int i =0; i< numbers.length-1; i++ ){
            if(numbers[p1] +numbers[p2] == target){
                res[0] = p1+1;
                res[1] = p2+1;
                return res;
            }
            if(numbers[p1] + numbers[p2] > target){
                p2--;
                continue;
            }
            if(numbers[p1] +numbers[p2]<target){
                p1++;
                continue;
            }
        }
        return null;

    }


}


