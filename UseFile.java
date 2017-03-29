import java.io.*;
import java.util.*;

public class UseFile{
	private Formatter formatter;
	public void openFile(String name){	// opens an existing file
		String file_name = name+".txt";
		File f = new File(file_name);
		try{
			if(f.exists()){
				FileWriter fw = new FileWriter(file_name, true);
				formatter = new Formatter(fw);			// continues writing in new file
			}else{
				formatter = new Formatter(file_name);	// creates new file
			}
		}catch(Exception e){		// try/catch needed because FileWriter and Formatter need to be caught
			System.out.println(e);
		}
	}

	public void addData(String data){
		formatter.format("%s", data);
		// System.out.println("The data was added.");
	}
	
	public void closeFile(){	// closes the file 
		formatter.close();
		System.out.println("The file was closed.");
	}
}