Question-

Given an array arr[], return true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.

Examples:

Input: arr[] = [3, 2, 4, 6, 5]
Output: true
Explanation: a=3, b=4, and c=5 forms a pythagorean triplet.
Input: arr[] = [3, 8, 5]
Output: false
Explanation: No such triplet possible.
Input: arr[] = [1, 1, 1]
Output: false
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 103


Solution-

class Solution {
  public:
     bool pythagoreanTriplet(vector<int>& arr) {
            // code here
            int n=arr.size();
            unordered_map<int,int>ump;
             for (int i = 0; i < n; ++i) {
                int sq = arr[i] * arr[i];
                ump[sq]++;
            }
          vector<int>tes;
          for(const auto&k:ump){
              tes.push_back(k.first);
          }
          int m=tes.size();
            vector<int>vp;
            for(int i=0; i<m-1; i++){
                int temp=tes[i];
                for(int j=i+1; j<m; j++){
                    vp.push_back(temp+tes[j]);
                }
            }
            
           for(auto&k:vp){
               if(ump.find(k)!=ump.end()){
                   return true;
               }
           }
            return false;
        
    }
};
