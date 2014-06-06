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
	private GameState gameState;

	public Player() {
		hand = new ArrayList<Card>();
		activeCards = new ArrayList<Card>();
		deck = new Stack<Card>();
		graveyard = new Stack<Card>();
	}
	
	public void addAction(int actionsIncrease) {
		actions = actionsIncrease + actions;
	}
	
	public void addBuy(int buysIncrease) {
		buys = buysIncrease + buys;
	}
	
	public void addGold(int goldIncrease) {
		gold = goldIncrease + gold;
	}
	
	public void drawCard(int cards) {
		if (deck.size() == 0) {
			shuffleDeck();
		}
		if (deck.size() != 0) {
			for (int i = 0; i < cards; i++) {
				Card drawnCard = deck.pop();
				hand.add(drawnCard);
			}
		} else {
			System.out.println("Leken är tom!");
		}
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
	
	// Tror inte jag kommer behöva dessa men vi får se
	public int getAction() {
		return actions;
	}
	
	public int getBuy() {
		return buys;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void getGold(int goldIncrease) {
		gold = goldIncrease + gold;
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
	
	public void gainCard(int i) {
		
	}

	public void play(int i) {
		if (ActionCard.class.isAssignableFrom(hand.get(i).getClass()) && actions != 0) {
			ActionCard tempCard = (ActionCard) hand.get(i);
			tempCard.play();
			hand.remove(i);
			activeCards.add(tempCard);
			actions--;
		} else if (TreasureCard.class.isAssignableFrom(hand.get(i).getClass())) {
			TreasureCard tempCard = (TreasureCard) hand.get(i);
			tempCard.play();
			hand.remove(i);
			activeCards.add(tempCard);			
		}
	}
	
	public void testing() {
		gainCard(0);
		drawCard(1);
		getHand();
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	private void startGame() {
		for (int i = 0; i < 7; i++) {
			
		}
	}
	
	private void startRound() {
		actions = 1;
		buys = 1;
		gold = 0;
		while (hand.size() > 5) {
			drawCard(1);
		}
	}
	
	private void endRound() {
		for (Card c : activeCards) {
			graveyard.push(c);
		}
	}
}
