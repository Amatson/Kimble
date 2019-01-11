package kimble;

/*
 * Token class takes care of single token data
 * Token has a color which binds the token to a particular player with same color
 * Token cannot move if it is in home or in the last fields of GOAL fields
 * Token knows what field it is on.
 * Tokens has a factor that indicates if token is a doubled, tripled or quadrupled one
 * 
 */
public class Token {
	
	// Board is needed to find free home fields to place the token in.
	private Board board; 
	private Colors color;
	private boolean movable;
	private Field field;
	private int factor;
	
	// Initialize token by giving it a color, setting it unmovable and placing it home
	public Token(Colors color, Board board) {
		this.setBoard(board); // needed?
		this.setColor(color);
		this.setMovable(false);
		this.setFieldHome();
		}
	
	// setFieldHome finds a free home field and places the token in it.
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
	public int getFactor() {
		return factor;
	}
	public void setFactor(int factor) {
		this.factor = factor;
	}

	public void setField(Field field) {
		try {
			if(!field.isVacant())
				throw new UnsupportedOperationException("Field has already a token.");
			else {
				// setField method checks if the given field is vacant and sets token to it.
				field.setToken(this);
				// Field is also informed about the token placed on it.
				this.field = field;
			}
		}
		catch (UnsupportedOperationException e) {
		    System.err.println("UnsupportedOperationException: " + e.getMessage());
		}
	}
	// TODO: this checks if field is vacant. Should this be handled as eating situation?

	
		
}
