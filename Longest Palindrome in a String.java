Question-

Given a string s, your task is to find the longest palindromic substring within s.

A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.

Examples :

Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.
Input: s = “Geeks” 
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks". 
Input: s = “abc” 
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned.
Constraints:
1 ≤ s.size() ≤ 103
s consist of only lowercase English letters.


Solution-



class Solution {
    static String expandAround(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    static String longestPalindrome(String s) {
        if(s.length()==0||s==null)return "";
        String longestPalin="";
        for(int i=0;i<s.length();i++){
            String pal1=expandAround(s,i,i+1);
            if(pal1.length()>longestPalin.length()){
                longestPalin=pal1;
            }
            String pal2=expandAround(s,i,i);
            if(pal2.length()>longestPalin.length()){
                longestPalin=pal2;
            }
        }
        return longestPalin;
    }
}

