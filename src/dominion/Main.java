package dominion;

public class Main {
	
	public static void main(String[] args) {
		Player player = new Player();
		GameState gameState = new GameState(player);
		player.setGameState(gameState);
//		gameState.testing();
		player.testing();
//		gameState.testing();
	}

}
