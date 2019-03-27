//Nicole Leon woahhhhhhhhhhhhh

package textExcel;

public class FormulaCell extends RealCell{
	String[] formParts;
	
		public FormulaCell(String input) {
			super(input);
			formParts = valueText.substring(2,valueText.length()-2).split(" ");	//gets rid of parenthesis then splits
		}
		public String getText() {
			return valueText;
		}
		public double getDoubleValue() { //gotta handle calculations now
			double operand;
			String operator;
			double ans=Double.parseDouble(formParts[0]);
			//for(int i = 2; i<=formParts.length; i+=2) {
			//	for(int j=1; j<formParts.length; j+=2) {
					int i=2; int j = 1;
					while(i<=formParts.length) {
					operand = Double.parseDouble(formParts[i]);	
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
