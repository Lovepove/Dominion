package dominion;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class GameState {
	private ArrayList<Card> actionCards;
	private ArrayList<Card> victoryCards;
	private ArrayList<Card> treasureCards;

	private Card[] actionCardIndex;
	private Player player;
	
	public GameState(Player player) {
		this.player = player;
		actionCards = new ArrayList<Card>();
		victoryCards = new ArrayList<Card>();
		treasureCards = new ArrayList<Card>();
		actionCardIndex = new Card[3];
		actionCardIndex[0] = new CardVillage(player);
		actionCardIndex[1] = new CardSmithy(player);
		actionCardIndex[2] = new CardMarket(player);
		for (int i = 0; i < 10; i++) {
			ActionCard card1 = new CardVillage(player);
			actionCards.add(card1);
			ActionCard card2 = new CardSmithy(player);
			actionCards.add(card2);
			ActionCard card3 = new CardMarket(player);
			actionCards.add(card3);
		}
	}
	
	public void testing() {
		getActionCards();
	}
	
	public Card gainActionCard(int i) {
		Card tempCard = actionCardIndex[i - 1];
		if (actionCards.contains(tempCard)) {
			actionCards.remove(tempCard);
			return tempCard;
		} else {
			return null;
		}
	}
	
	public Card getActionCard(int i) {
		return actionCardIndex[i - 1];
	}
	
	public void getActionCards() {
		int[] cardHistogram = new int[3];
		int i = 0;
		for (Card c : actionCards) {
			for(Card cr : actionCardIndex) {
				if (c.display().equals(cr.display())) {
					cardHistogram[i]++;
				}
				i++;
			}
			i = 0;
		}
		int k = 0;
		for (int j : cardHistogram) {
			System.out.println("#" + (k + 1) + " " + actionCardIndex[k].display() + " " + j);
			k++;
		}
	}
}
