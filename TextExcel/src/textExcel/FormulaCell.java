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
			double operand = 0;
			String operator;
			double ans = 0;
			
			if(formParts[0].equalsIgnoreCase("SUM")) {
				ans = findSum(formParts[1]);
				
			} else if(formParts[0].equalsIgnoreCase("AVG")) {
				ans = findSum(formParts[1]) / findNum(formParts[1]);
				
			} else if (Character.isLetter(formParts[0].charAt(0))) {//if first index still has a letter
				Location loc = new SpreadsheetLocation(formParts[0]); //call getCell()
				
				if ( sheetcopy.getCell(loc) instanceof RealCell ){
					RealCell tempCell = (RealCell) sheetcopy.getCell(loc); //made new field so self-aware that it is SpreadsheetLocation
					ans = tempCell.getDoubleValue();
					
				}} else if (!Character.isLetter(formParts[0].charAt(0))){
					ans = Double.parseDouble(formParts[0]);	
				}
			
			int i=2; int j = 1;
			
			while(i<=formParts.length && !formParts[0].equalsIgnoreCase("SUM") && !formParts[0].equalsIgnoreCase("AVG")) {
				
				if(Character.isLetter(formParts[i].charAt(0))) {//if index has a letter
					SpreadsheetLocation loc = new SpreadsheetLocation(formParts[i]); //call getCell()
					RealCell tempCell = (RealCell) sheetcopy.getCell(loc); //made new field so self-aware
					operand = tempCell.getDoubleValue();
					
				} else if (!Character.isLetter(formParts[0].charAt(0))){
			operand = Double.parseDouble(formParts[i]);	//otherwise it is just what it is
			System.out.println(operand);
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
			return ans;				
		}
		/*	if(Character.isLetter(formParts[0].charAt(0)) && !formParts[0].equalsIgnoreCase("SUM") && !formParts[0].equalsIgnoreCase("AVG")) {//if first index has a letter
				Location loc = new SpreadsheetLocation(formParts[0]); //call getCell()
				if ( sheetcopy.getCell(loc) instanceof RealCell ){
					RealCell tempCell = (RealCell) sheetcopy.getCell(loc); //made new field so self-aware that it is SpreadsheetLocation
					ans = tempCell.getDoubleValue();
		}} else if (!Character.isLetter(formParts[0].charAt(0))){
				ans = Double.parseDouble(formParts[0]);	
			}
			
					int i=2; int j = 1;
					while(i<=formParts.length && !formParts[0].equalsIgnoreCase("SUM") && !formParts[0].equalsIgnoreCase("AVG")) {
						if(Character.isLetter(formParts[i].charAt(0)) && !formParts[0].equalsIgnoreCase("SUM") && !formParts[0].equalsIgnoreCase("AVG")) {//if index has a letter
							SpreadsheetLocation loc = new SpreadsheetLocation(formParts[i]); //call getCell()
							RealCell tempCell = (RealCell) sheetcopy.getCell(loc); //made new field so self-aware
							operand = tempCell.getDoubleValue();
						} else if (!Character.isLetter(formParts[0].charAt(0))){
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
				if(formParts[0].equalsIgnoreCase("SUM")) {
						ans = findSum(formParts[1]);
					}
				if(formParts[0].equalsIgnoreCase("AVG")) {
						
						ans = findSum(formParts[1]) / findNum(formParts[1]);
				}
			return ans;				
		}*/
		public int findNum(String range) {
			String[] location = range.split("-");
			SpreadsheetLocation start = new SpreadsheetLocation(location[0]);
			SpreadsheetLocation end = new SpreadsheetLocation(location[1]);
			int rows = end.getRow() - start.getRow() + 1;
			int cols = end.getCol() - start.getCol() + 1;

			return rows*cols;
		}
		
		public double findSum(String range) {
			String[] location = range.split("-");
			SpreadsheetLocation start = new SpreadsheetLocation(location[0]);
			SpreadsheetLocation end = new SpreadsheetLocation(location[1]);
			double sum = 0;
			 for(int r = start.getRow(); r<= end.getRow(); r++) {
				 for(int c = start.getCol(); c<=end.getCol(); c++) {
					 SpreadsheetLocation loc = new SpreadsheetLocation(r,c);
					 RealCell tempCell = (RealCell) sheetcopy.getCell(loc);
					 sum += tempCell.getDoubleValue();
				 }
			 }
			return sum;
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
