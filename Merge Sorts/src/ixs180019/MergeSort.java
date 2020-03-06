package ixs180019; /** Sample starter code for ixs180019.SP3.
 *  @author rbk
 */
/*55 36 31*/
import java.util.Random;
import java.util.Scanner;

/**
 * Program implements a Merge Sort
 * It consists of following methods: offer(), poll(), peek(), size(), isEmpty(), clear(), toArray(), printQ()
 * @aurthor Ishan Suketu Shah(ixs180019)
 * @author Ayesha Gurnani (ang170003)
 * @param
 * */

public class MergeSort {
    public static Random random = new Random();
    public static int numTrials = 50;
	public static int threshold = 25;
    public static void main(String[] args) {
	int n = 64000000;  int choice = 1 + random.nextInt(4);
	if(args.length > 0) { n = Integer.parseInt(args[0]); }
	if(args.length > 1) { choice = Integer.parseInt(args[1]); }
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
	    	arr[i] = i;
	}

	Timer timer = new Timer();
    System.out.println("Which merge sort?");
    Scanner sc = new Scanner(System.in);

		choice = sc.nextInt();
		switch (choice) {
			case 1: // Calls merge sort(take 2)
				for (int i = 0; i < numTrials; i++) {
					Shuffle.shuffle(arr);
					mergeSort1(arr);
				}
				break;
			case 2: // Calls merge sort(take 3)
				for (int i = 0; i < numTrials; i++) {
					Shuffle.shuffle(arr);
					mergeSort2(arr);
				}
				break;
			case 3: // Calls merge sort(take 4)
				for (int i = 0; i < numTrials; i++) {
					Shuffle.shuffle(arr);
					mergeSort3(arr);
				}
				break;
			case 4: // Calls merge sort(take 6)
				for (int i = 0; i < numTrials; i++) {
					Shuffle.shuffle(arr);
					mergeSort4(arr);
				}
				break;

			/*case 5:
				Shuffle.printArray(arr,"Before shuffle");
				Shuffle.shuffle(arr);
				Shuffle.printArray(arr,"Before sort");
				*//*insertionSort(arr,0,arr.length-1);*//*
				mergeSort4(arr);
				Shuffle.printArray(arr,"After Sort");
				break;*/
		}
		timer.end();
		timer.scale(numTrials);


