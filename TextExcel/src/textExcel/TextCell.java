//author Nicole Leon 3/6/19
// koding is kool ~~~~~~~~~~~~~~~~~~~~

package textExcel;

public class TextCell implements Cell{
	private String text;
	
	public TextCell(String input) {
		text = input.substring(1,input.length()-1) + "          ";
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		/*if(text.length()>10) {//abbreviates
		return text.substring(1,11);
	}else {
		text = text.substring(1,text.length()-1);//fixes spacing
		String spaces = ""; //adds spaces
		for(int i=text.length(); i<10; i++) {
				spaces += " ";
		}
		return text + spaces;
	}*/
		
		return text.substring(0,10);
		
	}
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() { 
		String origStr = "\"" + text + "\"";
		return origStr;
		
	}

}
