Author: Addison Sears-Collins

Used Java Eclipse IDE (Java 8: JavaSE 1.8)

SortingDriver.java contains the main method and is the driver class for the application.

If running program from the command line on Windows 7, navigate to where the compiled classes are 
located (usually the bin directory) in the file and use the command
     java -cp . sorting.SortingDriver 
in order to run the program. Alternatively, you can delete the package statement on the first line
of the program and run using the command 'javac SortingDriver.java' + 'java SortingDriver' 
in the command prompt

The program will prompt for the file input name (e.g. input.txt or C:\Users\Addison\Desktop\input.txt) 
and file output name (e.g. output.txt or C:\Users\Addison\Desktop\output.txt).

The input file needs to exist in order for the program to run. The output file does not have to exist.

29 input files (with the corresponding output) were used (15 required test cases and 14 extra cases that I created):
	Note: filename_output.txt is the associated output file for filename.txt

•	asc_1000.txt - Contains 1000 non-duplicate integers in ascending order
•	asc_10000.txt - Contains 10000 non-duplicate integers in ascending order
•	asc_2000.txt - Contains 2000 non-duplicate integers in ascending order
•	asc_20000.txt - Contains 20000 non-duplicate integers in ascending order
•	asc_50.txt - Contains 50 non-duplicate integers in ascending order
•	asc_500.txt - Contains 500 non-duplicate integers in ascending order
•	asc_5000.txt - Contains 5000 non-duplicate integers in ascending order
•	rand_1000.txt - Contains 1000 non-duplicate integers in random order
•	rand_10000.txt - Contains 10000 non-duplicate integers in random order
•	rand_2000.txt - Contains 2000 non-duplicate integers in random order
•	rand_20000.txt - Contains 20000 non-duplicate integers in random order
•	rand_50.txt - Contains 50 non-duplicate integers in random order
•	rand_500.txt - Contains 500 non-duplicate integers in random order
•	rand_5000.txt - Contains 5000 non-duplicate integers in random order
•	rev_1000.txt - Contains 1000 non-duplicate integers in reverse order
•	rev_10000.txt - Contains 10000 non-duplicate integers in reverse order
•	rev_2000.txt - Contains 2000 non-duplicate integers in reverse order
•	rev_20000.txt - Contains 20000 non-duplicate integers in reverse order
•	rev_50.txt - Contains 50 non-duplicate integers in reverse order
•	rev_500.txt - Contains 500 non-duplicate integers in reverse order
•	rev_5000.txt - Contains 5000 non-duplicate integers in reverse order
•	_blank_file.txt - A blank file
•	_dups_asc_10000_100prct.txt - Contains 10000 integers, 100% duplicates
•	_dups_asc_10000_10prct.txt - Contains 10000 integers, 10% duplicates
•	_dups_asc_10000_20prct.txt - Contains 10000 integers, 20% duplicates
•	_dups_asc_10000_50prct.txt - Contains 10000 integers, 50% duplicates
•	_non_int_rand_50.txt - Contains non-integer values, for error checking
•	_rand_50000.txt - Contains - Contains 50000 non-duplicate integers in random order 
•	short_input.txt - A file that contains 1 and 2 in reverse order