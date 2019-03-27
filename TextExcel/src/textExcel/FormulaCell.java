//Nicole Leon woahhhhhhhhhhhhh

package textExcel;

public class FormulaCell extends RealCell{
	private String[] formParts;
	private Spreadsheet sheetcopy;
		public FormulaCell(String input,Spreadsheet sheet) {
			super(input);
			sheetcopy = sheet;
			formParts = valueText.substring(2,valueText.length()-2).split(" ");	//gets rid of parenthesis then splits
		}
		public FormulaCell (String input) {//two constructors
			super(input);
			formParts = valueText.substring(2,valueText.length()-2).split(" ");	//gets rid of parenthesis then splits
		}
		public String getText() {
			return valueText;
		}
		public double getDoubleValue() { //gotta handle calculations now
			double operand;
			String operator;
			double ans = 0;
			//so that if the first operand has a letter it handles that separately
			if(Character.isLetter(formParts[0].charAt(0))) {//if first index has a letter
				Location loc = new SpreadsheetLocation(formParts[0]); //call getCell()
				RealCell tempCell = (RealCell) sheetcopy.getCell(loc); //made new field so self-aware that it is SpreadsheetLocation
			    ans = tempCell.getDoubleValue();
			} else {
				ans = Double.parseDouble(formParts[0]);	
			}
		
			//for(int i = 2; i<=formParts.length; i+=2) {
			//	for(int j=1; j<formParts.length; j+=2) {
					int i=2; int j = 1;
					while(i<=formParts.length) {
						if(Character.isLetter(formParts[i].charAt(0))) {//if first index has a letter
							Location loc = new SpreadsheetLocation(formParts[i]); //call getCell()
							RealCell tempCell = (RealCell) sheetcopy.getCell(loc); //made new field so self-aware
							operand = tempCell.getDoubleValue();
						} else {
					operand = Double.parseDouble(formParts[i]);	//otherwise it is just what it is
						}
					operator = formParts[j];
				 if(operator.equals("+")) {
			    	  ans += operand;
			      } else if (operator.equals("-")) {
			    	  ans -= operand;
			      } else  if (operator.equals("*")) {
			    	  ans *= operand;
			      } else if (operator.equals("/")){
			    	  ans /= operand;
			      }
				 i+=2; j+=2;
			}
		//	}

//		}
			return ans;				
		}				
		public String abbreviatedCellText() {
			// text for spreadsheet cell display, must be exactly length 10
			String output = getDoubleValue() + "           ";
			return output.substring(0,10);
		}
		public String fullCellText() {
			// text for individual cell inspection, not truncated or padded
			return valueText;
		}
		
}
