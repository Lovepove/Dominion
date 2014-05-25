package dominion;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck;
	private ArrayList<Card> graveyard;
	private ArrayList<Card> activeCards;

	
	public Deck() {
		graveyard = new ArrayList<Card>();
		deck = new Stack<Card>();
		activeCards = new ArrayList<Card>();
	}
	
	public void shuffle() {
		for (Card c : graveyard) {
			deck.push(c);
			System.out.println("added card to graveyard");
		}
		graveyard.clear();
		System.out.println("Graveyard cleared");

	}
	
	public Card draw() {
		return deck.pop();
	}
	
	public void add(Card card) {
		graveyard.add(card);
		
	}
	
	public int size() {
		return deck.size();
	}
}
