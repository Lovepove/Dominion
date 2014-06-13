package dominion;

public class CardGold extends TreasureCard {
	private Player activePlayer;
	private int cost;

	public CardGold(Player activePlayer) {
		super("Gold", activePlayer);	
		this.activePlayer = activePlayer;
		cost = 6;
		
	}
	
	public void play() {
		activePlayer.addGold(3);
	}
	
	public String getName() {
		return new String("Gold");
	}
	
	public int getCost() {
		return cost;
	}
}
