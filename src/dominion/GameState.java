package dominion;

import java.util.ArrayList;
public class GameState {
	private ArrayList<Card> actionCards;
	private ArrayList<Card> victoryCards;
	private ArrayList<Card> treasureCards;

	private Card[] actionCardIndex;
	private Card[] treasureCardIndex;
	private Card[] victoryCardIndex;
	private Player player;
	
	public GameState(Player player) {
		this.player = player;
		actionCards = new ArrayList<Card>();
		victoryCards = new ArrayList<Card>();
		treasureCards = new ArrayList<Card>();
		actionCardIndex = new Card[4];
		victoryCardIndex = new Card[3];
		treasureCardIndex = new Card[3];
		actionCardIndex[0] = new CardVillage(player);
		actionCardIndex[1] = new CardSmithy(player);
		actionCardIndex[2] = new CardMarket(player);
		actionCardIndex[3] = new CardWoodcutter(player);
		victoryCardIndex[0] = new CardEstate(player);
		victoryCardIndex[1] = new CardDuchy(player);
		victoryCardIndex[2] = new CardProvince(player);
		treasureCardIndex[0] = new CardCopper(player);
		treasureCardIndex[1] = new CardSilver(player);
		treasureCardIndex[2] = new CardGold(player);
		for (int i = 0; i < 10; i++) {
			ActionCard card1 = new CardVillage(player);
			actionCards.add(card1);
			ActionCard card2 = new CardSmithy(player);
			actionCards.add(card2);
			ActionCard card3 = new CardMarket(player);
			actionCards.add(card3);
			ActionCard card4 = new CardWoodcutter(player);
			actionCards.add(card4);
			TreasureCard tcard1 = new CardCopper(player);
			treasureCards.add(tcard1);
			TreasureCard tcard2 = new CardSilver(player);
			treasureCards.add(tcard2);
			TreasureCard tcard3 = new CardGold(player);
			treasureCards.add(tcard3);
			VictoryCard vcard1 = new CardEstate(player);
			victoryCards.add(vcard1);
			VictoryCard vcard2 = new CardDuchy(player);
			victoryCards.add(vcard2);
			VictoryCard vcard3 = new CardProvince(player);
			victoryCards.add(vcard3);
		}
		victoryCards.remove(new CardProvince(player));
		victoryCards.remove(new CardProvince(player));

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
	
	public Card gainVictoryCard(int i) {
		Card tempCard = victoryCardIndex[i - 1];
		if (victoryCards.contains(tempCard)) {
			victoryCards.remove(tempCard);
			return tempCard;
		} else {
			return null;
		}
	}
	
	public Card gainTreasureCard(int i) {
		Card tempCard = treasureCardIndex[i - 1];
		if (treasureCards.contains(tempCard)) {
			treasureCards.remove(tempCard);
			return tempCard;
		} else {
			return null;
		}
	}
	
	public Card getActionCard(int i) {
		return actionCardIndex[i - 1];
	}
	
	public Card getTreasureCard(int i) {
		return treasureCardIndex[i - 1];
	}
	
	public Card getVictoryCard(int i) {
		return victoryCardIndex[i - 1];
	}
	
	public void getActionCards() {
		int[] cardHistogram = new int[4];
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
	
	public void getTreasureCards() {
		int[] cardHistogram = new int[3];
		int i = 0;
		for (Card c : treasureCards) {
			for(Card cr : treasureCardIndex) {
				if (c.display().equals(cr.display())) {
					cardHistogram[i]++;
				}
				i++;
			}
			i = 0;
		}
		int k = 0;
		for (int j : cardHistogram) {
			System.out.println("#" + (k + 1) + " " + treasureCardIndex[k].display() + " " + j);
			k++;
		}
	}
	
	public void getVictoryCards() {
		int[] cardHistogram = new int[3];
		int i = 0;
		for (Card c : victoryCards) {
			for(Card cr : victoryCardIndex) {
				if (c.display().equals(cr.display())) {
					cardHistogram[i]++;
				}
				i++;
			}
			i = 0;
		}
		int k = 0;
		for (int j : cardHistogram) {
			System.out.println("#" + (k + 1) + " " + victoryCardIndex[k].display() + " " + j);
			k++;
		}
	}
	
	public boolean checkGameEnd() {
		if (victoryCards.contains(new CardProvince(player)) == false) {
			return true;
		}
		ArrayList<Card> endGameChecker = new ArrayList<Card>();
		for (Card c : victoryCards) {
			if (endGameChecker.contains(c) == false ) {
				endGameChecker.add(c);
			}
		}
		for (Card c : actionCards) {
			if (endGameChecker.contains(c) == false ) {
				endGameChecker.add(c);
			}
		}
		for (Card c : treasureCards) {
			if (endGameChecker.contains(c) == false ) {
				endGameChecker.add(c);
			}
		}
		if (endGameChecker.size() < 7) {
			return true;
		} else {
			return false;
		}
	}
}
