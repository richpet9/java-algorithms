// Search Methods Class
// Richard Petrosino
// 10/09/2018

public class BinarySearch
{

	public static void search(int a[], int value)
	{
		int comparisons = 0;
		boolean found = false;
		boolean exitLoop = false;
		int first = 0;
		int last = (a.length - 1);
		int mid = (first + last) / 2;

		System.out.println ("\nBinary search for " + value);
		System.out.println("first \tlast \tmid \tvalue \treturn");
		
		//While not found
		while(!exitLoop) {
			
			//First, check if first is greater than last, if this is the case, the value is not in the array
			if(first > last) {
				exitLoop = true;		//Just exit
			} else {
				//Print the first, last, and mid
				System.out.print(first + " \t" + last + " \t" + mid + " \t" + value);
				
				//If the value we are searching for is greater than the value at the middle
				if(value > a[mid]) {
					first = mid + 1;				//Set first to middle + 1
					mid = (first + last) / 2;	//Set the middle to the middle with the new first value
				} else if(value < a[mid]) {
					//If the value is less than the mid
					last = mid - 1;				//Set the last value to middle - 1
					mid = (first + last) / 2;	//Set the middle to the middle with the new last value
				} else if(value == a[mid]) {
					//The value is the mid value
					exitLoop = true;				//Exit the loop
					found = true;				//Successful search
				}
				
				
				comparisons++;	//Iterate comparisons with every loop
				
				//If it was found, print the index, else print a dash
				System.out.print("\t" + ((found) ? mid : "-") + "\n");
			
			}
		}
		

		if (!found)
			System.out.println("Not found");

		System.out.println("Comparisons = " + comparisons);
	}
}
