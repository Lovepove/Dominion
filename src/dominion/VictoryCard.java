package dominion;

public class VictoryCard extends Card {
	private Player activePlayer;

	public VictoryCard(String displayName, Player activePlayer) {
		super(displayName, activePlayer);
		this.activePlayer = activePlayer;
	}
}
