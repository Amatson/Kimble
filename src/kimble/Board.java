package kimble;

/*
 * Board initializes the player locations and colors and logs the locations of the pieces.
 * 
 */
public class Board {
	// Board is the place to store the locations of the tokens.

	private int boardSize; // Board size is practically the number of players. This is to enable different kimble versions
	
	public Board(int size) {
		
		this.setBoardSize(size);
	}

	
	
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public int getBoardSize() {
		return boardSize;
	}

	
	
	
	
	

}
