package com.poker.poker;

public class Card implements Comparable<Card> {
	// suit and rank
	public int suit;
	public int rank;

	public int compareTo(Card o) {
		if (this.rank == (o.rank))
			return 0;
		else if ((this.rank) > (o.rank))
			return 1;
		else
			return -1;
	}

}