	System.out.println("Choice: " + choice + "\n" + timer);
    }

	/***
	 * Method: insertionSort()
	 * Sorts all the elements using insertion sort
	 * @param: arr: array to be sorted; p: start of the array; q: end of the array
	 * @return: null
	 */
    public static void insertionSort(int[] arr, int p ,int r) {
		int key,j;
    	for (int i= p+1; i <= r && i<arr.length; i++) {
			key = arr[i];
			j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= p && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}

    }

	/***
	 * Method: merge1()
	 * Merges two array
	 * @param: arr: first array ; B: second array ;p: start of the array; q: middle of the array; r: end of the array
	 * @return: null
	 */
    public static void merge1(int[] arr, int[] B, int p, int q, int r){
    	System.arraycopy(arr, p, B, p, r-p+1);
    	int i = p, k = p, j = q+1;
    	while(i<=q && j<=r){
    		if (B[i] <= B[j]){
    			arr[k++] = B[i++];
    		}
    		else{
				arr[k++] = B[j++];
			}
		}
    	while (i<=q){arr[k++] = B[i++];}
    	while (j<=r){arr[k++] = B[j++];}

	}

	/***
	 * Method: merge2()
	 * Merges two array without using arraycopy
	 * @param: arr: first array ; B: second array ;p: start of the array; q: middle of the array; r: end of the array
	 * @return: null
	 */
	public static void merge2(int[] arr, int[] B, int p, int q, int r){

		int i = p, k = p, j = q+1;
		while(i<=q && j<=r){
			if (B[i] <= B[j]){
				arr[k++] = B[i++];
			}
			else{
				arr[k++] = B[j++];
			}
		}
		while (i<=q){arr[k++] = B[i++];}
		while (j<=r){arr[k++] = B[j++];}

	}

	/***
	 * Method: merge1()
	 * Merges two array without using arraycopy
	 * @param: arr: first array ; B: second array ;p: start of the array; q: middle of the array; r: end of the array
	 * @return: null
	 */
	public static void merge4(int []A, int []B, int p, int q, int r){
		int i = p;
		int k = p;
		int j = q+1;

		while(i <= q && j <= r){
			if(B[i] <= B[j]){
				A[k++] = B[i++];
			}
			else{
				A[k++] = B[j++];
			}
		}
		while (i <= q){
			A[k++] = B[i++];
		}
		while(j <= r){
			A[k++] = B[j++];
		}
	}

	/***
	 * Method: mergeSort1()
	 * Merge sort(take 2) algorithm
	 * @param: arr: array to be sorted
	 * @return: null
	 */
	public static void mergeSort1(int[] arr) {
		int len = arr.length;
		int [] B = new int[len];
		mergeSort1(arr,B,0,len-1);
	}

	/***
	 * Method: mergeSort1(arr,B,p,r)
	 * Merge sort(take 2) algorithm
	 * @param: arr: array to be sorted ; B:second empty array ; p: start of array; q: end of array
	 * @return: null
	 */
	public static void mergeSort1(int[] arr, int[] B, int p, int r) {
		if (p<r){
			int q =  p + (r-p)/2;
			mergeSort1(arr, B, p, q);
			mergeSort1(arr, B,q+1, r);
			merge1(arr,B,p,q,r);
		}
	}

	/***
	 * Method: mergeSort2()
	 * Merge sort(take 3) algorithm
	 * @param: arr: array to be sorted
	 * @return: null
	 */
	public static void mergeSort2(int[] arr) {
		int len = arr.length;
		int [] B = new int[len];
		System.arraycopy(arr,0, B , 0, len-1);
		mergeSort2(arr,B,0,len-1);
	}

	/***
	 * Method: mergeSort1(arr,B,p,r)
	 * Merge sort(take 3) algorithm
	 * @param: arr: array to be sorted ; B:second empty array ; p: start of array; q: end of array
	 * @return: null
	 */
	public static void mergeSort2(int[] arr, int[] B, int p, int r) {

		if (p<r){
			int q =  p + (r-p)/2;
			mergeSort2(B, arr , p , q);
			mergeSort2(B, arr ,q+1 , r);
			merge2(arr,B,p,q,r);
		}
	}

	/***
	 * Method: mergeSort3()
	 * Merge sort(take 4) algorithm
	 * @param: arr: array to be sorted
	 * @return: null
	 */
	public static void mergeSort3(int[] arr) {
		int len = arr.length;
		int [] B = new int[len];
		System.arraycopy(arr,0, B , 0, len-1);
		mergeSort3(arr,B,0,len-1);
	}

	/***
	 * Method: mergeSort1(arr,B,p,r)
	 * Merge sort(take 4) algorithm using threshold
	 * @param: arr: array to be sorted ; B:second empty array ; p: start of array; q: end of array
	 * @return: null
	 */
	public static void mergeSort3(int[] arr, int[] B, int p, int r) {

		if ((r-p+1) < threshold){
			System.out.println("Inside threshold check");
			insertionSort(arr,p,r);
		}
		if (p<r){
			int q =  p + (r-p)/2;
			mergeSort3(B, arr , p , q);
			mergeSort3(B, arr ,q+1 , r);
			merge2(arr,B,p,q,r);
		}
	}

	/***
	 * Method: mergeSort4()
	 * Merge sort(take 6) using iteration and insertion sort
	 * @param: arr: array to be sorted
	 * @return: null
	 */
	public static void mergeSort4(int [] arr){
		int[] B = new int[arr.length];
		int[] inp = arr;
		int[] t;
		int n = arr.length;

		for (int j = 0; j < n; j = j + threshold) {
			insertionSort(arr, j, Math.min(j + threshold - 1, n - 1));
		}
		for (int i = threshold; i < n; i = 2 * i) {
			for (int j = 0; j < n; j = j + 2 * i) {
				if (j + i - 1 >= n) {
					System.arraycopy(inp, j, B, j, n - j);
				} else {
					merge4(B, inp, j, j + i - 1, Math.min(j + 2 * i - 1, n - 1));
				}
			}
			t = inp;
			inp = B;
			B = t;
		}
		if (arr != inp)
			System.arraycopy(inp, 0, arr, 0, n);

	}



	/** Timer class for roughly calculating running time of programs
     *  @author rbk
     *  Usage:  Timer timer = new Timer();
     *          timer.start();
     *          timer.end();
     *          System.out.println(timer);  // output statistics
     */

    public static class Timer {
        long startTime, endTime, elapsedTime, memAvailable, memUsed;
        boolean ready;

        public Timer() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public void start() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public Timer end() {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime-startTime;
            memAvailable = Runtime.getRuntime().totalMemory();
            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
            ready = true;
            return this;
        }

        public long duration() { if(!ready) { end(); }  return elapsedTime; }

        public long memory()   { if(!ready) { end(); }  return memUsed; }

	public void scale(int num) { elapsedTime /= num; }
	
        public String toString() {
            if(!ready) { end(); }
            return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed/1048576) + " MB / " + (memAvailable/1048576) + " MB.";
        }
    }
    
    /** @author rbk : based on algorithm described in a book
     */


    /* Shuffle the elements of an array arr[from..to] randomly */
    public static class Shuffle {

		public static void shuffle(int[] arr) {
			shuffle(arr, 0, arr.length-1);
		}

		public static<T> void shuffle(T[] arr) {
			shuffle(arr, 0, arr.length-1);
		}

		public static void shuffle(int[] arr, int from, int to) {
			int n = to - from  + 1;
			for(int i=1; i<n; i++) {
				int j = random.nextInt(i);
				swap(arr, i+from, j+from);
			}
		}

	public static<T> void shuffle(T[] arr, int from, int to) {
			int n = to - from  + 1;
			Random random = new Random();
			for(int i=1; i<n; i++) {
				int j = random.nextInt(i);
				swap(arr, i+from, j+from);
			}
	}

	static void swap(int[] arr, int x, int y) {
	    int tmp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = tmp;
	}
	
	static<T> void swap(T[] arr, int x, int y) {
	    T tmp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = tmp;
	}

	public static void printArray(int[] arr, String message) {
	    printArray(arr, 0, arr.length-1, message);
	}

	public static void printArray(int[] arr, int from, int to, String message) {
	    System.out.print(message);
	    for(int i=from; i<=to; i++) {
		System.out.print(" " + arr[i]);
	    }
	    System.out.println();
	}
    }
}

