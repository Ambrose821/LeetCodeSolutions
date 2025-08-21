class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        

        using P = pair<int,int>;
        unordered_map<int,int> freq_map;

        for(int num :nums){
            freq_map[num]++;
        }


  

        //comparator for min Heap
        auto comparator = [](const P &a, const  P &b){
            return a.second > b.second;
        };

        

        priority_queue<P,vector<P>,decltype(comparator)> pq(comparator);

        for(auto &pair : freq_map){
           
            pq.push({pair.first,pair.second});
             if(pq.size() >k){
                pq.pop();
            }
            cout << pair.first << ":  " << pair.second << "\n";
        }

        vector<int> ret_list(k);

        for(int i =0; i < k; i++){

            int val = pq.top().first;
            ret_list[i]=val;
            pq.pop();
         
        }
        return ret_list;


    }
};