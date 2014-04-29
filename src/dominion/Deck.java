package dominion;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck;
	private ArrayList<Card> graveyard;
	private ArrayList<Card> activeCards;

	
	public Deck() {
		graveyard = new ArrayList<Card>();
		deck = new ArrayList<Card>();
		activeCards = new ArrayList<Card>();
	}
	
	public void shuffle() {
		for (Card c : graveyard) {
			deck.add(c);
		}
		graveyard.clear();
		for (int i = 0; i < deck.size(); i++) {
			
		}
		
	}
	
	public Card draw() {
		return null;
	}
	
	public void add(Card card) {
		
	}

}
