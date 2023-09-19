
Question-


Given a number N, check if N is power of 4 or not.

Example 1:

Input: 
N = 64
Output: 1
Explanation:
43= 64
Example 2:

Input: 
N = 75
Output : 0
Explanation :
75 is not a power of 4.
Your task:
You don't have to read input or print anything. Your task is to complete the function isPowerOfFour() which takes an integer N and returns 1 if the number is a power of four else returns 0.
 
Expected Time Complexity: O(N)
Expected Auxiliary Space : O(1)

Constraints:
1<=N<=105


 Solution-


 class Solution{
    public:
    // Function to check if given number n is a power of two.
    bool isPowerofTwo(long long n){
        
        // Your code here
         // Your code here    
        if(n==0)
        return 0;
        
        if((n&(n-1))==0)
        return true;
        return false;
        
    }
};
