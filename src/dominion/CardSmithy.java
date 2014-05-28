package dominion;

public class CardSmithy extends ActionCard {
	private Player activePlayer;
	
	
	public CardSmithy(Player activePlayer) {
		super("Smithy", activePlayer);
		this.activePlayer = activePlayer;
	}

	@Override
	public void play() {
		activePlayer.drawCard(3);
	}
	
	public String getName() {
		return new String("Smithy");
	}
}
