import java.lang.Math;
import java.util.Scanner;

public class QuickTypeDemo{
	public static void main(String []args){
    		Scanner in = new Scanner(System.in);
    		UseFile file = new UseFile();
    		boolean run = true;
    		int calibration = 5;

    		// ask for file
    		System.out.print("Enter file name (without .txt): ");
    		String file_name = in.nextLine().replaceAll("\\s+", "");
    	
    		try{
    			file.openFile(file_name);
			}catch(Exception e){
				run = false;
			}
    	
    		if(run){
    			// calibration
    			try{
    				System.out.print("Chose number of fingers: ");
				calibration = in.nextInt();
				if(calibration < 4 || calibration > 10)
					calibration = 5;
				System.out.println("Calibration set to " + calibration);
    			}catch(Exception e){
    				run = false;
    				System.out.println("Error while calibraing. Terminationg program.");
    			}

    			// setting the keys
	    		// String[] keys = {"q", "w", "e", "r", "v"}; // this is for testing
	    		// String[] alphabet = {	" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", ".", ",", ":", "exit", "--linebr--"};	// \n apparently doesnt work
	    		String[] alphabet = {	" ", "e", "o", "s", "t", "i", "d", "f", "h", "n", "l", "g", "y", "b", "v", "z", 
	    					"a", "r", "u", "c", "m", "p", "j", ".", "w", "k", "q", ",", "x", ":", "EXIT", "--LINE--"};	// alphabet based on frequency in use (source: https://en.wikipedia.org/wiki/Letter_frequency; 11.3.2017, 9:55)
	    	
	    		String[] keys = new String[calibration];
	    		try{
	    			for(int i = 0; i < calibration; i++){
	    				keys[i] = in.next().substring(0,1);
	    			}
	    			System.out.println("You may begin typing");
	    		}catch(Exception e){
	    			System.out.println("Error selecting keys. Terminating program.");
	    			run = false;
	    		}
			
	    		// the main part
	    		outerloop:
	    		while(run){
		      		try{
		        		// input
		        		String input = in.nextLine();
		        		if(input.length() > calibration)
		        			input = input.substring(0,calibration);
		    
		        		// initialise
		        		int sum = 0;
		    	
		    	    		// check letters
		    	    		for(int i = 0; i < keys.length; i++){
		    	    			if(input.contains(keys[i]))
		        	    			sum += Math.pow(2, i);
		       			}
		    
		        		// add letter to string and check for break
		        		if(alphabet[sum] == "EXIT")
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
    		}
    		try{
			// close file    
			file.closeFile();
		}catch(Exception e){
			System.out.println("Error closing file.");
		}
  	}
}
