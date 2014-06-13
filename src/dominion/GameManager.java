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
	}
	
	public void startGame() {
		player.startGame();
		while (true) {
			phase = 1;
			player.startRound();
			// Actionphase
			while (phase == 1) {
				actionPhaseSelection();
				keyboard = new Scanner(System.in);
				int selection = keyboard.nextInt();
				if (selection == 1) {
					player.getHand();
				} else if (selection == 2) {
					player.getHand();
					System.out.println("Which card would you like to play?");
					selection = keyboard.nextInt();
					//Måste kolla om kortet är ett actionkort
					player.play(selection);
				} else if (selection == 3) {
					phase = 2;
				} else {
					System.out.println("You can only input 1 - 3, dumbass!");
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
					selection = keyboard.nextInt();
					boolean success = player.buyActionCard(selection);
					if (success) {
						System.out.println("You bought a card");
					} else {
						System.out.println("Insufficient gold to buy that card");
					}
				} else if (selection == 3) {
					System.out.println("Which treasure card would you like to buy? Insert number");
					gameState.getTreasureCards();
					selection = keyboard.nextInt();
					boolean success = player.buyTreasureCard(selection);
					if (success) {
						System.out.println("You bought a card");
					} else {
						System.out.println("Insufficient gold to buy that card");
					}
				} else if (selection == 4) {
					System.out.println("Which victory card would you like to buy? Insert number");
					gameState.getVictoryCards();
					selection = keyboard.nextInt();
					boolean success = player.buyVictoryCard(selection);
					if (success) {
						System.out.println("You bought a card");
					} else {
						System.out.println("Insufficient gold to buy that card");
					}
				}
			}
			// Cleanupphase
			while (phase == 3) {
				phase = 1;
				player.endRound();
			}
		}
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
