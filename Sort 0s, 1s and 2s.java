Question-

  
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2

Solution-

void sort012(vector<int>& arr) {
        // code here
        int n = arr.size();
        int _0s = 0;
        int _2s = n-1;
        int i = 0;
        
        while( i <= _2s)
        {
            if(arr[i] == 0)
            {
                arr[i] = arr[_0s];
                arr[_0s] = 0;
                _0s++;
                i++;
            }
            else if(arr[i] == 2)
            {
                arr[i] = arr[_2s];
                arr[_2s] = 2;
                _2s--;
            }
            else
            {
                i++;
            }
        }
    }
