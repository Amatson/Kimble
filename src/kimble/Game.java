package kimble;

import java.util.HashMap;

/*
 * This class takes care of the main functionality of the game. It initializes the gameboard, sets players and 
 * takes care of round organizing.
 * 
 */
public class Game {
	
	
	private Board board;
	private HashMap<Colors, Player> players;
	
	
	/*
	 * Initial: 
	 * 		set number of players
	 * 		get starter and first team to pick color
	 * 		assign colors
	 * 		ask for team names
	 * 
	 * Turns: 
	 * 		get player in turn
	 * 		naks aka throw the dice
	 * 		get movable tokens and their moving options
	 * 			this can be moving, setting mine or raising
	 * 		allow player to select the token to move
	 * 		(if dice == 6 -> naks again)
	 * 		check winning conditions
	 * 		end turn
	 * 		
	 */
	
	
	// Game class constructor
	public Game() {
		// In final state, Game constructor takes the number of players and sets colors accordingly
		
		this.players = new HashMap<Colors, Player>();
		Player redPlayer = new Player(Colors.RED);
		Player bluePlayer = new Player(Colors.BLUE);
		Player greenPlayer = new Player(Colors.GREEN);
		Player yellowPlayer = new Player(Colors.YELLOW);
		this.players.put(Colors.RED, redPlayer);
		this.players.put(Colors.BLUE, bluePlayer);
		this.players.put(Colors.GREEN, greenPlayer);
		this.players.put(Colors.YELLOW, yellowPlayer);
		this.board = new Board(this.players.size());

	}


	public Board getBoard() {
		return board;
	}


	public HashMap<Colors, Player> getPlayers() {
		return players;
	}
	
	public Player getPlayerWithColor(Colors color) {
		
		return getPlayers().get(color);
		
	}
	

}
