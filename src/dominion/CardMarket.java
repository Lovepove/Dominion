package dominion;

public class CardMarket extends ActionCard {
	private Player activePlayer;
	private int cost;


	public CardMarket(Player activePlayer) {
		super("Market", activePlayer);
		this.activePlayer = activePlayer;
		cost = 5;
	}
	
	public void play() {
		activePlayer.drawCard();
		activePlayer.addAction(1);
		activePlayer.addBuy(1);
		activePlayer.addGold(1);
	}
	
	public int getCost() {
		return cost;
	}
}
