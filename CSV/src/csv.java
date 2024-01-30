//package csv;

import java.lang.*;
import java.io.*;
import java.util.ArrayList;

class CsvReader {
	private String file_name;
	private String[][] TwoDimdata;
	private int rows = 0;
	private int columns = 0;
		
	public CsvReader (String fileName) {
		try {
		    file_name = fileName;	
			
		    var DataReader = new BufferedReader(new FileReader(file_name));
			
			String line;
			var Arr = new ArrayList<String>();
			while ((line = DataReader.readLine()) != null) {
				Arr.add(line);
			}

			// Break the 1D array into a 2D array 
            rows = Arr.size();
			columns = Arr.get(0).toString().split(",").length;			
			TwoDimdata = new String[rows][columns];

            int row, col = 0;
			for (row = 0; row < rows; row++) {
				for (col = 0; col < columns; col++) {
					var arr = Arr.get(row).split(",");
					TwoDimdata[row][col] = arr[col];
				}
			}
		
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex2) {
		   ex2.printStackTrace();
		}		
	}

    public String[] GetRow (int row) {
		if (row >= rows) {
			System.out.printf("Max row number must be < %d", rows);
		}

        return TwoDimdata[row];
	}
	
    public void PrintRow (int row) {
		if (row >= rows) {
			System.out.printf("Max row number must be < %d", rows);
		}
		
		int col;
		for (col = 0; col < columns - 1; col++) {
			System.out.printf("%s,", TwoDimdata[row][col]);
		}
		System.out.printf("%s\n", TwoDimdata[row][col]);
	}
	
	public void PrintFile() {

		for (int row = 0; row < rows; row++) {
		    PrintRow(row);
		}
		
		System.out.printf("\n");
	}
}

public class csv {

    public static void main(String[] args) {
		//CsvReader csv = new CsvReader("//Users//rosiewu//IdeaProjects//CSV//out//production//CSV//test.csv");
		CsvReader csv = new CsvReader("test.csv");
		csv.PrintFile();
    }	
}