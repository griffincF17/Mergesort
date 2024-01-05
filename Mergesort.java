import java.util.Random;

public class Mergesort
{
    private static void Merge(int[] a, int start, int mid, int end){
	int i;
	int j;

	int sz1 = mid + 1 - start;
	int sz2 = end - mid;

	int[] left = new int[sz1];
	int[] right = new int[sz2];

	for(i = 0; i < sz1; i++){
	    left[i] = a[start + i];
	}

	for(j = 0; j < sz2; j++){
	    right[j] = a[mid + 1 + j];
	}

	i = 0;
	j = 0;

	int combinedIndex = start;

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

	for(int i = 0; i < 10; i++){
	    arr[i] = r.nextInt(100);
	}

	System.out.print("Array before mergesort: ");

	for(int n: arr){
	    System.out.print(n + " ");
	}

	MSort(arr, 0, arr.length-1);

	System.out.print("\nArray after mergesort: ");

	for(int n: arr){
	    System.out.print(n + " ");
	}
	System.out.println();
    }
}
