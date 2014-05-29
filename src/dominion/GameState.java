package dominion;

public class GameState {
	private Card[] activeCards;
	private VictoryCard[] victoryCards;
	private TreasureCard[] treasureCards;
	private int[] numberActiveCards;
	private int[] numberActiveVictoryCards;
	private int[] numberActiveTreasureCards;
	private Player player;
	
	public GameState(Player player) {
		this.player = player;
		activeCards = new Card[10];
		victoryCards = new VictoryCard[3];
		treasureCards = new TreasureCard[3];
		numberActiveCards = new int[10];
		numberActiveVictoryCards = new int[3];
		numberActiveTreasureCards = new int[3];
		
		
	}
	
	public void getActiveCards() {
		for (Card c : activeCards) {
			
		}
	}
	
	public Card gainCard(int i) {
		
	}

}
