//package mycountwords

import static java.lang.System.out;
import java.lang.*;
import java.io.*;
import java.util.*;

public class countWords {
	
    public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("illiad.txt"));

			var Arr = new ArrayList<String>();			

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line.isEmpty()) {
					//System.out.println("");
					continue;
				}
				
				Arr.add(line);
				//System.out.println(line);				
			}
			
			Set<String> uniqueWords = new HashSet<String>();
			
            int rows = Arr.size();
            int row, col = 0;
			for (row = 0; row < rows; row++) {
                // Remove all non-alphanumeric charactors with spaces, 
				// and clapse multiple spaces to 1, skip empty line
				String[] rowStr = Arr.get(row).toString().replaceAll(
          "[^a-zA-Z0-9]", " ").replaceAll("\\s{2,}", " ").split(" ");
		        
				int columns = rowStr.length;
				for (col = 0; col < columns; col++) {
					//System.out.print(rowStr[col] + " ");
					uniqueWords.add(rowStr[col].trim().toLowerCase());					
				}
				//System.out.print("\n\n");
			}		
		
			System.out.print("\nWord count: " + uniqueWords.size() + "\n");
			//System.out.print("\nUnique words: " + uniqueWords + "\n");
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}