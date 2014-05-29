package dominion;

public class CardWoodcutter extends ActionCard {
	private Player activePlayer;

	public CardWoodcutter(Player activePlayer) {
		super("Woodcutter", activePlayer);
		this.activePlayer = activePlayer;
	}
	
	public void play() {
		activePlayer.addBuy(1);
		activePlayer.addGold(2);
	}
}
