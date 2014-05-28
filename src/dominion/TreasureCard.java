package dominion;

public class TreasureCard extends Card {
	private Player activePlayer;

	public TreasureCard(String displayName, Player activePlayer) {
		super(displayName, activePlayer);
		this.activePlayer = activePlayer;
	}
	
	public void play() {
		
	}

}
