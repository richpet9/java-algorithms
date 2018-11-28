// Merge Sort
// Richard Petrosino 
// 10/24/18

public class MergeSort {
	private static int mergeComparisons = 0;
	
	public static int sort(int[] intArray, int left, int right) {
		//Check the basis case
		if(left < right) {
			//If this is the first call, set mergeComparisons back to 0
			if(right == intArray.length - 1) {
				mergeComparisons = 0;
			}
			
			//Assign mid
			int mid = (left + right) / 2;
			
			sort(intArray, left, mid);
			sort(intArray, mid + 1, right);
			
			merge(intArray, left, mid, right);
		}
		
		return mergeComparisons;
	}
		
	private static void merge(int[] arr, int left, int mid, int right) {
		//Input: unsorted int array
		//Output: the number of comparisons when sorting
		//Base case: if the array is length 1
		
		//Create the left array, length of the middle index, minus the left, plus one for inclusion
		int[] leftArr = new int[mid - left + 1];
		//Create the right array
		int[] rightArr = new int[right - mid];		
		
		for(int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[left + i];
		}
		for(int j = 0; j < rightArr.length; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}
		
		//Create some variables to track where we are
		int index = left; 	//I LOOKED THIS PART UP AND STILL DO NOT UNDERSTAND THIS
		int li = 0; //The left array's current index
		int ri = 0; //The right array's current index
		
		//While the left and rightIndex are than total
		//NOTE: there will be a remainder in one of the arrays
		while(li < leftArr.length && ri < rightArr.length) {
			//Check if the left array val is greater than right
			if(leftArr[li] <= rightArr[ri]) {
				arr[index] = leftArr[li];	//Assign
				li++;	//Increment this array's current index
			} else {
				arr[index] = rightArr[ri];	//Assign
				ri++;	//Increment this array's current index
			}
			
			mergeComparisons++;
			index++; //Increment the current index of the resulting array
		}
		
		//The next two while loops do the same thing as above, except for any remaining 
		//values. As such, no comparisons are made. Things are only moved
		while(li < leftArr.length) {
			arr[index] = leftArr[li];
			li++;
			index++;	
		}
		while(ri < rightArr.length) {
			arr[index] = rightArr[ri];
			ri++;
			index++;
		}
	}
	
	public static void printArray(int[] intArray){
		//Preconditions
		//	Input: unsorted integer array	
		//	Assumptions: array is full
		//Postconditions
		//	Output: none
		//	Actions: array is displayed on screen
		
		System.out.print("Array==> ");
		for(int i = 0; i < intArray.length; i++){
			System.out.print(intArray[i] + " ");
		} // end for
		
		System.out.println(" ");
		
	} // end printArray
	
	public static int[] randomIntArray(int n, double range){
		//Preconditions
		//	Input: size of array(n), range of integers (0 to range)
		//	Assumptions: none
		//Postconditoins
		//	Output: array of random integers 0 to floor(range) 
		//	Actions: none
		
		int[] intArray = new int[n];
		
		for(int i = 0; i < n; i++){
			intArray[i] = (int)(Math.random() * range);
		} // end for
		
		return intArray;
		
	} // end randomIntArray
	
	public static int[] copyArray(int[] intArray){
		//Preconditions
		//	Input: integer array
		//	Assumptions: array is full
		//Postconditions
		//	Output: array of random integers 0 to floor(range) 
		//	Actions: none
		
		int[] copyArray = new int[intArray.length];
		
		for(int i = 0; i < intArray.length; i++){
			copyArray[i] = intArray[i];
		} // end for
		
		return copyArray;
		
	} // end copyArray
		

} // end SortMethods