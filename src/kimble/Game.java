package kimble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * This class takes care of the main functionality of the game. It initializes the gameboard, sets players and 
 * takes care of round organizing.
 * 
 */
public class Game {
	
	private Board board;
	private HashMap<Colors, Player> players;
	private int dice = 0;
	
	
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
	public Game(int size) {
		// In final state, Game constructor takes the number of players and sets colors accordingly
		if(size > Colors.values().length) {
			size = Colors.values().length;
	        System.out.println(Colors.values().length + " is the maximum amount of players at this moment. Please add more players manually to Colors.java");
		}
		this.board = new Board(size);
		this.players = new HashMap<Colors, Player>();
		
		for(int i = 0; i < size; i++) {
			Player plr = new Player(Colors.values()[i], this.board);
			this.players.put(Colors.values()[i], plr);
		}
		naks();
		
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


	public void setBoard(Board board) {
		this.board = board;
	}

	
	/*
	 * The next method gets a random dice naks which is not a throw.
	 * In Kimble probabilities of dice return values are not distributed evenly.
	 * The same dice number is returned with about 11% probability.
	 * The opposite dice number is returned with about 24% probability.
	 * Other dice values share the rest of the probabilities (65%)
	 * 
	 * However, as good players know, technique and skills can alter the 
	 * probabilities but this is impossible to simulate programmatically.
	 */
	public int naks() {
		if(this.dice == 0) {
			Random rand = new Random();
			this.dice = rand.nextInt(6)+1;
			return this.dice;
		}
		else {
			Random rand = new Random();
			int P = rand.nextInt(1000);
//			if(P >= 0 && P < 110)
			// This does nothing as it is the probability for unchanging dice number
			if(P >= 110 && P < 350) {
				this.dice = 7 - this.dice;
			}
			else { // 350 < P < 999
				ArrayList<Integer> nums = new ArrayList<Integer>();
				for(int i = 1; i < 7; i++) {
					if(i != this.dice && i != (7-this.dice))
						nums.add(i);
				}
				this.dice = nums.get(rand.nextInt(4));
			}
			return this.dice;
		}
	}


}
