package dominion;

public class CardCopper extends TreasureCard {
	private Player activePlayer;

	public CardCopper(String displayName, Player activePlayer) {
		super(displayName, activePlayer);	
		this.activePlayer = activePlayer;
		
	}
	
	public void play() {
		activePlayer.addGold(1);
	}
}
