//author: Nicole Leon 3/6/19 :)))))))))))))
//Client Code

/*                        \                         /     
 *                        O                         O
 *                 |                    *                   |
 *                  \______________________________________/                    
 */

package textExcel;
import java.util.*;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		System.out.println("Gimme some commands!"); 
    	Scanner userInput = new Scanner(System.in);
    	String input = userInput.nextLine(); //gets equation
    	Spreadsheet sheet = new Spreadsheet();
    	while (!input.equalsIgnoreCase("quit")) {
    		System.out.println(sheet.processCommand(input));
    		Location loc = new SpreadsheetLocation(input);
    		System.out.println("row: " + loc.getRow());
    		System.out.println("column: " + loc.getCol());
			System.out.println("Do you want to keep going? Type \"quit\" to end."); 
			input = userInput.nextLine();
	}
}
}
