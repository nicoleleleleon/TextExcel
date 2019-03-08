//author Nicole Leon 3/6/19
// koding is kool ~~~~~~~~~~~~~~~~~~~~

package textExcel;

public class TextCell implements Cell{
	private String userInput;
	
	public TextCell(String input) {
		userInput = input;
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {;
		return userInput.substring(0,9);
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() { 
		String origStr = "\"" + userInput + "\"";
		return origStr;
		
	}

}
