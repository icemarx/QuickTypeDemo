import java.io.*;
import java.util.*;

public class UseFile{
	private Formatter formatter;
	public void openFile(String name){	//opens an existing file
		String file_name = name+".txt";
		try{
			File f = new File(file_name);
			if(f.exists()){
				FileWriter fw = new FileWriter(file_name, true);
				formatter = new Formatter(fw);			//continues writing in new file
			}else{
				formatter = new Formatter(file_name);	//creates new file
			}
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
			System.out.println("The file was closed.");
		}catch(Exception e){
			System.out.println("Unable to close file safely.");
		}
	}
}
