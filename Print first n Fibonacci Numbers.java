Question-



Given a number N, find the first N Fibonacci numbers. The first two number of the series are 1 and 1.

Example 1:

Input:
N = 5
Output: 1 1 2 3 5
Example 2:

Input:
N = 7
Output: 1 1 2 3 5 8 13
Your Task:
Your task is to complete printFibb() which takes single argument N and returns a list of first N Fibonacci numbers.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
Note: This space is used to store and return the answer for printing purpose.

Constraints:
1<= N <=84



Solution-



class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
         long[] fibo=new long[n];
        long a=1;
        long b=1;
        for(int i=0;i<n;i++) {
            if(i==0) {
                fibo[i]=1;
            }
            else if(i==1) {
                fibo[i]=1;
            }
            else {
                fibo[i]=a+b;
                a=b;
                b=fibo[i];
            }
        }
        return fibo;
    }
}
