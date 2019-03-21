//Nicole Leon 3/21/19

package textExcel;

public class PercentCell extends ValueCell{
		String truncatedValue;
	
	public PercentCell(String input) {
			super(input);
			value = Double.parseDouble(input.replace("%", "")) / 100; //gets rid of %, turns into String then turns into proper decimal
			truncatedValue = toString( (int) value*100) + "%" + "          ";//times 100, casted as int to truncate, adding % sign
	}															  //spaces for formatting

	/*public double getDoubleValue() {
		same as others, just returns value
		and same getText?
	}*/
	
	public String abbreviatedCellText() {
	// text for spreadsheet cell display, truncate (8.23435% to 8%) turn into int?
	return truncatedValue.substring(0,10) ; //for formatting
}
	
	public String fullCellText() {
	// text for individual cell inspection, printed in decimal form
	return toString(value);
}
}