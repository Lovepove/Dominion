package dominion;

public class CardProvince extends VictoryCard {
//	private Player activePlayer;
	private int cost;
	private int victoryPoints;


	public CardProvince(Player activePlayer) {
		super("Province", activePlayer);
//		this.activePlayer = activePlayer;
		victoryPoints = 6;
		cost = 8;
	}
	
	public String getName() {
		return new String("Province");
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getVictoryPoints() {
		return victoryPoints;
	}


}
