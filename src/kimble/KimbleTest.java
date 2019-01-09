package kimble;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class KimbleTest {
	
	@Test
	public void test() {
		Game game = new Game();
		assertEquals(4, game.getBoard().getBoardSize());
		
	}

}
