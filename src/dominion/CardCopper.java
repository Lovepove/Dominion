package dominion;

public class CardCopper extends TreasureCard {
	private Player activePlayer;
	private int cost;

	public CardCopper(String displayName, Player activePlayer) {
		super(displayName, activePlayer);	
		this.activePlayer = activePlayer;
		cost = 0;
		
	}
	
	public void play() {
		activePlayer.addGold(1);
	}
	
	public int getCost() {
		return cost;
	}
}
