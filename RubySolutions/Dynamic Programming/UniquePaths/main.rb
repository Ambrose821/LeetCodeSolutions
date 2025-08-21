# @param {Integer} m
# @param {Integer} n
# @return {Integer}
def unique_paths(m, n)

paths = Array.new(m) {Array.new(n)}

(0...m).each_with_index do |_,i|
    (0...n).each_with_index do |_,j|
        if i == 0 || j ==0
            paths[i][j] =1
            next
        end
        paths[i][j] = paths[i-1][j] +paths[i][j-1]

    end

end
    
paths[m-1][n-1]
end