package dominion;

public class CardMarket extends ActionCard {
	private Player activePlayer;

	public CardMarket(Player activePlayer) {
		super("Market", activePlayer);
		this.activePlayer = activePlayer;
	}
	
	public void play() {
		activePlayer.drawCard(1);
		activePlayer.addAction(1);
		activePlayer.addBuy(1);
		activePlayer.addGold(1);
	}
}
