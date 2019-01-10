package kimble;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class KimbleTest {
	
	@Test
	public void testGameInitialization() {
		Game game = new Game(4);
		assertEquals(4, game.getBoard().getBoardSize());
		assertEquals(4, game.getPlayerWithColor(Colors.RED).countHomeTokens());
		assertEquals(Field.Type.HOME, game.getPlayerWithColor(Colors.BLUE).getHomeToken().getField().getType());
	}

}
