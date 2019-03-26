package textExcel;

public class FormulaCell extends RealCell{
	String[] formParts;
	
		public FormulaCell(String input) {
			super(input);
		}
		public String getText() {
			return valueText.substring(0,valueText.length()-10);
		}
		public double getDoubleValue() { //gotta handle calculations now
			String[] formula = valueText.substring(1,valueText.length()-1).split(" ");//gets rid of parenthesis
			double operand;
			String operator;
			double ans=0;
			for(int i = 0; i<formula.length; i+=2) {
				operand = Double.parseDouble(formula[1]);
			for(int j=0; j<formula.length; j+=2) {
				operator = formula[i];
				
				 if(operator.equals("+")) {
			    	  ans = 
			      } else if (operator.equals("-")) {
			    	 
			      } else  if (operator.equals("*")) {
			    	 
			      } else if (operator.equals("/")){
			   
			      }	
				
			}
		}
			
			return ans;				
		}							   
		public String abbreviatedCellText() {
			// text for spreadsheet cell display, must be exactly length 10
			String output = "heyyyy" + "          ";
			return output.substring(0,10);
		}
		public String fullCellText() {
			// text for individual cell inspection, not truncated or padded
			return valueText.substring(0,valueText.length()-10);
		}
		
}
