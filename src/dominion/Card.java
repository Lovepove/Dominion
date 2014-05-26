package dominion;

public class Card {
	private String displayName;
	private Player activePlayer;
	
	public Card (String displayName, Player activePlayer) {
		this.displayName = displayName;
		this.activePlayer = activePlayer;
	}

	public String display() {
		return displayName;
	}
	
	public Player getPlayer() {
		return activePlayer;
	}

}
