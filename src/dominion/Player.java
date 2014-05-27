package dominion;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Player {
	
	private ArrayList<Card> hand;
	private ArrayList<Card> activeCards;
	private Stack<Card> graveyard;
	private Stack<Card> deck;
	private int actions;
	private int buys;
	private int gold;
	private int victoryPoints;

	public Player() {
		hand = new ArrayList<Card>();
		activeCards = new ArrayList<Card>();
		deck = new Stack<Card>();
		graveyard = new Stack<Card>();
	}
	
	public void addAction() {
		actions++;
	}
	
	public void addBuy() {
		buys++;
	}
	
	public void addGold(int i) {
		gold = gold + i;
	}
	
	public void shuffleDeck() {
		Random rand = new Random();
		ArrayList<Card> tempCardList = new ArrayList<Card>();
		while (graveyard.isEmpty() == false) {
			tempCardList.add(graveyard.pop());
		}
		for (int i = 0; i < tempCardList.size(); i++) {
			int random = rand.nextInt(tempCardList.size());
			Card tempCard = tempCardList.get(random);
			deck.push(tempCard);
		}
	}
	
	public void add(Card card) {
		graveyard.push(card);	
	}
	
	public void getHand() {
		int i = 0;
		for (Card c : hand) {
			System.out.println("#" + i + " " + c.display());
			i++;
		}
	}
	
	public void getDeck() {
		Stack<Card> tempDeck = (Stack<Card>) deck.clone();
		while (tempDeck.isEmpty() == false) {
			Card tempCard = (Card) tempDeck.pop();
			System.out.println(tempCard.display());
		}
	}
	
	public void getActiveCards() {
		for (Card c : activeCards) {
			System.out.println(c.display());
		}
	}
	
	public void drawCard() {
		if (deck.size() == 0) {
			shuffleDeck();
		}
		if (deck.size() != 0) {
			Card drawnCard = deck.pop();
			hand.add(drawnCard);
		} else {
			System.out.println("Leken är tom!");
		}

	}
	
	public void play(int i) {
		if (TreasureCard.class.isAssignableFrom(hand.get(i).getClass())) {
			
		}
		if (ActionCard.class.isAssignableFrom(hand.get(i).getClass()) && actions != 0) {
			ActionCard tempCard = (ActionCard) hand.get(i);
			tempCard.play();
			hand.remove(i);
			activeCards.add(tempCard);
			actions--;
		}

		if (VictoryCard.class.isAssignableFrom(hand.get(i).getClass())) {
			
		}		
	}
	
	public void testing() {		
		ActionCard smithy1 = new CardSmithy(this);
		ActionCard smithy2 = new CardSmithy(this);
		ActionCard smithy3 = new CardSmithy(this);
		ActionCard smithy4 = new CardSmithy(this);
		add(smithy1);
		add(smithy2);
		add(smithy3);
		add(smithy4);
		addAction();
		drawCard();
		play(0);
		getHand();
	}
	
	private void startRound() {
		actions = 1;
		buys = 1;
		gold = 0;
		while (hand.size() > 5) {
			drawCard();
		}
	}
	
	private void endRound() {
		for (Card c : activeCards) {
			graveyard.push(c);
		}
	}
}
