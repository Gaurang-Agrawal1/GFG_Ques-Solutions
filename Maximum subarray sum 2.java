Question-

  
You are given an array arr[] of integers and two integers a and b, You have to find the maximum possible sum of a contiguous subarray whose length is at least a and at most b.

Examples:

Input: arr[] = [4, 5, -1, -2, 6], a = 2, b = 4
Output: 9
Explanation: The subarray [4, 5] has length 2 and sum 9, which is the maximum among all subarrays of length between 2 and 4.
Input: arr[] = [-1, 3, -1, -2, 5, 3, -5, 2, 2], a = 3, b = 5
Output: 8
Explanation: The subarray [3, -1, -2, 5, 3] has length 5 and sum 8, which is the maximum among all subarrays of length between 3 and 5.
Constraints:
1 ≤ arr.size() ≤ 105
-105 ≤ arr[i] ≤ 105
1 ≤ a ≤ b ≤ arr.size()


Solution-

  class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        // code here
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        SegmentTree tree = new SegmentTree(prefix);
        int ans =  Integer.MIN_VALUE;
        for(int i = 0 ; i <= arr.length-a ; i++){
            int f = i + (a-1);
            int s = i + (b-1) < arr.length ? i + (b-1):arr.length - 1;
            int m = tree.query(f,s);
            if(i == 0){
                ans = Math.max(ans,m);
            }else{
                ans = Math.max(ans,m - prefix[i-1]);
            }
        }
        return ans;
    }
}
class SegmentTree{
    class Node{
        int max;
        int l;
        int r;
        Node left;
        Node right;
        Node(int l ,int r){
            this.l = l;
            this.r = r;
        }
    }
    Node root;
    SegmentTree(int[] arr){
        root = createNode(arr,0,arr.length-1);
    }
    public Node createNode(int[] arr,int st,int ed){
        if(st == ed){
            Node node = new Node(st,ed);
            node.max=arr[st];
            return node;
        }
        int mid = st + (ed-st)/2;
        Node node = new Node(st,ed);
        node.left = createNode(arr,st,mid);
        node.right = createNode(arr,mid+1,ed);
        node.max = Math.max(node.left.max,node.right.max);
        return node;
    }
    public int query(int s,int e){
        return doquery(root,s,e);
    }
    public int doquery(Node node,int s,int e){
        if(node.l >= s && node.r <= e){
            return node.max;
        }else if(node.l > e || node.r <s){
            return Integer.MIN_VALUE;
        }
        int l = doquery(node.left,s,e);
        int r = doquery(node.right,s,e);
        return Math.max(l,r);
    }
}
