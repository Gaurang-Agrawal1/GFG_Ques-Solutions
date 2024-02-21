Question-



Given a boolean expression s of length n with following symbols.
Symbols
    'T' ---> true
    'F' ---> false
and following operators filled between symbols
Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Note: The answer can be large, so return it with modulo 1003

Example 1:

Input: 
n = 7
s = T|T&F^T
Output: 
4
Explaination: 
The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
Example 2:

Input: 
n = 5
s = T^F|F
Output: 
2
Explaination: 
((T^F)|F) and (T^(F|F)) are the only ways.
Your Task:
You do not need to read input or print anything. Your task is to complete the function countWays() which takes n and s as input parameters and returns number of possible ways modulo 1003.

Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)

Constraints:
1 ≤ n ≤ 200 



Solution-



class Pair {
    int t, f;
    int modulo = 1003;
    
    Pair (int t, int f) {
        this.t = t;
        this.f = f;
    }
    
    public void applyModulo() {
        this.t %= modulo;
        this.f %= modulo;
    }
}

class Solution{
     static Pair rec(String s, HashMap<String, Pair> mem) {
        
        if(s.length()==0) {
            return new Pair(0, 0);
        }
        
        if(s.length()==1) {
            return s.charAt(0) == 'T' ? new Pair(1, 0) : new Pair(0, 1);
        }
        
        if(mem.containsKey(s)) {
            return mem.get(s);
        }
        
        Pair ans = new Pair(0, 0);
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '&') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.t * rightWays.t;
                ans.f += leftWays.f*rightWays.f + leftWays.t*rightWays.f + leftWays.f*rightWays.t;
            } else if(s.charAt(i) == '|') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.t*rightWays.t + leftWays.t*rightWays.f + leftWays.f*rightWays.t;
                ans.f += leftWays.f*rightWays.f;
            } else if(s.charAt(i) == '^') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.f*rightWays.t + leftWays.t*rightWays.f;
                ans.f += leftWays.t*rightWays.t + leftWays.f*rightWays.f;
            }
            ans.applyModulo();
        }
        
        mem.put(s, ans);
        
        return ans;
        
    }
    
    static int countWays(int n, String s){
        // code here
         HashMap<String, Pair> mem = new HashMap<>();
        
        return rec(s, mem).t;
    }
}
