package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	 
//constructor
	public Spreadsheet() {
		//initializes a 2D array of cells with all elements containing EmptyCell Objects
		Cell[][] grid = new Cell[getRows()][getCols()];
		
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++) {
				grid[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
