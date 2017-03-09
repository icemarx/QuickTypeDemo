import java.io.*;
import java.util.*;

public class UseFile{
	private Formatter formatter;
	// private Scanner fileScanner;
	
	public void openFile(String name){	//opens an existing file
		try{
			// fileScanner = new Scanner(new File(name + ".txt")); // use this in future for READING ONLY
			formatter = new Formatter(name + ".txt");	// opens existing or creates new file
			// System.out.println("File opened.");
		}catch(Exception e){
			System.out.println("Unable to open/create file.");
		}	
	}

	public void addData(String data){
		try{
			formatter.format("%s", data);
			// System.out.println("The data was added.");
		}
		catch(Exception e){
			System.out.println("Something went wrong, data was not added.");
		}
	}
	
	public void closeFile(){	//closes the file 
		try{
			formatter.close();
			// System.out.println("The file was closed.");
		}catch(Exception e){
			System.out.println("Unable to close file safely.");
		}
	}
}
