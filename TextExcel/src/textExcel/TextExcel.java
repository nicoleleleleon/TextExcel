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
		System.out.println("Just give me sum dern commands"); 
    	Scanner userInput = new Scanner(System.in);
    	String input = userInput.nextLine(); //gets equation
    	Spreadsheet sheet = new Spreadsheet();
    	while (!input.equalsIgnoreCase("quit")) {
    		System.out.println(sheet.processCommand(input));
    	/*	if(input.length()<=3) {//won't print entire grid if just cell inspection
    		}else{
    			System.out.println(sheet.getGridText());
    		}
    		Did this in processCommand
    		*/
    		System.out.println("You done yet? I don't get paid enough for this \nHurry up and type \"quit\" already");
			//System.out.println("Do you want to keep going? Type \"quit\" to end."); 
			input = userInput.nextLine();
	}
    	System.out.println("Bye, loser");
}
}


//errors I see:
/*
 * every time i make another cell assignment it takes off the initial and last chars of the String
 * If i pass in a long string it doesn't show 10 chars it shows 6
 * 			--> the fix was using Lamont's method of adding spaces, splitting only first three spaces
 * 								in processCommand (( .split(" ",3); ))
 * 
 * ERRORS THROWN EVERYTIME TRY TO MAKE PERCENTCELL OR FORMULA CELL
 * WHEN PRINTING WHOLE VALUECELL IN GRID NEED TO ADD ".0"
 * 
 */







