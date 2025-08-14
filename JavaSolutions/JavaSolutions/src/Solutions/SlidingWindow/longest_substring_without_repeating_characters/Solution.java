package Solutions.SlidingWindow.longest_substring_without_repeating_characters;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int windowStart = 0;
        int windowEnd =0;
        
        if(s.length() ==1){
            return 1;
        }
        if(s.length() ==0){
            return 0;
        }


        int maxLength =0;
    
 
        while(windowEnd< s.length()){
            char c = s.charAt(windowEnd);

            if(map.containsKey(c)){
                int foundIndex = map.get(c);
                //we only care about finding an existing char if it is in the window
                if(foundIndex >= windowStart){
                    windowStart = foundIndex+1;
                }
            }

            map.put(c,windowEnd);
 

            maxLength = Math.max(maxLength,windowEnd - windowStart +1);

                 
            windowEnd++;

        }
        
      
        return maxLength;
        
    }
}