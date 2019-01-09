package kimble;


public class Field {
	
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

	public boolean isVacant() {
		return(this.token == null);
	}
	

}
