class Solution {
    int binarysearch(int arr[], int n, int k) {
        
        //arr[]=new int[n];
        int start =0,end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==k){
                return mid;
            }
            if(arr[mid]<k){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
        
    }
}
