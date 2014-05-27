package dominion;

public class ActionCard extends Card {
	
	private String displayName;
	private Player activePlayer;

	
	public ActionCard(String displayName, Player activePlayer) {
		super(displayName, activePlayer);
	}
	
	public void play() {
		
	}
	
}
