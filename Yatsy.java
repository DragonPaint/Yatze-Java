package defult;

import java.util.Scanner;
import java.util.Random;

public class Yatsy {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);

		System.out.println("Player count?");
		int playerCount = s1.nextInt();
		int player_1[] = new int[playerCount];
		int player_2[] = new int[playerCount];
		int player_3[] = new int[playerCount];
		int player_4[] = new int[playerCount];
		int player_5[] = new int[playerCount];
		int player_6[] = new int[playerCount];
		int player_2x[] = new int[playerCount];
		int player_2x2[] = new int[playerCount];
		int player_3x[] = new int[playerCount];
		int player_4x[] = new int[playerCount];
		int player_2x3x[] = new int[playerCount];
		int player_15[] = new int[playerCount];
		int player_26[] = new int[playerCount];
		int player_Chance[] = new int[playerCount];
		int player_Yatze[] = new int[playerCount];
		int player_Points[] = new int[playerCount];

		Random rand = new Random();

		String playerName[] = new String[playerCount];

		for (int playerZ = 0; playerZ < playerCount; playerZ++) {
			System.out.println("Input name " + (playerZ + 1));
			playerName[playerZ] = s1.next();
		}

		int again = 1;
		do {
			for (int playerZ = 0; playerZ < playerCount; playerZ++) {

				int dice[] = new int[5];

				System.out.println(playerName[playerZ] + " order is: Die number = Number rolled,");

				// og rolls + printout
				for (int i = 0; i < 5; i++) {
					int n = rand.nextInt(6) + 1;
					dice[i] = n;
					int nbr = i + 1;
					System.out.print(nbr + "=" + dice[i] + ", ");
				}

				/*
				 * Debugging dice[0] = 1; dice[1] = 1; dice[2] = 1; dice[3] = 2; dice[4] = 2;
				 */

				System.out.println("");// enter is pressed

				// loops 2 times
				for (int x = 0; x < 2; x++) {
					System.out.println("Input string of nubmers or press any letter then Enter to not reroll");

					// stops if enter is pressed
					String reRoll = s1.next();
					if (reRoll.equals("")) {
						x = 2;
					} else {

						// Takes string input and rerolls
						for (char DiceForRoll : reRoll.toCharArray()) {
							if (Character.isDigit(DiceForRoll)) {
								int reRollConv = DiceForRoll - 49;// from ascii to number
								int n = rand.nextInt(6) + 1;
								dice[reRollConv] = n;
							}
						}

						// prints numbers again
						for (int i = 0; i < 5; i++) {
							int nbr = i + 1;
							System.out.print(nbr + " = " + dice[i] + ", ");

						}
						System.out.println("");// presses enter
					}
				}
				// What does player playerZ want to save
				int reTroll = 1;

				do {
					System.out.println("What do You want to save " + playerName[playerZ] + "?");
					System.out.println("1, 2, 3, 4, 5, 6, 2x, 2x2, 3x, 4x, 2x+3x, 1-5, 2-6, Chance, Yatze.");
					String saveScore = s1.next();
					int pipNumber, amount, amount2, sameDice, dont, counter, value, printout, easter_egg;
					switch (saveScore) {
					case "1":
						pipNumber = 1;
						counter = ettor(dice, pipNumber);
						System.out.println("How many do you want to save? " + 0 + "-" + counter);
						amount = s1.nextInt();
						player_1[playerZ] = player_1[playerZ] + (amount * 1);
						System.out.println(player_1[playerZ]);
						break;
					case "2":
						pipNumber = 2;
						counter = ettor(dice, pipNumber);
						System.out.println("How many do you want to save? " + 0 + "-" + counter);
						amount = s1.nextInt();
						player_2[playerZ] = player_2[playerZ] + amount * 2;
						System.out.println(player_2[playerZ]);
						break;
					case "3":
						pipNumber = 3;
						counter = ettor(dice, pipNumber);
						System.out.println("How many do you want to save? " + 0 + "-" + counter);
						amount = s1.nextInt();
						player_3[playerZ] = player_3[playerZ] + amount * 1;
						System.out.println(player_3[playerZ]);
						break;
					case "4":
						pipNumber = 4;
						counter = ettor(dice, pipNumber);
						System.out.println("How many do you want to save? " + 0 + "-" + counter);
						amount = s1.nextInt();
						player_4[playerZ] = player_4[playerZ] + amount * 1;
						System.out.println(player_4[playerZ]);
						break;
					case "5":
						pipNumber = 5;
						counter = ettor(dice, pipNumber);
						System.out.println("How many do you want to save? " + 0 + "-" + counter);
						amount = s1.nextInt();
						player_5[playerZ] = player_5[playerZ] + amount * 1;
						System.out.println(player_5[playerZ]);
						break;
					case "6":
						pipNumber = 6;
						counter = ettor(dice, pipNumber);
						System.out.println("How many do you want to save? " + 0 + "-" + counter);
						amount = s1.nextInt();
						player_6[playerZ] = player_6[playerZ] + amount * 1;
						System.out.println(player_6[playerZ]);
						break;
					case "2x":
						sameDice = 2;

						value = ettor3(dice, sameDice);
						player_2x[playerZ] = player_2x[playerZ] + (value * sameDice);

						System.out.println(player_2x[playerZ]);

						break;
					case "2x2":
						sameDice = 2;

						counter = 0;
						amount2 = 0;
						for (pipNumber = 1; pipNumber <= 6; pipNumber++) {
							for (int dieX = 0; dieX < 5; dieX++) {
								if (dice[dieX] == pipNumber) {
									counter++;

								}

								if (counter >= sameDice) {
									player_2x2[playerZ] = player_2x2[playerZ] + pipNumber * sameDice;
									counter = 0;
								}
							}
						}

						System.out.println(player_2x2[playerZ]);
						break;
					case "3x":
						sameDice = 3;

						value = ettor3(dice, sameDice);
						player_3x[playerZ] = player_3x[playerZ] + (value * sameDice);

						System.out.println(player_3x[playerZ]);
						break;
					case "4x":
						sameDice = 4;

						value = ettor3(dice, sameDice);
						player_4x[playerZ] = player_4x[playerZ] + (value * sameDice);

						System.out.println(player_4x[playerZ]);
						break;
					case "2x+3x":
						// checks for if you have a full house by
						// checking if you have a triplet if that is true it checks if there is another
						// number that is dieX pair
						// i barely understand it myself and this is code that i wrote myself
						for (pipNumber = 1; pipNumber < 7; pipNumber++) {
							counter = 0;
							for (pipNumber = 1; pipNumber < 7; pipNumber++) {
								for (int dieX = 0; dieX < 5; dieX++) {
									if (dice[dieX] == pipNumber) {
										counter++;
									}
									if (counter == 3) {
										dont = pipNumber;
										player_2x3x[playerZ] = player_2x3x[playerZ] + (pipNumber * 3);
										for (pipNumber = 1; pipNumber < 7; pipNumber++) {
											if (pipNumber != dont) {
												counter = 0;

												for (dieX = 0; dieX < 5; dieX++) {
													if (dice[dieX] == pipNumber) {
														counter++;
													}
													if (counter == 2) {
														player_2x3x[playerZ] = player_2x3x[playerZ] + (pipNumber * 2);
													}
												}

											}
										}

									}
								}
							}

						}
						System.out.println(player_2x3x[playerZ]);

						break;
					case "1-5":
						// Checks for every number in sequence and stops if an number is missing
						pipNumber = 1;
						counter = ettor(dice, pipNumber);
						if (counter == 1) {
							pipNumber = 2;
							counter = ettor(dice, pipNumber);
							if (counter == 1) {
								pipNumber = 3;
								counter = ettor(dice, pipNumber);
								if (counter == 1) {
									pipNumber = 4;
									counter = ettor(dice, pipNumber);
									if (counter == 1) {
										pipNumber = 5;
										counter = ettor(dice, pipNumber);
										if (counter == 1) {
											player_15[playerZ] = player_15[playerZ] + 15;
										}
									}
								}
							}
						}
						System.out.println(player_15[playerZ]);
						break;
					case "2-6":
						// Checks for every number in sequence and stops if an number is missing
						pipNumber = 2;
						counter = ettor(dice, pipNumber);
						if (counter == 1) {
							pipNumber = 3;
							counter = ettor(dice, pipNumber);
							if (counter == 1) {
								pipNumber = 4;
								counter = ettor(dice, pipNumber);
								if (counter == 1) {
									pipNumber = 5;
									counter = ettor(dice, pipNumber);
									if (counter == 1) {
										pipNumber = 6;
										counter = ettor(dice, pipNumber);
										if (counter == 1) {
											player_26[playerZ] = player_26[playerZ] + 20;
										}
									}
								}
							}
						}
						System.out.println(player_26[playerZ]);

						break;
					case "Chance":
						for (int dieX = 0; dieX < 5; dieX++) {
							player_Chance[playerZ] = player_Chance[playerZ] + dice[dieX];
						}
						System.out.println(player_Chance[playerZ]);
						break;
					case "Yatze":
						sameDice = 5;
						amount2 = ettor2(dice, sameDice);
						if (amount2 == 1) {
							player_Yatze[playerZ] = player_Yatze[playerZ] + 50;

						}
						System.out.println(player_Yatze[playerZ]);
						break;
					}
					System.out.println("Do you want to see what you have saved? 0=no");
					printout = s1.nextInt();
					if (printout != 0) {
						if (player_1[playerZ] == 0) {
							System.out.println("1: Empty");
						} else {
							System.out.println("1: Done = " + player_1[playerZ]);
						}
						if (player_2[playerZ] == 0) {
							System.out.println("2: Empty");
						} else {
							System.out.println("2: Done = " + player_2[playerZ]);
						}
						if (player_3[playerZ] == 0) {
							System.out.println("3: Empty");
						} else {
							System.out.println("3: Done = " + player_3[playerZ]);
						}
						if (player_4[playerZ] == 0) {
							System.out.println("4: Empty");
						} else {
							System.out.println("4: Done = " + player_4[playerZ]);
						}
						if (player_5[playerZ] == 0) {
							System.out.println("5: Empty");
						} else {
							System.out.println("5: Done = " + player_5[playerZ]);
						}
						if (player_6[playerZ] == 0) {
							System.out.println("6: Empty");
						} else {
							System.out.println("6: Done = " + player_6[playerZ]);
						}
						if (player_2x[playerZ] == 0) {
							System.out.println("2x: Empty");
						} else {
							System.out.println("2x: Done = " + player_2x[playerZ]);
						}
						if (player_2x2[playerZ] == 0) {
							System.out.println("2x2: Empty");
						} else {
							System.out.println("2x2: Done = " + player_2x2[playerZ]);
						}
						if (player_3x[playerZ] == 0) {
							System.out.println("3x: Empty");
						} else {
							System.out.println("3x: Done = " + player_3x[playerZ]);
						}
						if (player_4x[playerZ] == 0) {
							System.out.println("4x: Empty");
						} else {
							System.out.println("4x: Done = " + player_4x[playerZ]);
						}
						if (player_2x3x[playerZ] == 0) {
							System.out.println("2x+3x: Empty");
						} else {
							System.out.println("2x+3x: Done = " + player_2x3x[playerZ]);
						}
						if (player_15[playerZ] == 0) {
							System.out.println("1-5: Empty");
						} else {
							System.out.println("1-5: Done = " + player_15[playerZ]);
						}
						if (player_26[playerZ] == 0) {
							System.out.println("2-6: Empty");
						} else {
							System.out.println("2-6: Done = " + player_26[playerZ]);
						}
						if (player_Chance[playerZ] == 0) {
							System.out.println("Chance: Empty");
						} else {
							System.out.println("Chance: Done = " + player_Chance[playerZ]);
						}
						if (player_Yatze[playerZ] == 0) {
							System.out.println("Yatze: Empty");
						} else {
							System.out.println("Yatze: Done = " + player_Yatze[playerZ]);
						}

					} else {
						System.out.println("Sadface, you sure?");
						easter_egg = s1.nextInt();
						if (easter_egg == 2309) {
							System.out.println("    /:''|    ");
							System.out.println("   |: 66|_   ");
							System.out.println("   C     _)  ");
							System.out.println("    \\ ._|      ");
							System.out.println("     ) /       ");
							System.out.println("   /`\\       ");
							System.out.println("   || |Y|       ");
							System.out.println("   || |#|       ");
							System.out.println("   || |#|       ");
							System.out.println("   || |#|       ");
							System.out.println("   :| |=:       ");
							System.out.println("   ||_|,|      ");
							System.out.println("   \\)))||     ");
							System.out.println("|~~~`-`~~~|   ");
							System.out.println("|         |    ");
							System.out.println("|_________|    ");
							System.out.println("|_________|    ");
							System.out.println("    | ||       ");
							System.out.println("    |_||__        ");
							System.out.println("    (____))    ");

						} else if (easter_egg != 0) {
							if (player_1[playerZ] == 0) {
								System.out.println("1: Empty");
							} else {
								System.out.println("1: Done = " + player_1[playerZ]);
							}
							if (player_2[playerZ] == 0) {
								System.out.println("2: Empty");
							} else {
								System.out.println("2: Done = " + player_2[playerZ]);
							}
							if (player_3[playerZ] == 0) {
								System.out.println("3: Empty");
							} else {
								System.out.println("3: Done = " + player_3[playerZ]);
							}
							if (player_4[playerZ] == 0) {
								System.out.println("4: Empty");
							} else {
								System.out.println("4: Done = " + player_4[playerZ]);
							}
							if (player_5[playerZ] == 0) {
								System.out.println("5: Empty");
							} else {
								System.out.println("5: Done = " + player_5[playerZ]);
							}
							if (player_6[playerZ] == 0) {
								System.out.println("6: Empty");
							} else {
								System.out.println("6: Done = " + player_6[playerZ]);
							}
							if (player_2x[playerZ] == 0) {
								System.out.println("2x: Empty");
							} else {
								System.out.println("2x: Done = " + player_2x[playerZ]);
							}
							if (player_2x2[playerZ] == 0) {
								System.out.println("2x2: Empty");
							} else {
								System.out.println("2x2: Done = " + player_2x2[playerZ]);
							}
							if (player_3x[playerZ] == 0) {
								System.out.println("3x: Empty");
							} else {
								System.out.println("3x: Done = " + player_3x[playerZ]);
							}
							if (player_4x[playerZ] == 0) {
								System.out.println("4x: Empty");
							} else {
								System.out.println("4x: Done = " + player_4x[playerZ]);
							}
							if (player_2x3x[playerZ] == 0) {
								System.out.println("2x+3x: Empty");
							} else {
								System.out.println("2x+3x: Done = " + player_2x3x[playerZ]);
							}
							if (player_15[playerZ] == 0) {
								System.out.println("1-5: Empty");
							} else {
								System.out.println("1-5: Done = " + player_15[playerZ]);
							}
							if (player_26[playerZ] == 0) {
								System.out.println("2-6: Empty");
							} else {
								System.out.println("2-6: Done = " + player_26[playerZ]);
							}
							if (player_Chance[playerZ] == 0) {
								System.out.println("Chance: Empty");
							} else {
								System.out.println("Chance: Done = " + player_Chance[playerZ]);
							}
							if (player_Yatze[playerZ] == 0) {
								System.out.println("Yatze: Empty");
							} else {
								System.out.println("Yatze: Done = " + player_Yatze[playerZ]);
							}

						} else {
							System.out.println("Ok but sadface");
						}

					}
					// Asks if you want to continue and then you can choose to save something else
					// Adds up player playerZ score and displays it at the end of each save
					System.out.println("Want to continue? 0=No");
					player_Points[playerZ] = player_1[playerZ] + player_2[playerZ] + player_3[playerZ]
							+ player_4[playerZ] + player_5[playerZ] + player_6[playerZ] + player_2x[playerZ]
							+ player_2x2[playerZ] + player_3x[playerZ] + player_4x[playerZ] + player_2x3x[playerZ]
							+ player_15[playerZ] + player_26[playerZ] + player_Chance[playerZ] + player_Yatze[playerZ];
					System.out.println(
							"Current total amount for " + playerName[playerZ] + " = " + player_Points[playerZ]);

					reTroll = s1.nextInt();
				} while (reTroll != 0);
			}
			System.out.println("Want to play again? 0=No");
			again = s1.nextInt();
		} while (again != 0);
		s1.close();
	}

	// checks if the dice are equal to a number
	static int ettor(int[] dice, int pipNumber) {

		int counter = 0;
		for (int dieX = 0; dieX < 5; dieX++) {
			if (dice[dieX] == pipNumber) {
				counter++;
			}
		}

		return counter;
	}

	// Checks if you have a pairs triplets yatze and quads (Individualy, by changing
	// sameDice )
	static int ettor2(int dice[], int sameDice) {

		int counter = 0;
		int amount2 = 0;
		for (int pipNumber = 1; pipNumber < 7; pipNumber++) {
			for (int dieX = 0; dieX < 5; dieX++) {
				if (dice[dieX] == pipNumber) {
					counter++;

					if (counter >= sameDice) {
						amount2++;

					}
				}
			}
		}
		return amount2;

	}

	// Returns value pipNumber(which die that it is on when sameDice is true)
	static int ettor3(int dice[], int sameDice) {
		int value = 0;
		int counter = 0;
		for (int pipNumber = 1; pipNumber < 7; pipNumber++) {
			for (int dieX = 0; dieX < 5; dieX++) {
				if (dice[dieX] == pipNumber) {
					counter++;
					if (counter >= sameDice) {
						value = pipNumber;
					}
				}

			}
		}
		return value;

	}
}
