package com.poker.poker;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PokerApplicationTests {

	@Test
	public void testStraightFlush() {

		Game game = new Game();

		// play game
		game.play();

	}

}
