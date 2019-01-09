package kimble;

public class Token {
	
	private Colors color;
	// String? location;
	private boolean movable;
	private Board board;
	
	// private ??? location
	// token has a location on the board
	
	public Token(Colors color, Board board) {
		this.setColor(color);
		this.setBoard(board);
		this.setMovable(false);
		// location = home
		// set location => home (on board)
		}
	
	public Colors getColor() {
		return color;
	}
	public void setColor(Colors color) {
		this.color = color;
	}
	public boolean isMovable() {
		return movable;
	}
	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	
	public void setBoard(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	
	
	public boolean advance(int steps) {
		
		// do this via board!
		
		return true;
	}	
	
}
