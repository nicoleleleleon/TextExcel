package textExcel;

public class FormulaCell extends RealCell{
		public FormulaCell(String input) {
			super(input);
		}
		public String getText() {
			return valueText.substring(0,valueText.length()-10);
		}
		public double getDoubleValue() { //FormulaCell --> doesn't need to work yet
			return 10000;				//for ValueCell --> same as given (whole thing)
		}							   //PercentCell --> into decimal places
		public String abbreviatedCellText() {
			// text for spreadsheet cell display, must be exactly length 10
			return valueText.substring(0,10);
		}
		public String fullCellText() {
			// text for individual cell inspection, not truncated or padded
			return valueText.substring(0,valueText.length()-10);
		}
		
}
