class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> paths(m, vector<int>(n));
        for(int i =0; i< m; i ++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    paths[i][j] = 1;
                    continue;
                }
                if(i==0 && j !=0){
                    paths[i][j] =1;
                    continue;
                }
                if(j==0 && i!=0){
                    paths[i][j]=1;
                    continue;
                }
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
                

            }   
        }
        return paths[m-1][n-1];
    }
};
