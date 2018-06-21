package sorting;

import java.io.*;
import java.util.*; // Program prompts for the input file name

/**
 * This program sorts files using different sorting algorithms, including
 * Heapsort and Shellsort. It reads the data and prints it out in sorted
 * order. The iterative implementations of Heapsort and Shellsort are 
 * used.
 * 
 * @version 1.0 2017-08-02
 * @author Addison Sears-Collins
 */

public class SortingDriver {

	/**
     *  Main entry point for the program.
     */
	public static void main(String[] args) {
		
		BufferedReader input = null;
		BufferedWriter output = null;
		String inputFileName = null;
		String outputFileName = null;
		int v = 999999; // Initialize the values for our array
		int size = 0; // Initializes the size variable
		long startTime, endTime; // Execution time of each sorting algorithm
		
		// Prompt for the file input and output name
		Scanner in = new Scanner(System.in);
		
		// Provide instructions to the user on what input the program
		// accepts.
		System.out.println("FILE SORTER");
		System.out.println("");
		System.out.println("This program sorts files using different " + 
			"sorting algorithms. It reads the data and ");
		System.out.print("prints it out in sorted order. ");
		System.out.println("Data must be formattted so that each number " +
				"is on a ");
		System.out.print("separate line with no leading blanks. ");
		System.out.println("See below for the input format.");
		System.out.println("");
		
		// Show the user some sample input
		System.out.println("3");
		System.out.println("2");		
		System.out.println("4");	
		System.out.println("6");
		System.out.println("1");		
		System.out.println("");
				
		// Prompt for the file input and output name.
		System.out.println("Enter your file input " +
			"name to begin (e.g. input.txt" +
			" or C:\\Users\\Desktop\\input.txt):");
		inputFileName = in.nextLine();
		System.out.println("Now enter your file output " +
			"name (e.g. output.txt or" +
			" C:\\Users\\Desktop\\output.txt):");
		outputFileName = in.nextLine();		
		
		System.out.println("");
		System.out.println("#-----------------------------------#");
		System.out.println("Launching File Sorter. Please wait...");
		System.out.println("#-----------------------------------#");
		
		// Close the Scanner
		in.close();
		
		// Open the files that will be used for input and output	
        try {        
        	input = new BufferedReader(new FileReader(inputFileName));
            output = new BufferedWriter(new FileWriter(outputFileName));            
        } catch (Exception ioe) {
        	System.out.println("");
        	System.out.println("Oops! The file cannot be found. Please " +
        			"try again.");
            System.err.println(ioe.toString());
            return;            
        }      
        
        // Read in the data and sort it
        try {        	
        	/*
        	 * Creates the introductory information for the results of the 
        	 * sort
        	 */
        	output.write("SORTING RESULTS");
        	output.newLine();
        	output.newLine();
        	output.write("Author: Addison Sears-Collins");
        	output.newLine();
        	output.write("----------------");
        	output.newLine();        	
        	
           	// Temporary storage for our integer values
        	StringBuilder sb = new StringBuilder();   
        	
        	Scanner scan = new Scanner(input);        	
           	size = 0; // Initialize size of the array to 0
        	
           	try {
           		/*
           		 * Count the number of integers in the input file in order
           		 * to determine the exact size of the array that is
           		 * needed. Throw an error if we encounter non-integer
           		 * values in the file. Build our StringBuilder with 
           		 * integer values.
           		 */
           		while (scan.hasNextInt()) {
           			v = scan.nextInt();
           			sb.append(v);
           			sb.append(" ");
           			size++;
           		}      
            // Error if file contains non-integer values
    		} catch (Exception e) {
    			System.out.println("");
            	System.out.println("Oops! This file has non-integer values."
            			+ " Please remove the");
            	System.out.println("non-integer values and try again."); 
            	System.exit(0);
        	}      	
           	scan.close();             	
      	
    		// Convert StringBuilder into a string array
			String[] x = sb.toString().split("\\s+");  
          	
			// Convert string array into an integer array
			int[] myList = new int[size];
			for (int i = 0; i < myList.length; i++) {
				myList[i] = Integer.parseInt(x[i]);
			}			
			
	       	// Useful information to feed to the console
           	System.out.println("There are " + size + 
           			" integers in this file.");
           	
           	// Set a size limit on the file of 29000 integers
           	if (size > 29000) {
           		System.out.println("");
           		System.out.println("ERROR: This program cannot handle data"
           				+ " sets larger than 29000 integers.");
           		System.exit(0);           		
           	}
           	
           	// Invalid file message if blank file or non-integers
           	if (size == 0) {
           		System.out.println("Invalid file format. Please make sure"
           				+ " that the file has only integers");
           		System.out.println("and no blank space.");
           		System.exit(0);           		
           	}     
           	
			// Echo the input to the output file
           	output.newLine();
           	output.write("-----------------------");
           	output.newLine();
           	output.write("Original Input");
           	output.newLine();
           	output.write("-----------------------");
      		output.newLine();
			for (int i = 0; i < myList.length; i++) {
				output.write("" + myList[i]);
				output.newLine();
			}	
           	
           	/* Shellsort Knuth */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Shellsort Knuth in progress..."); 
           	ShellSortKnuth ob1 = new ShellSortKnuth();
           	int[] shsrtkArray1 = new int[size];
           	int[] shsrtkArray2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		shsrtkArray1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	shsrtkArray2 = ob1.sort(shsrtkArray1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long shsrtkRuntime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("-----------------------");
           	output.newLine();
           	output.write("Shellsort Knuth Sorted List");
           	output.newLine();
           	output.write("-----------------------");
      		output.newLine();
			for (int i = 0; i < shsrtkArray2.length; i++) {
				output.write("" + shsrtkArray2[i]);
				output.newLine();
			}	
			
			/* End Shellsort Knuth */           	
	
           	/* Shellsort 2 */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Shellsort 2 in progress..."); 
           	ShellSort2 ob2 = new ShellSort2();
           	int[] shsrt2Array1 = new int[size];
           	int[] shsrt2Array2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		shsrt2Array1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	shsrt2Array2 = ob2.sort(shsrt2Array1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long shsrt2Runtime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("-----------------------");
           	output.newLine();
           	output.write("Shellsort 2 Sorted List");
           	output.newLine();
           	output.write("-----------------------");
      		output.newLine();
			for (int i = 0; i < shsrt2Array2.length; i++) {
				output.write("" + shsrt2Array2[i]);
				output.newLine();
			}	
			
			/* End Shellsort 2 */
           				
           	/* Shellsort 3 */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Shellsort 3 in progress..."); 
           	ShellSort3 ob3 = new ShellSort3();
           	int[] shsrt3Array1 = new int[size];
           	int[] shsrt3Array2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		shsrt3Array1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	shsrt3Array2 = ob3.sort(shsrt3Array1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long shsrt3Runtime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("-----------------------");
           	output.newLine();
           	output.write("Shellsort 3 Sorted List");
           	output.newLine();
           	output.write("-----------------------");
      	    output.newLine();
			for (int i = 0; i < shsrt3Array2.length; i++) {
				output.write("" + shsrt3Array2[i]);
				output.newLine();
			}	
			
			/* End Shellsort 3 */           	
			
           	/* Shellsort 4 */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Shellsort 4 in progress..."); 
           	ShellSort4 ob4 = new ShellSort4();
           	int[] shsrt4Array1 = new int[size];
           	int[] shsrt4Array2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		shsrt4Array1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	shsrt4Array2 = ob4.sort(shsrt4Array1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long shsrt4Runtime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("-----------------------");
           	output.newLine();
           	output.write("Shellsort 4 Sorted List");
           	output.newLine();
           	output.write("-----------------------");
          	output.newLine();
			for (int i = 0; i < shsrt4Array2.length; i++) {
				output.write("" + shsrt4Array2[i]);
				output.newLine();
			}	
			
			/* End Shellsort 4 */          	

			
           	/* Shellsort 5 */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Shellsort 5 in progress..."); 
           	ShellSort5 ob5 = new ShellSort5();
           	int[] shsrt5Array1 = new int[size];
           	int[] shsrt5Array2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		shsrt5Array1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	shsrt5Array2 = ob5.sort(shsrt5Array1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long shsrt5Runtime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("-----------------------");
           	output.newLine();
           	output.write("Shellsort 5 Sorted List");
           	output.newLine();
           	output.write("-----------------------");
           	output.newLine();
			for (int i = 0; i < shsrt5Array2.length; i++) {
				output.write("" + shsrt5Array2[i]);
				output.newLine();
			}	
			
			/* End Shellsort 5 */           	
		
           	/* Heapsort */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Heapsort in progress..."); 
           	HeapSort ob6 = new HeapSort();
           	int[] heapArray1 = new int[size];
           	int[] heapArray2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		heapArray1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	heapArray2 = ob6.sort(heapArray1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long heapRuntime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("---------------");
           	output.newLine();
           	output.write("Heapsorted List");
           	output.newLine();
           	output.write("---------------");
           	output.newLine();
			for (int i = 0; i < heapArray2.length; i++) {
				output.write("" + heapArray2[i]);
				output.newLine();
			}	
			
			/* End Heapsort */			
	
			/* Straight Insertion Sort */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Straight Insertion Sort in progress..."); 
           	StraightInsertionSort ob7 = new StraightInsertionSort();
           	int[] insArray1 = new int[size];
           	int[] insArray2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		insArray1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	insArray2 = ob7.sort(insArray1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long insRuntime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("------------------------------");
           	output.newLine();
           	output.write("Straight Insertion Sorted List");
           	output.newLine();
           	output.write("------------------------------");
           	output.newLine();
			for (int i = 0; i < insArray2.length; i++) {
				output.write("" + insArray2[i]);
				output.newLine();
			}	
			
			/* End Straight Insertion Sort */           	
	
			/* Simple Selection Sort */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Simple Selection Sort in progress..."); 
           	SimpleSelectionSort ob8 = new SimpleSelectionSort();
           	int[] ssArray1 = new int[size];
           	int[] ssArray2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		ssArray1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	ssArray2 = ob8.sort(ssArray1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long ssRuntime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("----------------------------");
           	output.newLine();
           	output.write("Simple Selection Sorted List");
           	output.newLine();
           	output.write("----------------------------");
           	output.newLine();
			for (int i = 0; i < ssArray2.length; i++) {
				output.write("" + ssArray2[i]);
				output.newLine();
			}	
			
			/* End Simple Selection Sort */			
	
			/* Quicksort */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Quicksort in progress..."); 
           	QuickSort ob9 = new QuickSort();
           	int[] qsArray1 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		qsArray1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	ob9.sort(qsArray1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long qsRuntime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("----------------");
           	output.newLine();
           	output.write("Quicksorted List");
           	output.newLine();
           	output.write("----------------");
           	output.newLine();
			for (int i = 0; i < qsArray1.length; i++) {
				output.write("" + qsArray1[i]);
				output.newLine();
			}	
			
			/* End Quicksort */  	
			                   	
           	/* Bubble Sort */
           	
           	// 	Sort the input data and calculate the execution time.
           	System.out.println("Bubble Sort in progress..."); 
           	BubbleSort ob10 = new BubbleSort();
           	int[] bsrtArray1 = new int[size];
           	int[] bsrtArray2 = new int[size];
           	
           	// Copy the values from the original array into a new
           	// array so that we don't modify myList
           	for (int i = 0; i < size; i++) {
           		bsrtArray1[i] = myList[i];
           	}
           	
           	// Call the clock and then sort
           	startTime = System.nanoTime(); // Start the timer
           	bsrtArray2 = ob10.sort(bsrtArray1); // Sort the data
           	endTime = System.nanoTime(); // Stop the timer
           	
           	// Calculate the runtime in microseconds
           	long bsrtRuntime = (endTime - startTime) / 1000;
           		  	
			// Print the sorted values to the output file
           	output.newLine();
           	output.write("------------------");
           	output.newLine();
           	output.write("Bubble Sorted List");
           	output.newLine();
           	output.write("------------------");
           	output.newLine();
			for (int i = 0; i < bsrtArray2.length; i++) {
				output.write("" + bsrtArray2[i]);
				output.newLine();
			}	
			
			/* End Bubble Sort */
           	
            // Outputs the runtimes of the different sorts
           	output.newLine();
           	output.write("----------------------------------------");
           	output.newLine();
           	output.write("TIME PERFORMANCE COMPARISON");
           	output.newLine();
           	output.write("----------------------------------------");
           	output.newLine();
           	output.write("Input: " + inputFileName);
           	output.newLine();
           	output.write("Output: " + outputFileName);
           	output.newLine();
           	output.newLine();           	
           	
           	// Print the runtime of each sort
           	output.write("Shellsort Knuth: " + shsrtkRuntime + 
           			" microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Shellsort 2: " + shsrt2Runtime + 
           			" microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Shellsort 3: " + shsrt3Runtime + 
           			" microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Shellsort 4: " + shsrt4Runtime + 
           			" microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Shellsort 5: " + shsrt5Runtime + 
           			" microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Heapsort: " + heapRuntime + " microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Straight Insertion Sort: " + insRuntime + 
           			" microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Simple Selection Sort: " + ssRuntime + 
           			" microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Quicksort: " + qsRuntime + " microseconds");
           	output.newLine();
           	output.newLine();
           	output.write("Bubble Sort: " + bsrtRuntime + " microseconds");
           	output.newLine();
           	output.newLine();  
           	           	
    	} catch (IOException e) { 
    		e.printStackTrace();    		
    	}      
		
        // Clean up and return to the operating system.
        try {
            input.close();
        	output.close();
        } catch (Exception x) {
            System.err.println(x.toString());
        }
        
        // Notify the user that the sorting has completed.
		System.out.println("#-----------------------------------#");
        System.out.println("File Sorting is Complete.");
		System.out.println("#-----------------------------------#");
        return;	

	}

}
/**
 *  The class where all the work is done for Shellsort using 
 *  Knuth's sequence. Increments are: 1, 4, 13, 40, 121, 364, 1093, 3280, 
 *  9841, 29524
 */
class ShellSortKnuth {
	
	/**
     *  Constructor
     */
	public ShellSortKnuth(){}	
	
	/**
	 *  The method to sort the array using Shellsort
	 *  @param arr An unsorted array of integers
	 *  @return arr Returns a sorted array of integers 	  
	 */
	public int[] sort(int arr[]) {

		int n = arr.length; // Size of the incoming array
		int[] incrementSet = {1, 4, 13, 40, 121, 364, 1093, 3280, 
				9841, 29524}; 
        int h = 1; // h is the increment
        int passesLeft = 0; // Keeps track of the number of passes remaining
        int currIndex = -1; // Current index in the incrementSet
        
        // Initialize the starting increment h as well as the number of 
        // passes that we need to perform.     
        // For the starting increment, find the first value larger than the 
        // file. Move back two increments to find the starting increment.
        if (n >= incrementSet[0]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[1]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[2]) {
        	currIndex = 1;
        	h = incrementSet[currIndex];
        	passesLeft = 2;      	
        }
        if (n >= incrementSet[3]) {
        	currIndex = 2;
        	h = incrementSet[currIndex];
        	passesLeft = 3;      	
        }
        if (n >= incrementSet[4]) {
        	currIndex = 3;
        	h = incrementSet[currIndex];
        	passesLeft = 4;      	
        }
        if (n >= incrementSet[5]) {
        	currIndex = 4;
        	h = incrementSet[currIndex];
        	passesLeft = 5;      	
        }
        if (n >= incrementSet[6]) {
        	currIndex = 5;
        	h = incrementSet[currIndex];
        	passesLeft = 6;      	
        }
        if (n >= incrementSet[7]) {
        	currIndex = 6;
        	h = incrementSet[currIndex];
        	passesLeft = 7;      	
        }
        if (n >= incrementSet[8]) {
        	currIndex = 7;
        	h = incrementSet[currIndex];
        	passesLeft = 8;      	
        }
        if (n >= incrementSet[9]) {
        	currIndex = 8;
        	h = incrementSet[currIndex];
        	passesLeft = 9;      	
        }        

        // As long as we have passes remaining, keep going.
        while (passesLeft > 0) {        
        	
        	// Keep the user informed on the increment sets used on the sort
        	System.out.println("Increment: "+ h); 
        
        	/* 
        	 * Perform the Shellsort
        	 * Title: Java Program to Implement Shell Sort
        	 * Data: 08.03.2017
        	 * Source: 
        	 * http://www.sanfoundry.com/java-program-implement-shell-sort/  
        	 */
        	for (int i = h; i < arr.length; i++) {
        		int j = i;
        		int temp = arr[i];
        		while (j >= h && arr[j - h] > temp) {
        			arr[j] = arr[j - h];
        			j = j - h;
        		}
        		arr[j] = temp;
        	}
        	passesLeft--; // Reduce the number of passes remaining
        	
        	// Decrease the increment h
        	if (passesLeft > 0) {
        		currIndex--;
        		h = incrementSet[currIndex];        		       	
        	}
        }              
        return arr;
    }
}


/**
 *  The class where all the work is done for the second Shellsort
 *  Sequence. Increments are 1, 5, 17, 53, 149, 373, 1123, 3371, 10111, 30341
 */
class ShellSort2 {
	
	/**
     *  Constructor
     */
	public ShellSort2(){}
	
	/**
	 *  The method to sort the array using Shellsort
	 *  @param arr An unsorted array of integers
	 *  @return arr Returns a sorted array of integers 	  
	 */
	public int[] sort(int arr[]) {

		int n = arr.length; // Size of the incoming array
		int[] incrementSet = {1, 5, 17, 53, 149, 373, 1123, 3371, 
				10111, 30341}; 
        int h = 1; // h is the increment
        int passesLeft = 0; // Keeps track of the number of passes remaining
        int currIndex = -1; // Current index in the incrementSet
        
        // Initialize the starting increment h as well as the number of 
        // passes that we need to perform.     
        // For the starting increment, find the first value larger than the 
        // file. Move back two increments to find the starting increment.
        if (n >= incrementSet[0]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[1]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[2]) {
        	currIndex = 1;
        	h = incrementSet[currIndex];
        	passesLeft = 2;      	
        }
        if (n >= incrementSet[3]) {
        	currIndex = 2;
        	h = incrementSet[currIndex];
        	passesLeft = 3;      	
        }
        if (n >= incrementSet[4]) {
        	currIndex = 3;
        	h = incrementSet[currIndex];
        	passesLeft = 4;      	
        }
        if (n >= incrementSet[5]) {
        	currIndex = 4;
        	h = incrementSet[currIndex];
        	passesLeft = 5;      	
        }
        if (n >= incrementSet[6]) {
        	currIndex = 5;
        	h = incrementSet[currIndex];
        	passesLeft = 6;      	
        }
        if (n >= incrementSet[7]) {
        	currIndex = 6;
        	h = incrementSet[currIndex];
        	passesLeft = 7;      	
        }
        if (n >= incrementSet[8]) {
        	currIndex = 7;
        	h = incrementSet[currIndex];
        	passesLeft = 8;      	
        }
        if (n >= incrementSet[9]) {
        	currIndex = 8;
        	h = incrementSet[currIndex];
        	passesLeft = 9;      	
        }        

        // As long as we have passes remaining, keep going.
        while (passesLeft > 0) {        
        	
        	// Keep the user informed on the increment sets used on the sort
        	System.out.println("Increment: "+ h); 
        
        	/* 
        	 * Perform the Shellsort
        	 * Title: Java Program to Implement Shell Sort
        	 * Data: 08.03.2017
        	 * Source: 
        	 * http://www.sanfoundry.com/java-program-implement-shell-sort/  
        	 */
        	for (int i = h; i < arr.length; i++) {
        		int j = i;
        		int temp = arr[i];
        		while (j >= h && arr[j - h] > temp) {
        			arr[j] = arr[j - h];
        			j = j - h;
        		}
        		arr[j] = temp;
        	}
        	passesLeft--; // Reduce the number of passes remaining
        	
        	// Decrease the increment h
        	if (passesLeft > 0) {
        		currIndex--;
        		h = incrementSet[currIndex];        		       	
        	}
        }              
        return arr;
    }
}


/**
 *  The class where all the work is done for the third Shellsort
 *  Sequence. Increments are 1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160
 */
class ShellSort3 {

	/**
     *  Constructor
     */
	public ShellSort3(){}
	
	/**
	 *  The method to sort the array using Shellsort
	 *  @param arr An unsorted array of integers
	 *  @return arr Returns a sorted array of integers 	  
	 */
	public int[] sort(int arr[]) {

		int n = arr.length; // Size of the incoming array
		int[] incrementSet = {1, 10, 30, 60, 120, 360, 1080, 3240, 
				9720, 29160}; 
        int h = 1; // h is the increment
        int passesLeft = 0; // Keeps track of the number of passes remaining
        int currIndex = -1; // Current index in the incrementSet
        
        // Initialize the starting increment h as well as the number of 
        // passes that we need to perform.     
        // For the starting increment, find the first value larger than the 
        // file. Move back two increments to find the starting increment.
        if (n >= incrementSet[0]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[1]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[2]) {
        	currIndex = 1;
        	h = incrementSet[currIndex];
        	passesLeft = 2;      	
        }
        if (n >= incrementSet[3]) {
        	currIndex = 2;
        	h = incrementSet[currIndex];
        	passesLeft = 3;      	
        }
        if (n >= incrementSet[4]) {
        	currIndex = 3;
        	h = incrementSet[currIndex];
        	passesLeft = 4;      	
        }
        if (n >= incrementSet[5]) {
        	currIndex = 4;
        	h = incrementSet[currIndex];
        	passesLeft = 5;      	
        }
        if (n >= incrementSet[6]) {
        	currIndex = 5;
        	h = incrementSet[currIndex];
        	passesLeft = 6;      	
        }
        if (n >= incrementSet[7]) {
        	currIndex = 6;
        	h = incrementSet[currIndex];
        	passesLeft = 7;      	
        }
        if (n >= incrementSet[8]) {
        	currIndex = 7;
        	h = incrementSet[currIndex];
        	passesLeft = 8;      	
        }
        if (n >= incrementSet[9]) {
        	currIndex = 8;
        	h = incrementSet[currIndex];
        	passesLeft = 9;      	
        }        

        // As long as we have passes remaining, keep going.
        while (passesLeft > 0) {        
        	
        	// Keep the user informed on the increment sets used on the sort
        	System.out.println("Increment: "+ h); 
        
        	/* 
        	 * Perform the Shellsort
        	 * Title: Java Program to Implement Shell Sort
        	 * Data: 08.03.2017
        	 * Source: 
        	 * http://www.sanfoundry.com/java-program-implement-shell-sort/  
        	 */
        	for (int i = h; i < arr.length; i++) {
        		int j = i;
        		int temp = arr[i];
        		while (j >= h && arr[j - h] > temp) {
        			arr[j] = arr[j - h];
        			j = j - h;
        		}
        		arr[j] = temp;
        	}
        	passesLeft--; // Reduce the number of passes remaining
        	
        	// Decrease the increment h
        	if (passesLeft > 0) {
        		currIndex--;
        		h = incrementSet[currIndex];        		       	
        	}
        }              
        return arr;
    }
}


/**
 *  The class where all the work is done for the fourth Shellsort
 *  Sequence. Increments are 1, 20, 70, 245, 858, 3001, 10504, 36765, 128679, 
 *  450375.
 */
class ShellSort4 {
	
	/**
     *  Constructor
     */
	public ShellSort4(){}
	
	/**
	 *  The method to sort the array using Shellsort
	 *  @param arr An unsorted array of integers
	 *  @return arr Returns a sorted array of integers 	  
	 */
	public int[] sort(int arr[]) {

		int n = arr.length; // Size of the incoming array
		int[] incrementSet = {1, 20, 70, 245, 858, 3001, 10504, 36765, 
				128679, 450375}; 
        int h = 1; // h is the increment
        int passesLeft = 0; // Keeps track of the number of passes remaining
        int currIndex = -1; // Current index in the incrementSet
        
        // Initialize the starting increment h as well as the number of 
        // passes that we need to perform.     
        // For the starting increment, find the first value larger than the 
        // file. Move back two increments to find the starting increment.
        if (n >= incrementSet[0]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[1]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[2]) {
        	currIndex = 1;
        	h = incrementSet[currIndex];
        	passesLeft = 2;      	
        }
        if (n >= incrementSet[3]) {
        	currIndex = 2;
        	h = incrementSet[currIndex];
        	passesLeft = 3;      	
        }
        if (n >= incrementSet[4]) {
        	currIndex = 3;
        	h = incrementSet[currIndex];
        	passesLeft = 4;      	
        }
        if (n >= incrementSet[5]) {
        	currIndex = 4;
        	h = incrementSet[currIndex];
        	passesLeft = 5;      	
        }
        if (n >= incrementSet[6]) {
        	currIndex = 5;
        	h = incrementSet[currIndex];
        	passesLeft = 6;      	
        }
        if (n >= incrementSet[7]) {
        	currIndex = 6;
        	h = incrementSet[currIndex];
        	passesLeft = 7;      	
        }
        if (n >= incrementSet[8]) {
        	currIndex = 7;
        	h = incrementSet[currIndex];
        	passesLeft = 8;      	
        }
        if (n >= incrementSet[9]) {
        	currIndex = 8;
        	h = incrementSet[currIndex];
        	passesLeft = 9;      	
        }        

        // As long as we have passes remaining, keep going.
        while (passesLeft > 0) {        
        	
        	// Keep the user informed on the increment sets used on the sort
        	System.out.println("Increment: "+ h); 
        
        	/* 
        	 * Perform the Shellsort
        	 * Title: Java Program to Implement Shell Sort
        	 * Data: 08.03.2017
        	 * Source: 
        	 * http://www.sanfoundry.com/java-program-implement-shell-sort/  
        	 */
        	for (int i = h; i < arr.length; i++) {
        		int j = i;
        		int temp = arr[i];
        		while (j >= h && arr[j - h] > temp) {
        			arr[j] = arr[j - h];
        			j = j - h;
        		}
        		arr[j] = temp;
        	}
        	passesLeft--; // Reduce the number of passes remaining
        	
        	// Decrease the increment h
        	if (passesLeft > 0) {
        		currIndex--;
        		h = incrementSet[currIndex];        		       	
        	}
        }              
        return arr;
    }
}


/**
 *  The class where all the work is done for the fifth Shellsort
 *  Sequence. Increments are 1, 30, 120, 420, 1470, 5145, 18008, 63026,
 *  220592, 772072.
 *  
 */
class ShellSort5 {
	
	/**
     *  Constructor
     */
	public ShellSort5(){}
	
	/**
	 *  The method to sort the array using Shellsort
	 *  @param arr An unsorted array of integers
	 *  @return arr Returns a sorted array of integers 	  
	 */
	public int[] sort(int arr[]) {

		int n = arr.length; // Size of the incoming array
		int[] incrementSet = {1, 30, 120, 420, 1470, 5145, 18008, 63026, 
        		220592, 772072}; 
        int h = 1; // h is the increment
        int passesLeft = 0; // Keeps track of the number of passes remaining
        int currIndex = -1; // Current index in the incrementSet
        
        // Initialize the starting increment h as well as the number of 
        // passes that we need to perform.     
        // For the starting increment, find the first value larger than the 
        // file. Move back two increments to find the starting increment.
        if (n >= incrementSet[0]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[1]) {
        	currIndex = 0;
        	h = incrementSet[currIndex];
        	passesLeft = 1;      	
        }
        if (n >= incrementSet[2]) {
        	currIndex = 1;
        	h = incrementSet[currIndex];
        	passesLeft = 2;      	
        }
        if (n >= incrementSet[3]) {
        	currIndex = 2;
        	h = incrementSet[currIndex];
        	passesLeft = 3;      	
        }
        if (n >= incrementSet[4]) {
        	currIndex = 3;
        	h = incrementSet[currIndex];
        	passesLeft = 4;      	
        }
        if (n >= incrementSet[5]) {
        	currIndex = 4;
        	h = incrementSet[currIndex];
        	passesLeft = 5;      	
        }
        if (n >= incrementSet[6]) {
        	currIndex = 5;
        	h = incrementSet[currIndex];
        	passesLeft = 6;      	
        }
        if (n >= incrementSet[7]) {
        	currIndex = 6;
        	h = incrementSet[currIndex];
        	passesLeft = 7;      	
        }
        if (n >= incrementSet[8]) {
        	currIndex = 7;
        	h = incrementSet[currIndex];
        	passesLeft = 8;      	
        }
        if (n >= incrementSet[9]) {
        	currIndex = 8;
        	h = incrementSet[currIndex];
        	passesLeft = 9;      	
        }        

        // As long as we have passes remaining, keep going.
        while (passesLeft > 0) {        
        	
        	// Keep the user informed on the increment sets used on the sort
        	System.out.println("Increment: "+ h); 
        
        	/* 
        	 * Perform the Shellsort
        	 * Title: Java Program to Implement Shell Sort
        	 * Data: 08.03.2017
        	 * Source: 
        	 * http://www.sanfoundry.com/java-program-implement-shell-sort/  
        	 */
        	for (int i = h; i < arr.length; i++) {
        		int j = i;
        		int temp = arr[i];
        		while (j >= h && arr[j - h] > temp) {
        			arr[j] = arr[j - h];
        			j = j - h;
        		}
        		arr[j] = temp;
        	}
        	passesLeft--; // Reduce the number of passes remaining
        	
        	// Decrease the increment h
        	if (passesLeft > 0) {
        		currIndex--;
        		h = incrementSet[currIndex];        		       	
        	}
        }              
        return arr;
    }
}


/**
 *  The class where all the work is done for Heapsort
 *  Title: Sorting algorithms/Heapsort
 *  Date: 08.02.2017
 *  Availability: 
 *  http://rosettacode.org/wiki/Sorting_algorithms/Heapsort#Java
 */
class HeapSort {
	
	/**
     *  Constructor
     */
	public HeapSort(){}
		
	/**
     *	The iterative method to sort the array using Heapsort
	 *  @param a An unsorted array of integers
	 *  @return a Returns a sorted array of integers   
     */
	public int[] sort(int[] a) {
		int count = a.length;
	 
		// First place a in max-heap order
		heapify(a, count);
	 
		int end = count - 1;
		while (end > 0) {
			// Swap the root(maximum value) of the heap with the
			// last element of the heap
			int tmp = a[end];
			a[end] = a[0];
			a[0] = tmp;
			
			// Put the heap back in max-heap order
			siftDown(a, 0, end - 1);
			
			// Decrement the size of the heap so that the previous
			// max value will stay in its proper place
			end--;
		}
		return a;
	}
	
	/**
     *	Builds the heap
	 *  @param a An array of integers
	 *  @param count Length of the array
     */	 
	private void heapify(int[] a, int count) {
		// Start is assigned the index in a of the last parent node
		int start = (count - 2) / 2; // Binary heap
	 
		while (start >= 0) {
			// Sift down the node at index start to the proper place
			// such that all nodes below the start index are in heap
			// order
			siftDown(a, start, count - 1);
			start--;
		}
		// After sifting down the root all nodes/elements are in heap order
	}
	
	/**
     *	Method that sifts elements down
	 *  @param a An array of integers
	 *  @param start The start index
	 *  @param end The last index
     */	 
	private void siftDown(int[] a, int start, int end) {
		// End represents the limit of how far down the heap to sift
		int root = start;
	 
		// While the root has at least one child
		while ((root * 2 + 1) <= end) {  
			int child = root * 2 + 1; // root*2 + 1 points to the left child
			
			// If the child has a sibling and the child's value is less than 
			// its sibling's...
			if (child + 1 <= end && a[child] < a[child + 1])
				child = child + 1;  // then point to the right child instead
			
			if (a[root] < a[child]) { // Out of max-heap order
				int tmp = a[root];
				a[root] = a[child];
				a[child] = tmp;
				root = child; //Repeat to continue sifting down the child now
			} 
			else
				return;
		}
	}
}


/**
 *  The class where all the work is done for Straight Insertion Sort
 *  Title: Insertion Sort
 *  Date: 08.02.2017
 *  Availability: 
 *  http://www.geeksforgeeks.org/insertion-sort/
 */
class StraightInsertionSort {
	
	/**
     *  Constructor
     */
	public StraightInsertionSort(){}
	
	/**
	 *  The method to sort the array using Straight Insertion Sort
	 *  @param arr An unsorted array of integers
	 *  @return arr Returns a sorted array of integers 	   
	 */
	public int[] sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
        	int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position 
             */
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return arr;
    }
}


/**
 *  The class where all the work is done for Simple Selection Sort
 *  Title: Selection Sort
 *  Date: 08.02.2017
 *  Availability: 
 *  http://www.geeksforgeeks.org/selection-sort/
 */
class SimpleSelectionSort {
	
	/**
     *  Constructor
     */
	public SimpleSelectionSort(){}
	
	/**
	 *  The method to sort the array using Simple Selection Sort
	 *  @param arr An unsorted array of integers
	 *  @return arr Returns a sorted array of integers 	   
	 */
    public int[] sort(int arr[]) {
    	
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
        	
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }        
        return arr;
    }
}


/**
 *  The class where all the work is done for Quicksort
 *  Title: Quicksort in Java - Tutorial
 *  Author: Lars Vogel
 *  Date: 04.10.2016
 *  Code Version: 0.7
 *  Availability: 
 *  http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 */
class QuickSort {
	
    private int[] numbers;
    private int number;
	
	/**
     *  Constructor
     */
	public QuickSort(){}
	
	/**
	 *  Public method to sort the array
	 *  @param values An unsorted array of integers	    
	 */
	public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }
	
	/**
	 *  Private method to recursively apply Quicksort
	 *  @param low, high The ends of the array	 
	 */
    private void quicksort(int low, int high) {
        int i = low, j = high;
        
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
        	
            // If the current value from the left list is smaller than the 
        	// pivot element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            
            // If the current value from the right list is larger than the
            // pivot element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element, and if we have found a value in the right 
            // list which is smaller than the pivot element then we exchange 
            // the values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

	/**
	 *  Private method to perform the exchange of values
	 *  @param i, j The values that need to be exchanged	 
	 */ 
    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}


/**
 *  The class where all the work is done for Bubble Sort
 */
class BubbleSort {

	/**
     *  Constructor
     */
	public BubbleSort(){}	
		
	/**
	 *  The method to sort the array using Bubble Sort
	 *  @param array An unsorted array of integers
	 *  @return array Returns a sorted array of integers 	   
	 */
	public int[] sort(int[] array) {
		
		int n = array.length;
		
        int temp = 0; 
        
        // Each pair of adjacent elements is compared, and the elements
        // are swapped if they are not in order.
        for(int i = 0; i < n; i++) {         	
        	for(int j = 1; j < (n - i); j++) {  
        		if(array[j-1] > array[j]) {  
        			//swap elements  
        			temp = array[j-1];  
        			array[j-1] = array[j];  
        			array[j] = temp;  
        		}  
                         
        	}  
        }  		
		return array;				
	}	
}