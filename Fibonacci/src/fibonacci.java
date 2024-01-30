
//package myfibonacci

import static java.lang.System.out;
import java.lang.*;
import java.io.*;
import java.util.*;

public class fibonacci {
	
	static boolean isInt(String s)
	{
		try {
			int i = Integer.parseInt(s); 
			return true; 
		}
		catch(NumberFormatException er) {
			return false; 
		}
	}	
		
	static int fibonacci(int n)  {
		if(n < 2)
			return n;
	    else
		  return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Integer n = 0;
		boolean printAll = false;
		
		// Allow user to input the key, validate the user input
		if (args.length > 0 && args[0].equals("1")) {
			printAll = true;
		}
		
		do {
			
			System.out.println("Input the n: ");			
			while (scanner.hasNext()) {
   				String keyStr = scanner.nextLine();
				
				if (isInt(keyStr)) {
					n = Integer.valueOf(keyStr);
					break;
				}
				else {
					System.out.println("Input the key [0-25]: ");
					continue;
				}				
			}
			
			if (printAll) {
				for (int i = 0; i <= n; i++) {
					System.out.print(fibonacci(i) + " ");
				}
			}
			else {
				System.out.print(fibonacci(n) + " ");
			}
			
			System.out.print("\n");
			
		} while (false);
	}
}