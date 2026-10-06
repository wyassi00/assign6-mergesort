package mergesort;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {11,43,87,27,54,8,32,71,44,12};
		
		showArray(array1);
		mergeSort(array1);
		showArray(array1);
		
	}
	
	public static void showArray(int[] theArray) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<theArray.length;index++) {
			if(index!=0) {
				System.out.printf(", ");
			}
			System.out.printf("%d",theArray[index]);
		}
		System.out.printf("]\n");
	}
	

	
	private static void mergeSort(int[] theArray, int left, int right) {
		//**************************************************************
		//*  Recursive Merge Sort                                      *
		//*------------------------------------------------------------*
		//*  1. Divide or partition the array section into 2 halves.   *
		//*  2. Create a subArray for each partition (half)            *
		//*  3. Merge the two subArrays to create one sorted array     *
		//*  4. Replace the original array section with the merged     *
		//*     array.                                                 *
		//**************************************************************
		if(left < right) {
			int middle = (left + right) / 2;
			mergeSort(theArray, left, middle);
			mergeSort(theArray, middle + 1, right);
			
			int[] temp = new int[right - left + 1];
			
			int i = left; 
			int j = middle + 1;
			int k = 0;
			
			while(i <= middle && j <= right) {
				if(theArray[i] < theArray[j]) {
					temp[k] = theArray[i];
					i++;
				}
				else {
					temp[k] = theArray[j];
					j++;
				}
				k++;
			}
			while(i <= middle) {
				temp[k] = theArray[i];
				i++;
				k++;
			}
			while(j <= right) {
				temp[k] = theArray[j];
				j++;
				k++;
			}
			for(int x = 0; x < temp.length; x++) {
				theArray[left + x] = temp[x];
			}
		}
	}
	
	public static void mergeSort(int[] array) {
		//**********************************************
		//*  Class Wrapper for the recursive mergeSort *
		//**********************************************
		mergeSort(array,0,array.length-1);
	}
}
