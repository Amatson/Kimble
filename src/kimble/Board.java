package kimble;

import java.util.ArrayList;

/*
 * Board initializes the player locations and colors 
 * and logs the locations of the pieces.
 * 
 */
public class Board {
	// Board is the place to store the locations of the tokens.

	private int boardSize; // Board size is practically the number of players. This is to enable different kimble versions
	private ArrayList<Field> fields = new ArrayList<Field>();
	// MEMO TO SELF! Remember to initialize arraylist before adding objects!

	
	public Board(int size) {
		this.setBoardSize(size);
		this.setFields(size);
	}

	
	/*
	 * Token has a field, which can be on different quadrants (player parts of the board, there might be more or less than 4 players)
	 * Each quadrant has: 
	 * 		7 "public" fields
	 * 			1 mine field
	 * 			6 normal fields
	 * 		4 goal fields where token is still movable but not attainable by other team tokens
	 * 		4 home fields, where tokens cannot be moved elsewhere but to mine field
	 * 
	 * fields are initialized with the board
	 * 
	 * 				
	 */
	private void setFields(int size) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < 4; j++) {
				Field f = new Field(this, Colors.values()[i], Field.Type.HOME, j);
				this.fields.add(f);
			}
			for(int j = 0; j < 4; j++) {
				Field f = new Field(this, Colors.values()[i], Field.Type.GOAL, j);
				this.fields.add(f);
			}
			for(int j = 0; j < 7; j++) {
				Field f = new Field(this, Colors.values()[i], Field.Type.NORMAL, j);
				this.fields.add(f);
			}
		}
	}


	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	public int getBoardSize() {
		return boardSize;
	}

	public Field getFreeHomeField(Colors color) {

		// TODO: the method below could be converted to a function of its own "getVacant(Field.Type)"? or is this only usable in home field search?
		for(Field f : fields) {
			if (f.getType() == Field.Type.HOME && f.isVacant()) {
				return f;
			}
		}
		return null;
	}
	
	
	public void setMine(Player player) {
		// TODO: here or with in player class?
		for(Token token : player.getTokens()) {
			if(token.getField().getType() == Field.Type.HOME) {
				token.setField(this.getMineField(player));
			}
		}
	}
	
	
	public Field getMineField(Player player) {
		for(Field field : this.fields) {
			if(field.getType() == Field.Type.NORMAL 
					&& field.getColor() == player.getColor()
					&& field.getId() == 0) {
				return field;
			}
		}
		return null;
	}





	public void moveToken(Token token, int steps) {
		
	}
	
	// Same as above, but the steps is taken from this.dice. 
	// TODO: which is smarter?
	public void moveToken(Token token) {
		
	}

	
	
	
	
	

}
