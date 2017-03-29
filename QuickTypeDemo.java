import java.util.Scanner;

public class QuickTypeDemo{
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		UseFile file = new UseFile();
		QTFun fun = new QTFun();
		boolean run = true;
		// ask for file
		System.out.print("Enter file name (without .txt): ");
		String file_name = in.nextLine().replaceAll("\\s+", "");

		try{
			file.openFile(file_name);
		}catch(Exception e){
			run = false;
		}

		// main part
		if(run)
		fun.QTmain(file);

		// close file
		try{
			file.closeFile();
		}catch(Exception e){
			System.out.println("Error closing file.");
		}
	}
}
