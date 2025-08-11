package TopKElements;

import java.util.*;

public class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Count frequencies of each element using a HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. Use a Min-Heap (PriorityQueue) to store the top K elements
        // The heap stores pairs of (element, frequency) and is ordered by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue() // Sort by frequency in ascending order
        );

        // 3. Iterate through the frequency map and add elements to the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry); // Add element to the heap

            // If heap size exceeds k, remove the element with the smallest frequency
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 4. Extract the top K elements from the heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
} 
