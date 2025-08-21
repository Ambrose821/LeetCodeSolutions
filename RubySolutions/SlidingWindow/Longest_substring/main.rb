# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
    
    freq_map = {}

    window_start = 0
    window_end = 0
    max_length = 0

    while window_end < s.length
        if freq_map.key?(s[window_end])
            if(freq_map[s[window_end]] >= window_start)
                window_start = freq_map[s[window_end]] +1
            end
        end 
        
        freq_map[s[window_end]] = window_end
        max_length = [max_length,window_end-window_start+1].max
        window_end +=1
    end
    
    return max_length
    end
