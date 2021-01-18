package com.poker.poker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokerApplication.class, args);
		
		// make game
				Game game = new Game();

				// play game
				game.play();
	}

}
