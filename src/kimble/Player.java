package kimble;

import java.util.ArrayList;

/*
 * Player class is to handle the player options and information.
 * Player is actually the team.
 */
public class Player {
	private int teamSize;
	private String name;
	private Colors color;
	private Board board;
	private ArrayList<Token> tokens = new ArrayList<Token>();
	
	public Player(Colors color, Board board) {
		this.setBoard(board);
		this.setColor(color);
		this.setTokens(4); // TODO: in future, get token count from board->game rules section or something
		// TODO: Error handling? Not necessarily
	}

	private void setBoard(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return this.board;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}

	public ArrayList<Token> getTokens() {
		return tokens;
	}

	public void setTokens(int number) {
		for(int i = 0; i < number; i++) {
			Token token = new Token(this.color, this.board);
			this.tokens.add(token);
		}
		
	}
	
	public Token getHomeToken() {
		for(Token token : this.tokens) {
			if(token.getField().getType() == Field.Type.HOME)
				return token;
		}
		return null;
	}
	
	public int countHomeTokens() {
		int count = 0;
		for(Token token : this.tokens) {
			if(token.getField().getType() == Field.Type.HOME)
				count++;
		}
		return count;
	}
	
	public int countGoalTokens() {
		int count = 0;
		for(Token token : this.tokens) {
			if(token.getField().getType() == Field.Type.GOAL)
				count++;
		}
		return count;
	}
	
	
}
