//author: Nicole Leon 3/6/19 :)))))))))))))
//Client Code

/*                        \                         /     
 *                        $                        $
 *                                     >                   
 *                \__________________________________________/       
 *                   \VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV/   
 *                    \__________________________________/        
 */

package textExcel;
import java.util.*;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		System.out.println("MmmmMMMMmmmm gimme some commands or ELSE (type quit)!"); 
    	Scanner userInput = new Scanner(System.in);
    	String input = userInput.nextLine(); //gets equation
    	Spreadsheet sheet = new Spreadsheet();
    	while (!input.equalsIgnoreCase("quit")) {
    		System.out.println(sheet.processCommand(input));
    		if(input.length()<=3) {//won't print entire grid if just cell inspection
    		}else{
    			System.out.println(sheet.getGridText());
    		}
			System.out.println("Do you want to keep going? Type \"quit\" to end."); 
			input = userInput.nextLine();
	}
}
}


//errors I see:
/*
 * every time i make another cell assignment it takes off the initial and last chars of the String
 * If i pass in a long string it doesn't show 10 chars it shows 6
 */







