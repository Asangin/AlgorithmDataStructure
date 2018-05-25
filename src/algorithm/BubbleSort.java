package algorithm;

/**
 * Bubble Sort is an algorithm which is used to sort a list of elements, for example elements in an array. 
 * The algorithm compares two adjacent elements and then swaps them if they are not in order. 
 * The process is repeated until no more swapping is needed. 
 *
 * For example: 
 * Let's take the following array: [3, 1, 5, 2] 
 * Step 1: [1, 3, 5, 2] - the first two elements are compared and swapped. 
 * Step 2: [1, 3, 5, 2] - the next pair is compared and not swapped, as they are in order. 
 * Step 3: [1, 3, 2, 5] - the last two elements are swapped. 
 * 
 * This was the first iteration over the array. Now we need to start the second iteration: 
 * Step 1: [1, 3, 2, 5] 
 * Step 2: [1, 2, 3, 5] 
 * Step 3: [1, 2, 3, 5] 
 *
 * The third iteration will not swap any elements, meaning that the list is sorted! 
 * 
 * The main advantage of Bubble Sort is the simplicity of the algorithm. Also, it does not require any additional storage space, as it operates in-place. 
 * In terms of complexity, bubble sort is considered to be not optimal, as it required multiple iterations over the array. In the worst scenario, where all elements need to be swapped, it will require (n-1)+(n-2)+(n-3)+...+3+2+1 = n(n-1)/2 swaps (n is the number of elements).
 *  
 * The algorithm is called Bubble Sort, because with each iteration the smallest element in the list bubbles up to the top, just like a water bubble rises up to the water surface.
 *  
 * @author Skryl using (SoloLearn material)
 *
 */

public class BubbleSort {
	
		/**
		 *   takes an array of numbers
		 * 
		 * @param arr for instance [5, 2, 42, 6, 1, 3, 2]
		 */
	    public static void bubbleSort(int[] arr) {
	        boolean swapped = true;
	        for(int i=0; i<arr.length-1; i++) {
	            swapped = false;
	            for(int j=0; j<arr.length-i-1; j++) {
	                if(arr[j] > arr[j+1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                    swapped = true;
	                }
	            }
	            if(swapped == false)
	                break;
	        }
	    }
	    /**
	     *  takes an array of numbers
	     * 
	     * @param arr for instance [1, 2, 2, 3, 5, 6, 42]
	     */
	    public static void printArray(int[] arr) {
	        for(int i=0; i<arr.length; i++) {
	            System.out.print(arr[i] + " ");
	        }
	    }

	    /**
	     * The main method is implemented for testing the sorting, it contains an array of numbers, a sorting method, and the output of the sorted array
	     * 
	     */
	    public static void main(String[] args) {
	        int[] arr = {5, 2, 42, 6, 1, 3, 2};
	        bubbleSort(arr);
	        printArray(arr);
	    }
	
}
