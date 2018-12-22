package drew.search;
public class BinarySearch {
	public static int binarySearch(int [] a, int target){
	    int left  = 0;
	    int right = a.length - 1 ;
	    int mid = (left + right)/2;
	    while(left < right){
		    if(a[mid] == target) {
		    	return mid;
		    } else  if(a[mid] > target) {
		    	right = mid - 1;
		    	mid = (left + right)/2;
		    } else {
		    left = mid + 1;
		    mid = (left + right)/2;
		    }
	    }
	    return -1;//not found
	}
	public static void main(String args []) {
		int[] a = new int[] {5, 16, 39, 45, 51, 98, 100, 202, 226, 321, 368, 444, 501};
		System.out.println(binarySearch(a,100));
	}
}