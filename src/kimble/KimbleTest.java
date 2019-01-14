package kimble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class KimbleTest {
	
	public int teams = 4;
	public int tokens = 4;
	
	@Test
	public void testGameInitialization() {
		System.out.println("Hello World! This is Kimble testing!");
		Game game = new Game(teams);
		assertEquals(teams, game.getBoard().getBoardSize());
		assertEquals(tokens, game.getPlayerWithColor(Colors.RED).countHomeTokens());
		assertEquals(Field.Type.HOME, game.getPlayerWithColor(Colors.BLUE).getHomeToken().getField().getType());
		assertEquals(0, game.getBoard().getMineField(game.getPlayerWithColor(Colors.RED)).getId());
		assertEquals(Field.Type.NORMAL, game.getBoard().getMineField(game.getPlayerWithColor(Colors.RED)).getType());

		}
	
	@Test
	public void testNaks() {
		Game game = new Game(teams);
		assertTrue("Error, pop'o'matic has not been reset", game.getDice() != 0);
		assertTrue("Error, pop'o'matic has not been reset to non-six", game.getDice() != 6);
		for(int i = 0; i < 20; i++) {
			int naks = game.naks();
			assertTrue("Error, naks is too high", naks < 7);
			assertTrue("Error, naks is too low", naks > 0);
		}
	
	}
	
	@Test
	public void testMoving() {
		Game game = new Game(teams);
		assertEquals(0, game.getBoard().getMineField(game.getPlayerWithColor(Colors.RED)).getId());
		assertEquals(Field.Type.NORMAL, game.getBoard().getMineField(game.getPlayerWithColor(Colors.RED)).getType());

	}
	
	@Test
	public void testPlayerTurns() {
		Game game = new Game(4);
		game.setPlayerInTurn(game.getPlayerWithColor(Colors.RED));
		game.setNextPlayerInTurn();
		assertEquals(Colors.BLUE, game.getPlayerInTurn().getColor());
		game.setNextPlayerInTurn();
		assertEquals(Colors.YELLOW, game.getPlayerInTurn().getColor());		
		game.setNextPlayerInTurn();
		assertEquals(Colors.GREEN, game.getPlayerInTurn().getColor());
		game.setNextPlayerInTurn();
		assertEquals(Colors.RED, game.getPlayerInTurn().getColor());		
		game.setNextPlayerInTurn();
		assertEquals(Colors.BLUE, game.getPlayerInTurn().getColor());		}
	

}
