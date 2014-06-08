package dominion;

public class CardDuchy extends VictoryCard {
	private Player activePlayer;
	private int cost;
	private int victoryPoints;


	public CardDuchy(Player activePlayer) {
		super("Duchy", activePlayer);
		this.activePlayer = activePlayer;
		victoryPoints = 3;
		cost = 5;
	}
	
	public String getName() {
		return new String("Duchy");
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getVictoryPoints() {
		return victoryPoints;
	}


}
