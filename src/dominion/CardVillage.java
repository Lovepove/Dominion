package dominion;

public class CardVillage extends ActionCard {
	private Player activePlayer;
	private int cost;
	
	public CardVillage(Player activePlayer) {
		super("Village", activePlayer);
		this.activePlayer = activePlayer;
		cost = 3;
	}

	@Override
	public void play() {
		activePlayer.drawCard(1);
		activePlayer.addAction(2);
	}
	
	public String getName() {
		return new String("Village");
	}
	
	public int getCost() {
		return cost;
	}
}
