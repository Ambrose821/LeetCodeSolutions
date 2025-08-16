package Solutions.TopKElements.TopKFrequentElements;
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> frequencies = new HashMap<>();
        
        for(int num: nums){
            frequencies.put(num, frequencies.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer,Integer> entry : frequencies.entrySet()){
          
             minHeap.offer(entry);
             if(minHeap.size() >  k){
                minHeap.poll();
             }
        }
        int [] results = new int[k];
        for(int i = k-1; i >=0; i-- ){
            results[i] = minHeap.poll().getKey();
        }

        return results;
    }
}
