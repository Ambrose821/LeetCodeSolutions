# Definition for a Node.
# class Node
#     attr_accessor :val, :neighbors
#     def initialize(val = 0, neighbors = nil)
#		  @val = val
#		  neighbors = [] if neighbors.nil?
#         @neighbors = neighbors
#     end
# end

# @param {Node} node
# @return {Node}
def cloneGraph(node)
if(!node)
return nil
end

visited= {}
return dfs(node,visited)
    
end

def dfs(node,visited)

    if visited.key?(node.val)
        return visited[node.val]
    end
    copy = Node.new(node.val)
    
    visited[node.val] = copy
    node.neighbors.each do |neighbor|
        copy.neighbors.push(dfs(neighbor,visited))
    end

    return copy
end