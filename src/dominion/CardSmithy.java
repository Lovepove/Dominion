package dominion;

public class CardSmithy extends ActionCard implements IAction  {
	Player activePlayer;
	
	
	public CardSmithy(Player player) {
		super(new String("Smithy"), player);
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
