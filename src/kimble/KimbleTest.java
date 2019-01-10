package kimble;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class KimbleTest {
	
	@Test
	public void testGameInitialization() {
		System.out.println("Hello World! This is Kimble testing!");
		Game game = new Game(4);
		assertEquals(4, game.getBoard().getBoardSize());
		assertEquals(4, game.getPlayerWithColor(Colors.RED).countHomeTokens());
		assertEquals(Field.Type.HOME, game.getPlayerWithColor(Colors.BLUE).getHomeToken().getField().getType());
		for(int i = 0; i < 10; i++) {
			int naks = game.naks();
			assertTrue("Error, naks is too high", naks < 7);
			assertTrue("Error, naks is too low", naks > 0);
		}
	
		
	}

}
