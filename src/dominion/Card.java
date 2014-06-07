package dominion;

public class Card {
	private String displayName;
	private Player activePlayer;
	private int cost;
	
	public Card (String displayName, Player activePlayer) {
		this.displayName = displayName;
		this.activePlayer = activePlayer;
	}

	public String display() {
		return displayName;
	}
	
	public int getCost() {
		return cost;
	}
	
	public Player getPlayer() {
		return activePlayer;
	}
	
	@Override
	public boolean equals(Object o) {
		Card card = (Card) o;
		if (this.displayName.equals(card.display())) {
			return true;
		} else {
			return false;
		}
	}
}
