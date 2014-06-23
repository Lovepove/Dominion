package dominion;

import java.util.Scanner;

public class GameManager {
	private GameState gameState;
	Player player;
	private int phase;
	Scanner keyboard;
	
	public GameManager () {
		player = new Player();
		gameState = new GameState(player);
		player.setGameState(gameState);
	}
	
	public void startGame() {
		player.startGame();
		while (gameState.checkGameEnd() == false) {
			phase = 1;
			player.startRound();
			// Actionphase
			while (phase == 1) {
				actionPhaseSelection();
				System.out.println("#4 DEBUG Get Deck");
				System.out.println("#5 DEBUG Get ActiveCards");
				System.out.println("#6 DEBUG Get Graveyard");
				keyboard = new Scanner(System.in);
				int selection = keyboard.nextInt();
				if (selection == 1) {
					player.getHand();
				} else if (selection == 2) {
					player.getHand();
					System.out.println("#" + (player.getHandSize()) + " Go Back");
					System.out.println("Which card would you like to play?");
					selection = keyboard.nextInt();
					if (selection > (player.getHandSize())) {
						//Go back
					} else {
						boolean playedCard = player.play(selection, 1);
						if (playedCard) {
							System.out.println("You played your card");
						} else {
							System.out.println("You can't play that card");
						}
					}
				} else if (selection == 3) {
					phase = 2;
				} else if (selection == 4) {
					player.getDeck();
				} else if (selection == 5) {
					player.getActiveCards();
				} else if (selection == 6) {
					player.getGraveyard();
				} else {
					System.out.println("You can only input 1 - 6, dumbass!");
				}
			}
			// Playcoinphase
			while (phase == 2) {
				playCoinPhaseSelection();
				keyboard = new Scanner(System.in);
				int selection = keyboard.nextInt();
				if (selection == 1) {
					player.getHand();
				} else if (selection == 2) {
					player.playAllTreasureCards();
					System.out.println("You have " + player.getGold() + " Gold");
				} else if (selection == 3) {
					phase = 3;
				} else {
					System.out.println("You can only input 1 - 3, dumbass!");
				}
			}
			// Buyphase
			while (phase == 3) {
				buyCardPhaseSelection();
				System.out.println("Your gold is " + player.getGold());
				keyboard = new Scanner(System.in);
				int selection = keyboard.nextInt();
				if (selection == 1) {
					System.out.println("Action Cards");
					gameState.getActionCards(); 
					System.out.println("Treasure Cards");
					gameState.getTreasureCards();
					System.out.println("Victory Cards");
					gameState.getVictoryCards();
				} else if (selection ==2) {
					System.out.println("Which action card would you like to buy? Insert number");
					gameState.getActionCards();
					System.out.println("#5 Go Back");
					selection = keyboard.nextInt();
					if (selection == 5) {
						//Go back
					} else {
						if (selection < 5) {
							boolean success = player.buyActionCard(selection);
							if (success) {
								System.out.println("You bought a card");
							} else {
								System.out.println("Insufficient gold to buy that card");
							}								
						} else {
							System.out.println("You can only input 1 - 5, dumbass!");
						}
					}
				} else if (selection == 3) {
					System.out.println("Which treasure card would you like to buy? Insert number");
					gameState.getTreasureCards();
					System.out.println("#4 Go Back");
					selection = keyboard.nextInt();
					if (selection == 4) {
						//Go back
					} else {
						if (selection < 4){
							boolean success = player.buyTreasureCard(selection);
							if (success) {
								System.out.println("You bought a card");
							} else {
								System.out.println("Insufficient gold to buy that card");
							}				
						} else {
							System.out.println("You can only input 1 - 4, dumbass!");
						}
					}
				} else if (selection == 4) {
					System.out.println("Which victory card would you like to buy? Insert number");
					gameState.getVictoryCards();
					System.out.println("#4 Go back");
					selection = keyboard.nextInt();
					if (selection == 4) {
						
					} else {
						if (selection < 4) {
							boolean success = player.buyVictoryCard(selection);
							if (success) {
								System.out.println("You bought a card");
							} else {
								System.out.println("Insufficient gold to buy that card");
							}							
						} else {
							System.out.println("You can only input 1 - 4, dumbass!");
						}	
					}
				} else if (selection == 5) {
					phase = 4;
				} else {
					System.out.println("You can only input 1-5, dumbass!");
				}
			}
			// Cleanupphase
			while (phase == 4) {
				player.endRound();
				phase = 1;
			}
		}
		System.out.println("Game is over! Your points were = " + player.getVictoryPoints());

	}
	
	private void actionPhaseSelection() {
		System.out.println("What would you like to do?");
		System.out.println("#1 Show hand");
		System.out.println("#2 Play Action card from hand");
		System.out.println("#3 Move on to Play Coins");
	}
	private void playCoinPhaseSelection() {
		System.out.println("What would you like to do?");
		System.out.println("#1 Show hand");
		System.out.println("#2 Play all gold cards from hand");
		System.out.println("#3 Move on to Buy Cards");
	}
	private void buyCardPhaseSelection() {
		System.out.println("#1 Show available cards");
		System.out.println("#2 Buy Action card");
		System.out.println("#3 Buy Treasure card");
		System.out.println("#4 Buy Victory card");
		System.out.println("#5 Pass the turn");
	}
}
