package dominion;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> hand;
	private Deck deck;
	
	public Player() {
		deck = new Deck();
		hand = new ArrayList<Card>();
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public void testing() {		
		ActionCard smithy1 = new CardSmithy(this);
		ActionCard smithy2 = new CardSmithy(this);
		ActionCard smithy3 = new CardSmithy(this);
		ActionCard smithy4 = new CardSmithy(this);
		deck.add(smithy1);
		deck.add(smithy2);
		deck.add(smithy3);
		deck.add(smithy4);
		deck.shuffle();
		Card tempCard = deck.draw();
		hand.add(tempCard);
		ActionCard tempActionCard = (ActionCard) hand.get(0);
		tempActionCard.play();
//		System.out.println(hand.size());
	}
	
	public void getHand() {
		for (Card c : hand) {
			System.out.println(c.display());
		}
	}
	
	public void drawCard() {
		
	}
}
