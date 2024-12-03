Question-

Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

Note: A palindrome string is a sequence of characters that reads the same forward and backward.

Examples:

Input: s = "abc"
Output: 2
Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
Input: s = "aacecaaaa"
Output: 2
Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
Constraints:
1 <= s.size() <= 106

Solution-

int minChar(string& st) {
         string s = st;
        reverse(st.begin(),st.end());
        s+="$"+st;
        int n = s.size();
        vector<int> lps(n);
        int len = 0;
        lps[0]=0;
        int i = 1;
        while(i<n){
            if(s[i]==s[len]){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if(len==0){
                    lps[i]=0;
                    i++;
                }
                else{
                    len = lps[len-1];
                    
                }
            }
        }

        return (n/2)-lps[n-1];
     
    }
