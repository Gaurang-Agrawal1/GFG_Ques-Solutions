Question-

  
Given an array arr[] that may contain duplicates. Find all possible distinct permutations of the array in sorted order.
Note: A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Examples:

Input: arr[] = [1, 3, 3]
Output: [[1, 3, 3], [3, 1, 3], [3, 3, 1]]
Explanation: These are the only possible distinct permutations for the given array.
Input: arr[] = [2, 3]
Output: [[2, 3], [3, 2]]
Explanation: These are the only possible distinct permutations for the given array.
Constraints:
1 ≤ arr.size() ≤ 9


Solution-


  
import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        do {
            ArrayList<Integer> perm = new ArrayList<>(arr.length);
            for (int x : arr) perm.add(x);
            res.add(perm);
        } while (nextPermutation(arr));
        return res;
    }

    private static boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int j = n - 1;
        while (a[j] <= a[i]) j--;
        swap(a, i, j);
        reverse(a, i + 1, n - 1);
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }
}
