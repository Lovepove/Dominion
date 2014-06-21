package dominion;

import java.util.ArrayList;
import java.util.Iterator;
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
	
	public void testing() {
		startGame();
		System.out.println(getVictoryPoints());
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
		while (deck.isEmpty() == false) {
			tempCardList.add(deck.pop());
		}
		for (int i = tempCardList.size(); i > 0; i--) {
			int random = rand.nextInt(tempCardList.size());
			Card tempCard = tempCardList.get(random);
			tempCardList.remove(random);
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
	
	public int getHandSize() {
		return hand.size();
	}
	
	public void getHand() {
		int i = 0;
		for (Card c : hand) {
			System.out.println("#" + i + " " + c.display());
			i++;
		}
	}
	
	public void getDeck() {
		System.out.println("Printing deck");
		Stack<Card> tempDeck = (Stack<Card>) deck.clone();
		while (tempDeck.isEmpty() == false) {
			Card tempCard = (Card) tempDeck.pop();
			System.out.println(tempCard.display());
		}
	}
	
	public void getActiveCards() {
		System.out.println("Printing active cards");
		for (Card c : activeCards) {
			System.out.println(c.display());
		}
	}
	
	public void getGraveyard() {
		System.out.println("Printing graveyard");
		Stack<Card> tempDeck = (Stack<Card>) graveyard.clone();
		while (tempDeck.isEmpty() == false) {
			Card tempCard = (Card) tempDeck.pop();
			System.out.println(tempCard.display());
		}
	}
	
	private void gainActionCard(int i) {
		Card tempCard = gameState.gainActionCard(i);
		add(tempCard);
	}
	
	private void gainVictoryCard(int i) {
		Card tempCard = gameState.gainVictoryCard(i);
		add(tempCard);
	}
	
	private void gainTreasureCard(int i) {
		Card tempCard = gameState.gainTreasureCard(i);
		add(tempCard);
	}
	
	public boolean buyActionCard(int i) {
		Card tempCard = gameState.getActionCard(i);
		if (tempCard.getCost() <= gold && buys > 0) {
			gainActionCard(i);
			buys--;
			gold = gold - tempCard.getCost();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean buyVictoryCard(int i) {
		Card tempCard = gameState.getVictoryCard(i);
		if (tempCard.getCost() <= gold && buys > 0) {
			gainVictoryCard(i);
			buys--;
			gold = gold - tempCard.getCost();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean buyTreasureCard(int i) {
		Card tempCard = gameState.getTreasureCard(i);
		if (tempCard.getCost() <= gold && buys > 0) {
			gainTreasureCard(i);
			buys--;
			gold = gold - tempCard.getCost();
			return true;
		} else {
			return false;
		}
	}

	public void play(int i) {
		if (ActionCard.class.isAssignableFrom(hand.get(i).getClass()) && actions > 0) {
			ActionCard tempCard = (ActionCard) hand.get(i);
			hand.remove(i);
			tempCard.play();
			activeCards.add(tempCard);
			actions--;
		} else if (TreasureCard.class.isAssignableFrom(hand.get(i).getClass())) {
			TreasureCard tempCard = (TreasureCard) hand.get(i);
			hand.remove(i);
			tempCard.play();
			activeCards.add(tempCard);			
		} else {
			System.out.println("That card cannot be played");
		}
	}
	
	public void playAllTreasureCards() {
		Iterator<Card> itr = hand.iterator();
		while (itr.hasNext()) {
			Card c = itr.next();
			if (TreasureCard.class.isAssignableFrom(c.getClass())) {
				TreasureCard tc = (TreasureCard) c;
				activeCards.add(tc);
				tc.play();
				itr.remove();
			}
		}
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	

	public void startGame() {
		for (int i = 0; i < 7; i++) {
			Card tempCopperCard = new CardCopper(this);
			add(tempCopperCard);
		}
		for (int i = 0; i < 3; i++) {
			Card tempEstateCard = new CardEstate(this);
			add(tempEstateCard);
		}
		while (hand.size() < 5) {
			drawCard(1);
		}
	}
	
	public void startRound() {
		actions = 1;
		buys = 1;
		gold = 0;
	}
	
	public void endRound() {
		for (Card c : activeCards) {
			graveyard.push(c);
		}
		activeCards.clear();
		discardHand();
		while (hand.size() < 5) {
			drawCard(1);
		}
	}
	
	private void discardHand() {
		for (Card c : hand) {
			graveyard.push(c);
		}
		hand.clear();
	}

	public int getVictoryPoints() {
		ArrayList<Card> tempHand = (ArrayList<Card>) hand.clone();
		ArrayList<Card> tempActiveCards = (ArrayList<Card>) activeCards.clone();
		Stack<Card> tempGraveyard = (Stack<Card>) graveyard.clone();
		Stack<Card> tempDeck = (Stack<Card>) deck.clone();
		int victoryPoints = 0;
		while (tempDeck.isEmpty() == false) {
			Card tempCard = tempDeck.pop();
			if (tempCard instanceof VictoryCard) {
				VictoryCard vc = (VictoryCard) tempCard;
				victoryPoints = victoryPoints += vc.getVictoryPoints();
			}
		}
		while (tempGraveyard.isEmpty() == false) {
			Card tempCard = tempGraveyard.pop();
			if (tempCard instanceof VictoryCard) {
				VictoryCard vc = (VictoryCard) tempCard;
				victoryPoints = victoryPoints += vc.getVictoryPoints();
			}
		}
		for (Card c : tempHand) {
			Card tempCard = c;
			if (tempCard instanceof VictoryCard) {
				VictoryCard vc = (VictoryCard) tempCard;
				victoryPoints = victoryPoints += vc.getVictoryPoints();
			}

		}
		for (Card c : tempActiveCards) {
			Card tempCard = c;
			if (tempCard instanceof VictoryCard) {
				VictoryCard vc = (VictoryCard) tempCard;
				victoryPoints = victoryPoints += vc.getVictoryPoints();
			}
		}
		return victoryPoints;
	}
}
