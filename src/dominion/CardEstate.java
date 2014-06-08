package dominion;

public class CardEstate extends VictoryCard {
	private Player activePlayer;
	private int cost;
	private int victoryPoints;


	public CardEstate(Player activePlayer) {
		super("Estate", activePlayer);
		this.activePlayer = activePlayer;
		victoryPoints = 1;
		cost = 2;
	}
	
	public String getName() {
		return new String("Estate");
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getVictoryPoints() {
		return victoryPoints;
	}


}
