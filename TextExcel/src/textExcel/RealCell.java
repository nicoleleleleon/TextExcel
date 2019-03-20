//Nicole Leon wrote this amazing A+++ code on 3/20/2019

package textExcel;

public class RealCell implements Cell {
	String valueText;
	double value;
	
public RealCell(String input) {
	input += "          ";
	valueText = input;
	value = Integer.parseInt(input);
}

	public String getText() {
		return valueText;
	}
	public double getDoubleValue() { //FormulaCell --> doesn't need to work yet
		return value;				//for ValueCell --> same as given (whole thing)
	}							   //PercentCell --> into decimal places
	public double getValue() {
		return value; 
	}
	public String abbreviatedCellText() {
		// text for spreadsheet cell display, must be exactly length 10
		return valueText.substring(0,10);
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return valueText.substring(0,valueText.length()-10);
	}
}
