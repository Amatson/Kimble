package kimble;

public class Token {
	
	private Colors color;
	private boolean movable;
	private Board board;
	private Field field;
	
	
	public Token(Colors color, Board board) {
		this.setColor(color);
		this.setBoard(board);
		this.setMovable(false);
		this.setFieldHome();
		// location = home
		// set location => home (on board)
		}
	
	public void setFieldHome() {

		this.setField(board.getFreeHomeField(this.color));
		// TODO: check return value if null
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

	public Field getField() {
		return field;
	}

	
	// TODO: this checks if field is vacant. Should this be handled as eating situation?
	public void setField(Field field) {
		try {
			if(!field.isVacant())
				throw new UnsupportedOperationException("Field has already a token.");
			else {
				field.setToken(this);
				this.field = field;
			}
		}
		catch (UnsupportedOperationException e) {
		    System.err.println("UnsupportedOperationException: " + e.getMessage());
		}
	}
	
	
	
	
//	public boolean advance(int steps) {
//		
//		// do this via board!
//		
//		return true;
//	}	
	
		
}
