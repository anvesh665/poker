package com.poker.poker;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

	private final int HAND_SIZE = 5;
	private int again = 1;

	// instantiate Deck and Player
	Scanner scan = new Scanner(System.in);
	Deck deck = new Deck();
	Player player = new Player();
	Card[] hand;

	// plays the game
	public void play() {
		while (again == 1) {
			// fill deck
			deck.fillDeck();

			// shuffle
			deck.shuffle();

			// player draws
			hand = player.draw(deck);

			// sort hand
			Arrays.sort(hand);

			// player redraws
			this.checkHand();

			// sort hand
			Arrays.sort(hand);

			// evaluate the hand
			this.evaluate();

			// play again?
			this.again();
		}
		System.out.println("Thanks for playing! =]");
	}

	// makes a hand (testing purposes)
	public void makeHand() {
		hand[0].rank = 1;
		hand[1].rank = 2;
		hand[2].rank = 3;
		hand[3].rank = 4;
		hand[4].rank = 5;

		hand[0].suit = 1;
		hand[1].suit = 1;
		hand[2].suit = 1;
		hand[3].suit = 1;
		hand[4].suit = 1;
	}

	// tells player cards in hand
	public void checkHand() {
		System.out.println("Your Hand: ");
		for (int handCounter = 0; handCounter < HAND_SIZE; handCounter++) {
			this.display(hand[handCounter]);
		}
	}

	// evaluates the hand
	public void evaluate() {
		System.out.print("You Have:");

		if (this.straightFlush() == 1) {
			System.out.println("straight flush!");
		} else if (this.fourOfaKind() == 1) {
			System.out.println("four of a kind!");
		} else if (this.fullHouse() == 1) {
			System.out.println("full house!");
		} else if (this.flush() == 1) {
			System.out.println("flush!");
		} else if (this.straight() == 1) {
			System.out.println("straight!");
		} else if (this.triple() == 1) {
			System.out.println("Three of a kind!");
		} else if (this.twoPairs() == 1) {
			System.out.println("two pairs!");
		} else if (this.pair() == 1) {
			System.out.println("pair!");
		} else {
			int highCard = this.highCard();
			System.out.println("Your highest card is " + highCard);
		}
	}

	// checks for a straight flush
	public int straightFlush() {
		for (int i = 1; i < 5; i++) {
			if (hand[0].suit != hand[i].suit) {
				return 0;
			}
		}
		for (int j = 1; j < 5; j++) {
			if (hand[j - 1].rank != (hand[j].rank - 1)) {
				return 0;
			}

		}
		return 1;

	}

	// checks for four of a kind
	public int fourOfaKind() {
		if (hand[0].rank != hand[3].rank && hand[1].rank != hand[4].rank) {
			return 0;
		} else {
			return 1;
		}
	}

	// checks for full house
	public int fullHouse() {
		int comparison = 0;
		for (int counter = 1; counter < 5; counter++) {
			if (hand[counter - 1].rank == hand[counter].rank) {
				comparison++;
			}
		}
		if (comparison == 3) {
			return 1;
		} else {
			return 0;
		}
	}

	// checks for flush
	public int flush() {
		for (int i = 1; i < 5; i++) {
			if (hand[0].suit != hand[i].suit) {
				return 0;
			}
		}
		return 1;
	}

	// check for straight
	public int straight() {
		for (int j = 1; j < 5; j++) {
			if (hand[j - 1].rank != (hand[j].rank - 1)) {
				return 0;
			}

		}
		return 1;
	}

	// checks for three of a kind
	public int triple() {
		if (hand[0].rank == hand[2].rank || hand[2].rank == hand[4].rank) {
			return 1;
		}
		return 0;
	}

	// checks for two pairs
	public int twoPairs() {
		int check = 0;
		for (int i = 1; i < 5; i++) {
			if (hand[i - 1].rank == hand[i].rank) {
				check++;
			}
		}
		if (check == 2) {
			return 1;
		} else {
			return 0;
		}
	}

	// check for pair
	public int pair() {
		int check = 0;
		for (int i = 1; i < 5; i++) {
			if (hand[i - 1].rank == hand[i].rank) {
				check++;
			}
		}
		if (check == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	// find highest card
	public int highCard() {
		int highCard = 0;
		for (int i = 0; i < 5; i++) {
			if (hand[i].rank > highCard) {
				highCard = hand[i].rank;
			}
		}
		return highCard;
	}

	// asks user if they want to play again
	public void again() {
		again = scan.nextInt();
	}

	// generates string for each card in hand
	public void display(Card card) {

		if (card.rank == 1) {
			System.out.print("Ace of ");
		}
		if (card.rank == 2) {
			System.out.print("Two of ");
		}
		if (card.rank == 3) {
			System.out.print("Three of ");
		}
		if (card.rank == 4) {
			System.out.print("Four of ");
		}
		if (card.rank == 5) {
			System.out.print("Five of ");
		}
		if (card.rank == 6) {
			System.out.print("Six of ");
		}
		if (card.rank == 7) {
			System.out.print("Seven of ");
		}
		if (card.rank == 8) {
			System.out.print("Eight of ");
		}
		if (card.rank == 9) {
			System.out.print("Nine of ");
		}
		if (card.rank == 10) {
			System.out.print("Ten of ");
		}
		if (card.rank == 11) {
			System.out.print("Jack of ");
		}
		if (card.rank == 12) {
			System.out.print("Queen of ");
		}
		if (card.rank == 13) {
			System.out.print("King of ");
		}
		if (card.suit == 1) {
			System.out.print("\u2660");
			System.out.println();
		}
		if (card.suit == 2) {
			System.out.print("\u2665");
			System.out.println();
		}
		if (card.suit == 3) {
			System.out.print("\u2666");
			System.out.println();
		}
		if (card.suit == 4) {
			System.out.print("\u2663");
			System.out.println();
		}

	}
}

