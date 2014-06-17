package dominion;

public class Main {
	
	public static void main(String[] args) {
//		Player player = new Player();
//		GameState gameState = new GameState(player);
//		player.setGameState(gameState);
//		player.testing();
//		gameState.testing();
		GameManager gameManager = new GameManager();
		gameManager.startGame();
	}

}
