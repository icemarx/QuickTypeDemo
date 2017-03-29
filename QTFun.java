import java.lang.Math;
import java.util.Scanner;

public class QTFun{
	private Scanner in = new Scanner(System.in);

	public int Calibration(int cal){
		if(cal < 4 || cal > 10)
			cal = 5;
		System.out.println("Calibration set to " + cal);
		return cal;
	}

	public String[] KeySelect(int cal){
		// setting the keys
		try{
			String[] keys = new String[cal];
		for(int i = 0; i < cal; i++){
			System.out.print("Key #"+i+": ");
			keys[i] = in.next().substring(0,1);
		}
		    return keys;
		}catch(Exception e){
			System.out.println("Error selecting keys. Setting to default.");
			String[] keys = {"q", "w", "e", "r", "v"};
			return keys;
		}
	}

	public int InitialiseInput(String input, String[] keys, int cal){
		// input
		int sum = 0;
		if(input.length() > cal)
			input = input.substring(0,cal);

		// check letters
		for(int i = 0; i < keys.length; i++){
			if(input.contains(keys[i]))
	    			sum += Math.pow(2, i);
		}
		return sum;
	}

	public void QTmain(UseFile file){
		int calibration = 5;
		// String[] alphabet = {	" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", ".", ",", ":", "exit", "--linebr--"};	// \n apparently doesnt work
		String[] alphabet = {	" ", "e", "o", "s", "t", "i", "d", "f", "h", "n", "l", "g", "y", "b", "v", "z", 
					"a", "r", "u", "c", "m", "p", "j", ".", "w", "k", "q", ",", "x", ":", "EXIT", "\n"};	// alphabet based on frequency in use (source: https://en.wikipedia.org/wiki/Letter_frequency; 11.3.2017, 9:55)
		String[] keys;
		try{
			System.out.print("Calibrate number: ");
			calibration = Calibration(in.nextInt());
			keys = KeySelect(calibration);
		}catch(Exception e){
			keys = new String[]{"q", "w", "e", "r", "v"};
		}

		outerloop:
		while(true){
			try{
				int sum = InitialiseInput(in.nextLine(), keys, calibration);    
				// add letter to string and check for break
				if(alphabet[sum] == "EXIT")
					break outerloop;
				else{
					try{
						// output
						System.out.println(alphabet[sum]); // so the user can see what he/she wrote
						file.addData(alphabet[sum]);
					}catch(Exception e){
						System.out.println("error while loading to file"); // this will print when the file output will be implemented and it won't work
						break outerloop;
					}
				}
	 		}catch(Exception e){}
		}
	}
}
