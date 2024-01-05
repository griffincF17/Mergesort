import java.util.Random;

public class Mergesort
{
    private static void Merge(int[] a, int start, int mid, int end){
	//Index variables
	int i;
	int j;

	//Variables to hold the left and right subarray sizes
	int sz1 = mid + 1 - start;
	int sz2 = end - mid;

	int[] left = new int[sz1];
	int[] right = new int[sz2];

	//Put 1st half of a into the left subarray
	for(i = 0; i < sz1; i++){
	    left[i] = a[start + i];
	}

	//Put 2nd half of a into the right subarray
	for(j = 0; j < sz2; j++){
	    right[j] = a[mid + 1 + j];
	}

	i = 0;
	j = 0;

	//Index to combine the left and right subarrays back into a
	int combinedIndex = start;

	//Iterate through the left and right subarrays until either
	//subarray has all of its elements in a
	while(i < sz1 && j < sz2){
	    if(left[i] <= right[j]){
	        a[combinedIndex] = left[i];
		i++;
	    }
	    else{
		a[combinedIndex] = right[j];
		j++;
	    }
	    combinedIndex++;
	}

	//Run through each subarray to ensure all elements in both
	//subarrays have been put in their correct position in a
	while(i < sz1){
	    a[combinedIndex] = left[i];
	    i++;
	    combinedIndex++;
	}

	while(j < sz2){
	    a[combinedIndex] = right[j];
	    j++;
	    combinedIndex++;
	}
    }

    public static void MSort(int[] a, int start, int end){
	if(start < end){
	    int mid = start + (end - start) / 2;
	    MSort(a, start, mid);
	    MSort(a, mid+1, end);
	    Merge(a, start, mid, end);
	}
    }


    public static void main(String[] args){
	Random r = new Random();
	int[] arr = new int[10];

	//Each element in arr will be a number
	//randomly chosen between 0 and 99
	for(int i = 0; i < 10; i++){
	    arr[i] = r.nextInt(100);
	}

	//Prints the array before sorting
	System.out.print("Array before mergesort: ");

	for(int n: arr){
	    System.out.print(n + " ");
	}

	MSort(arr, 0, arr.length-1);

	//Prints the array after sorting
	System.out.print("\nArray after mergesort: ");

	for(int n: arr){
	    System.out.print(n + " ");
	}
	System.out.println();
    }
}
