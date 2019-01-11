package kimble;


public class Field {
	
	/*
	 * In Kimble, a token can be in three different fields:
	 * Normal: an edible field, also a mine. Token can move freely in normal fields.
	 * Goal: safe fields where token cannot be eaten, sometimes cannot move with any dice number
	 * Home: safe fields where tokens are returned after eating. Tokens cannot move in homefields.
	 */
	
	public enum Type {
		NORMAL,
		GOAL,
		HOME
	}
	
	private Colors color; // Field has a color value to indicate on which quadrant it is on
	private Type type; // Field has a type which indicates the type of the field in the quadrant (goal, home, normal)
	private int id; // Field has an id value to tell what is the id of the field with given type
	private Board board;
	private Token token;
	// TODO: For doubled, tripled and quadrupled tokens we might need a list of tokens on field.
	
	

	public Field(Board board, Colors color, Type type, int id) {
		this.setColor(color);
		this.setType(type);
		this.setId(id);
		this.setBoard(board);
		this.setToken(null);
	}

	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Colors getColor() {
		return color;
	}
	public void setColor(Colors color) {
		this.color = color;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	
	// Test if there is a token on the field.
	public boolean isVacant() {
		return(this.token == null);
	}
	

}
