
Question-
Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
 

Your Task:
You don't need to read input or print anything. Complete the function isPalindrome()which accepts string S and returns an integer value 1 or 0.

Expected Time Complexity: O(Length of S)
Expected Auxiliary Space: O(1)


Constraints:
1 <= Length of S<= 105Given a string S, check if it is palindrome or not.

Example 1:

Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:

Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
 

Your Task:
You don't need to read input or print anything. Complete the function isPalindrome()which accepts string S and returns an integer value 1 or 0.

Expected Time Complexity: O(Length of S)
Expected Auxiliary Space: O(1)


Constraints:
1 <= Length of S<= 105
  
  
  
  Solution-
 

//User function Template for Java

class Solution {
    int isPalindrome(String s) {
        // code here
        for(int i=0;i<s.length()/2;i++){
            int n=s.length();
            if(s.charAt(i)!=s.charAt(n-1-i)){
                return 0;
            }
        }
        return 1;
    }
};
