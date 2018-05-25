package algorithm;
/**
 * Merge Sort belongs to the category of Divide and Conquer algorithms. 
 * These algorithms operate by breaking down large problems into smaller, more easily solvable problems. 
 * The idea of the merge sort algorithm is to divide the array in half over and over again until each piece is only one item long. Then those items are put back together (merged) in sort-order. 
 *
 * Let's have a look at an example: 
 * We start by dividing the array: 
 * [31, 4, 88, 1, 4, 2, 42] 
 * [31, 4, 88, 1]  [4, 2, 42] //divided into 2 parts 
 * [31, 4]  [88, 1]  [4, 2]  [42] //divided into 4 parts 
 * [31]  [4]  [88]  [1]  [4]  [2]  [42] //single items 
 * 
 * Now we need to merge them back together in sort-order: 
 * First we merge single items into pairs. Each pair is merged in sort-order: 
 * [4, 31]  [1, 88]  [2, 4]  [42] 
 * Next we merge the pairs, again in sort order: 
 * [1, 4, 31, 88]  [2, 4, 42] 
 * And then we merge the final two groups: 
 * [1, 2, 4, 4, 31, 42, 88] 
 *
 * Now the array is sorted! The idea behind the algorithm is that smaller parts are easier to sort. 
 * The merge operation is the most important part of the algorithm. 
 * 
 * 
 * 
 * Merge Sort is useful for sorting linked lists, as the merge operations can be implemented without extra space for linked lists. 
 * For arrays, the algorithm needs extra temporary storage space for each half during each iteration.
 *
 *
 * Merge Sort in Java java 
 * 
 * Merge Sort is dividing the array in half over and over again until each piece is only one item long. Then those items are put back together (merged) in sort-order. 
 * 
 * We will need a Merge function, to merge the two halves into a sorted data. 
 * Let's implement the algorithm using recursion:
 * @author Skryl (using SoloLearn material)
 *
 */
public class MergeSort {
	/**
	 * 
	 * @param arr
	 * @param l
	 * @param m
	 * @param r
	 */
	static void merge(int arr[], int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
     
        int L[] = new int [n1];
        int R[] = new int [n2];
     
        for(int i=0; i<n1; i++)
            L[i] = arr[l+i];
        for(int j=0; j<n2; j++)
            R[j] = arr[m+1+j];
     
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	/**
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 */
    static void MergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            MergeSort(arr, l, m);
            MergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 54, 63, 6, 420};
     
        MergeSort(arr, 0, arr.length-1);
     
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
    }
}
