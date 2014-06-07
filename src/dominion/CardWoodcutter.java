package dominion;

public class CardWoodcutter extends ActionCard {
	private Player activePlayer;
	private int cost;

	public CardWoodcutter(Player activePlayer) {
		super("Woodcutter", activePlayer);
		this.activePlayer = activePlayer;
		cost = 3;
	}
	
	public void play() {
		activePlayer.addBuy(1);
		activePlayer.addGold(2);
	}
	
	public int getCost() {
		return cost;
	}
}
