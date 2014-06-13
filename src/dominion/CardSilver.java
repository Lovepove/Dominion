package dominion;

public class CardSilver extends TreasureCard {
	private Player activePlayer;
	private int cost;

	public CardSilver(Player activePlayer) {
		super("Silver", activePlayer);	
		this.activePlayer = activePlayer;
		cost = 3;
		
	}
	
	public void play() {
		activePlayer.addGold(2);
	}
	
	public String getName() {
		return new String("Silver");
	}
	
	public int getCost() {
		return cost;
	}
}
