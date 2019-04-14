//Nicole Leon 3/21/19

package textExcel;

public class PercentCell extends ValueCell{
		private String truncatedValue;
	
	public PercentCell(String input) {
			super(input);
			double num = Double.parseDouble(valueText.replace("%", "")) * 100; 
			System.out.println(num);
			truncatedValue = (int) num/100 + "%          ";//into string so it will stay an int
	}															

	public double getDoubleValue() {
		return Double.parseDouble(valueText.replace("%", "")) / 100.0; 
		//gets rid of %, turns into String then turns into proper decimal
	}
	
	public String abbreviatedCellText() {
	// text for spreadsheet cell display, truncate (8.23435% to 8%) turn into int?
	return truncatedValue.substring(0,10) ; //for formatting
}
	
	public String fullCellText() {
	// text for individual cell inspection, printed in decimal form
	return toString(getDoubleValue());
}
}