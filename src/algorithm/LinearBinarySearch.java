package algorithm;
/**
 * 
 * Binary search is a fast search algorithm that works on sorted lists. 
 * It belongs to the Divide and Conquer category, meaning that it breaks down large problems into smaller, more easily solvable problems. 
 * 
 * The algorithm looks for a match by comparing the middle item of a collection. 
 * If a match occurs, then the index of the item is returned. 
 * If the middle item is greater than the item, then the middle item of the subarray to the left is compared. 
 * Otherwise, the middle item of the subarray to the right is compared. 
 * This process repeats on subarrays until the size of the subarray reduces to zero. 
 * 
 * Basically, the list is divided into two halves and the search continues in the half where the element has a possibility of being located. This is why the algorithm requires a sorted list. 
 *
 * Let's take a sample sorted array [2, 5, 16, 18, 24, 42] and search for the element 24. 
 * Step 1: We take the middle most item (18) and compare it to 24. We could have taken 16 as the middle-most element, so its up to you to decide how to choose it. Usually you divide the number of elements in the list by 2 and take the result as the index for the middle element. 
 * Step 2: As 18 < 24, we divide the array into two parts and continue working with the subarray to the right: [24, 42] 
 * Step 3: The same process is repeated, and as 42 > 24, we consider the left subarray: [24], which is the match! 
 * 
 * @author d_scryll
 *
 */
public class LinearBinarySearch {
	/**
	 * 
	 * Binary Search is searching the sorted array by repeatedly dividing the search interval in half. 
	 * We can use recursion to implement the algorithm. During each iteration, we take the middle element, compare it with the searched value, then take the corresponding half and repeat the process. 
	 * Our function will search for the value x in the array arr:  
	 * 
	 * @param arr [3, 4, 23, 42, 77, 100]
	 * @param l	first index of array or some index from were you wont to start
	 * @param r	the length of array
	 * @param x	searching value
	 * @return return -1, if the element is not found. 
	 */
	 public static int binarySearch(int arr[], int l, int r, int x) {
	        if (r >= l) {
	            int mid = l + (r - l) / 2;
	            if (arr[mid] == x)
	                return mid;
	            if (arr[mid] > x)
	                return binarySearch(arr, l, mid - 1, x);
	            else
	                return binarySearch(arr, mid + 1, r, x);
	        }
	        return -1;
	    }
	 
	 /**
	  * For testing
	  * 
	  */
	    public static void main(String[] args) {
	        int[] arr = {3, 4, 23, 42, 77, 100};
	        int x = 1;
	        System.out.print(binarySearch(arr, 0, arr.length - 1, x));
	    }
}
