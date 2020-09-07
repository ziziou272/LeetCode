package Cisco;// Sample code to read input and write output:

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[] )
	{
		// Use either of these methods for input

		//BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name1 = br.readLine();            // Read input from STDIN
		System.out.println("Hello " + name1);    // Write output to STDOUT

		//Scanner
		Scanner s = new Scanner(System.in);
		String name2 = s.nextLine();             // Read input from STDIN
		System.out.println("Hello " + name2);    // Write output to STDOUT
	}
}
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
class Solution
{
    public static void main(String args[] )
    {
        // Write your code here
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        System.out.println(count);

    }
}
