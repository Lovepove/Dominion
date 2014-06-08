package dominion;

public class CardCopper extends TreasureCard {
	private Player activePlayer;
	private int cost;

	public CardCopper(Player activePlayer) {
		super("Copper", activePlayer);	
		this.activePlayer = activePlayer;
		cost = 0;
		
	}
	
	public void play() {
		activePlayer.addGold(1);
	}
	
	public String getName() {
		return new String("Copper");
	}
	
	public int getCost() {
		return cost;
	}
}
