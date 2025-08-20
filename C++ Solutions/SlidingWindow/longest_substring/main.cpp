class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        if(s.length() ==0){
            return 0;
        }
        if(s.length() ==1){
            return 1;
        }

        int window_start = 0;
        int window_end = 0;
        unordered_map<char,int> freq_map;

        int maxLength =0;

        while(window_end< s.length()){
            if(freq_map.count(s[window_end])==1){
                if(freq_map[s[window_end]]>=window_start){
                    window_start = freq_map[s[window_end]] +1;
                }
            }
            freq_map[s[window_end]]= window_end;
            maxLength = max(maxLength,window_end-window_start+1);
            window_end++;
        }

        return maxLength;
        
    }
};