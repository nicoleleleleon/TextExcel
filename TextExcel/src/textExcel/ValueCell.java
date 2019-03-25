//Nicole Leon 3/20/19

package textExcel;

public class ValueCell extends RealCell {
	
	
	public ValueCell(String input) {
			super(input);
			
		}
	
	//same fullCellText and abbreviatedCelltext
		//plus same DoubleValue and getText
	public String getText() {
		return valueText.substring(0,valueText.length()-10);
	}
/*	public double getDoubleValue() {//same as RealCell
		return Double.parseDouble(valueText);
	}		*/					   
	/*public double getValue() {
		return value; 
	}*/
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		String newString = toString(getDoubleValue()) + "          "; //so that takes in the double and gives us dat nice .0	
		return newString.substring(0,10);
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return valueText;
	}
}
