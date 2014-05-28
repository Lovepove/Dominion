package dominion;

public class CardVillage extends ActionCard {
	private Player activePlayer;
	
	
	public CardVillage(Player activePlayer) {
		super("Village", activePlayer);
		this.activePlayer = activePlayer;
	}

	@Override
	public void play() {
		activePlayer.drawCard(1);
		activePlayer.addAction(2);
	}
	
	public String getName() {
		return new String("Village");
	}
}
