package dominion;

public class CardSmithy extends ActionCard implements IAction  {
	private Player activePlayer;
	
	
	public CardSmithy(Player activePlayer) {
		super("Smithy", activePlayer);
		this.activePlayer = activePlayer;
	}

	@Override
	public void play() {
		activePlayer.getDeck().draw();
		activePlayer.getDeck().draw();
		activePlayer.getDeck().draw();
	}
	
	public String getName() {
		return new String("Smithy");
	}
}
