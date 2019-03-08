package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;
	private String location;
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
    	
        return this.row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return this.col;
    }
   
    //constructor
    public SpreadsheetLocation(String cellName)
    {
    	location = cellName;
    	String rowStr = location.substring(1);
    	//System.out.println(rowStr);
    	row = Integer.parseInt(rowStr)-1;
    	//convert letter to index
    	String letter = location.toUpperCase();
    	col = (int)(letter.charAt(0) - 65);//minus 65 because that's the value of 'A'
        // TODO: Fill this out with your own code
    	
    	
    }

}
