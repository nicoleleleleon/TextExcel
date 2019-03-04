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
    	while (!input.equals("quit")) {
    		System.out.println(processCommand(userInput));
			System.out.println("Do you want to keep going? Type \"quit\" to end.");
			input = userInput.nextLine();
	}
}
}
