import java.util.Scanner;

public class QuickTypeDemo{
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		UseFile file = new UseFile();
		QTFun fun = new QTFun();
		// ask for file
		System.out.print("Enter file name (without .txt): ");
		String file_name = in.nextLine().replaceAll("\\s+", "");

		try{
			file.openFile(file_name);
			// main part
			fun.QTmain(file);
			// close file
			file.closeFile();
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
}