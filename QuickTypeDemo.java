import java.lang.Math;
import java.util.Scanner;

public class QuickTypeDemo{
	public static void main(String []args){
    		Scanner in = new Scanner(System.in);
    		UseFile file = new UseFile();
    		boolean run;

    		// ask for file
    		System.out.println("Enter file name (without .txt): ");
    		String file_name = in.nextLine();
    	
    		try{
    			file.openFile(file_name);
			run = true;
		}catch(Exception e){
			run = false;
		}
    	
	    	// calibration
    		String[] keys = {"q", "w", "e", "r", "v"}; // this is for testing, it will be calibrated in later versions
    		String[] alphabet = {"exit", " ", "a", "b", "c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    		outerloop:
    		while(run){
		      	try{
	        		// input
	        		String input = in.nextLine();
	        		if(input.length() > 5)
	        			input = input.substring(0,5);
	    
		        	// initialise
		        	int sum = 0;
	    	
	    			// check letters
	    	    		for(int i = 0; i < keys.length; i++){
	    	    			if(input.contains(keys[i]))
	        	    			sum += Math.pow(2, i);
	       		 	}
	    
	        		// add letter to string and check for break
	        		if(alphabet[sum] == "exit")
	        			break outerloop;
	        		else{
	        			try{
	         				// output
		        			System.out.println(alphabet[sum]); // will change to add to a .txt file
		        			file.addData(alphabet[sum]);
	        			}catch(Exception e){
	            				System.out.println("error while loading to file"); // this will print when the file output will be implemented and it won't work
	            				break outerloop;
					}
	        		}
	    		}catch(Exception e){}
    		}
    		try{
			// close file    
			file.closeFile();
		}catch(Exception e){
			System.out.println("Error closing file.");
		}
  	}
}
