//Nicole Leon :))

package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	 private Cell[][] grid;
	 private int numRows;
	 private int numCols;
//constructor
	public Spreadsheet() {
		//initializes a 2D array of cells with all elements containing EmptyCell Objects
		numCols = 12;
		numRows = 20;
		grid = new Cell[getRows()][getCols()];
		
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		/*System.out.println("row: " + loc.getRow());
		System.out.println("column: " + loc.getCol()); */
		// TODO Auto-generated method stub
		
		//cell inspection, if length is three or less
		if(command.length()<=3) {
			
			Location loc = new SpreadsheetLocation(command);
			return getCell(loc).fullCellText();
			
		} else if (command.equalsIgnoreCase("clear")) {//if just clear--> clear whole sheet 
			
			for(int i=0; i<grid.length; i++){
				for(int j=0; j<grid[0].length; j++) {
					grid[i][j] = new EmptyCell();
				}
			}
		} else if (command.substring(0,6).equalsIgnoreCase("clear ")) {//ELSE IF does it contain "clear "
			
			Location loc = new SpreadsheetLocation(command.substring(6)); 
			grid[loc.getRow()][loc.getCol()] = new EmptyCell();
		
		} else {//ELSE assignment
		//parse the "=" --> location, value (for now, make new cell instance and store the value)
			String[] assignment = command.split(" ",3); //[location,=,value]
			Location loc = new SpreadsheetLocation(assignment[0]);
			Cell newValue = new TextCell(assignment[2]);
			grid[loc.getRow()][loc.getCol()] = newValue;//made into cell
			}		
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return numRows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return numCols;
	}

	@Override
	public Cell getCell(Location loc)//accepts location, returns Cell at that location
	{
		// TODO Auto-generated method stub
		return grid[loc.getRow()][loc.getCol()];
	}

	@Override
	
	public String getGridText() {
		// TODO Auto-generated method stub
		String value = "";
				value += "   |";
		//System.out.print("   |");
		
		for(int letter = 0; letter< numCols; letter++) {
			
					value += (char)('A'+letter) + "         |";
			//System.out.print((char)('A'+letter) + "         |");
		}
			value += "\n";
		//	String value = "";
			
		for(int r = 0; r< numRows; r++) { //row
				value+= r+1;
				if(r<=8) { //so has correct spacing
					value+= "  |" ;
				} else {
					value+= " |" ;
				}
			for(int c = 0; c<=11; c++) { //column
				Location loc = new SpreadsheetLocation(r, c);
				value += getCell(loc).abbreviatedCellText(); //remember this syntax Nicole!!
				value += "|";
			}
			value += "\n"; 
		}
		return value;
	}

}
