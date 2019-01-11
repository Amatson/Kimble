package kimble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class KimbleTest {
	
	public int teams = 7;
	public int tokens = 4;
	
	@Test
	public void testGameInitialization() {
		System.out.println("Hello World! This is Kimble testing!");
		Game game = new Game(teams);
		assertEquals(teams, game.getBoard().getBoardSize());
		assertEquals(tokens, game.getPlayerWithColor(Colors.RED).countHomeTokens());
		assertEquals(Field.Type.HOME, game.getPlayerWithColor(Colors.BLUE).getHomeToken().getField().getType());

		}
	
	@Test
	public void testNaks() {
		Game game = new Game(teams);
		for(int i = 0; i < 20; i++) {
			int naks = game.naks();
			assertTrue("Error, naks is too high", naks < 7);
			assertTrue("Error, naks is too low", naks > 0);
		}
	
	}
	
//	@Test
//	public void testMoving() {
//		Game game = new Game(teams);
//		
//
//	}
	
	

}
