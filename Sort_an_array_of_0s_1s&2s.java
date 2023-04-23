Question -
  
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 10^6
0 <= A[i] <= 2
  
  
Solution-
  

  //User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        int zero=0;
        int one=0;
        int two=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0)
                zero++;
            else if(a[i]==1)
                one++;
                else
                 two++;
        }
        for(int j=0;j<n;j++){
            if(zero>0){
              a[j]=0;
              zero--;
            }
             else if(one>0){
               a[j]=1;
               one--;
             }
               else{
                   a[j]=2;
                   two--;
               }
        }
        
    }
}
