Question-
  
You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

Note: The characters in the strings are in lowercase.

Examples :

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.
Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.
Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.
Constraints:
1 <= s1.size(), s2.size() <= 105

Solution-

class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        int n=s1.length();
        for(int i=0;i<n;i++){
            if(s1.charAt(0)==s2.charAt(i) && (i==0 || s1.charAt(n-1)==s2.charAt(i-1))){
                if(checkRotation(i,s1,s2,n)) return true;
            }
        }
        return false;
    }
    private static boolean checkRotation(int i, String s1, String s2, int n){
        for(int j=0;j<n;j++){
            if(s1.charAt(j)!=s2.charAt(i%n)) return false;
            i++;
        }
        return true;
    }
}
