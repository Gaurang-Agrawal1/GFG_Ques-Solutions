Question-



Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers. Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all flowers after  k days of watering.

Examples:

Input: arr[] = [2, 3, 4, 5, 1], k = 2, w = 2
Output: 2
Explanation: The minimum height after watering is 2.
Day 1: Water the last two flowers -> arr becomes [2, 3, 4, 6, 2]
Day 2: Water the last two flowers -> arr becomes [2, 3, 4, 7, 3]
Input: arr[] = [5, 8], k = 5, w = 1
Output: 9
Explanation: The minimum height after watering is 9.
Day 1 - Day 4: Water the first flower -> arr becomes [9, 8]
Day 5: Water the second flower -> arr becomes [9, 9]
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ w ≤ arr.size()
1 ≤ k ≤ 105
1 ≤ arr[i] ≤ 109


Solution-


class Solution {
  public:
  
  bool check(int mid , int k , int w , vector<int>&arr){
      
      int n = arr.size();
      vector<int>vis(n+2 , 0);
      int curr = 0;
      for(int i=0;i<n ; i++){
          curr+=vis[i];
          int h = arr[i] + curr;
          if(h< mid){
              int j = mid - h;
              if(j<=k)k-=j;
              else return false;
              curr+=j;
              h = i+w;
              if(h<=n)vis[h]-=j;
          }
      }
      return true;
  }
    int maxMinHeight(vector<int> &arr, int k, int w) {
        // code here
        int st = *min_element(arr.begin() , arr.end()) , en = INT_MAX;
        int ans = st;
        while(st<=en){
            int mid = (st + en)/2;
            if(check(mid , k , w , arr)){
                ans = mid;
                st = mid+1;
            }else{
                en = mid-1;
            }
        }
    return ans;
        
    }
};

