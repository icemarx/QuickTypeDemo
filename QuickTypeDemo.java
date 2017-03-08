import java.lang.Math;
import java.util.Scanner;

public class QuickTypeDemo{
  public static void main(String []args){
    Scanner in = new Scanner(System.in)
    
    //calibration
    char[] keys = {'q', 'w', 'e', 'r', 'v'}; // this is for testing, it will be calibrated in later versions
    String[] alphabet = {".", " ", "a", "b", "c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",};
    
    /*
     * insert open file code here
     */
    
    outerloop:
    while(true){
      try{
        // input
        String input = in.nextLine();
        if(input.length() > 5)
          input = input.substring(0,5);
    
        // initialise
        int sum = 0;
    
        // check letters
        for(int i = 0; i < keys.length(); i++){
          if(input.contains(keys[i]))
            sum += Math.pow(2, i);
        }
    
        // add letter to string and check for break
        if(alphabet[sum] == ".")
          break outerloop;
        else
          try{
          // output
          System.out.println(output); // will change to add to a .txt file
          }catch(Exception e){
            System.out.println("error while loading to file"); // this will print when the file output will be implemented and it won't work
            break outerloop;
          }
      }catch(Exception e){}
    }
    /*
     * insert close file code here
     */
  }
}
