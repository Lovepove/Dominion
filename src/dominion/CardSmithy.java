package dominion;

public class CardSmithy extends ActionCard {
	private Player activePlayer;
	private int cost;

	public CardSmithy(Player activePlayer) {
		super("Smithy", activePlayer);
		this.activePlayer = activePlayer;
		cost = 4;
	}

	@Override
	public void play() {
		activePlayer.drawCard(3);
	}
	
	public String getName() {
		return new String("Smithy");
	}
	
	public int getCost() {
		return cost;
	}
}
