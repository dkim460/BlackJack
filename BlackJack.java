import java.util.Scanner;

/**
* This class is where the Magic happens
* Here, the rules and all the possiblities are
* implemented in order to actually create the game
* A series of if/for/while statments are used in
* order to allow the user to play the game.
* @author David Kim
* @version 13.31
*/
public class BlackJack {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean playagain = true;
        int a;
        int userSum = 0;
        int dealerSum = 0;
        String stringfirst;
        String stringsecond;
        String stringnext;
        boolean decision2 = true;
        while (playagain) {
            Deck deck = new Deck(1, true);
            System.out.println("This here's the game of BlackJack!" + "\n"
                + "Enter one of the following" + "\n" + "1: Play Blackjack"
                + "\n" + "2: Quit");
            int start = keyboard.nextInt();
            if (start == 1) {
                Player user = new Player("user");
                Player dealer = new Player("dealer");
                Card firstc = user.addCard(deck.dealCard());
                Card secondc = user.addCard(deck.dealCard());
                System.out.println("\n" + "-------------------------"
                    + "\n" + "Your hand:" + "\n");
                user.printhand(true);
                stringfirst = firstc.getStringcardName();
                stringsecond = secondc.getStringcardName();
                if (stringfirst.equals("Ace") || stringsecond.equals("Ace")) {
                    System.out.println("Would you like your Ace(s) to count"
                        + " as 1 or 11? [enter 1 or 11]");
                    int acevalue = keyboard.nextInt();
                    userSum = user.getPlayerSum(acevalue);
                } else {
                    userSum = user.getPlayerSum(0);
                }
                System.out.println("\n" + "Dealer's hand:");
                dealer.addCard(deck.dealCard());
                dealer.addCard(deck.dealCard());
                dealer.printhand(false);
                dealerSum = dealer.getDealerSum();
                System.out.println("\n" + "Enter 1 or 2" + "\n" + "1: Hit"
                    + "\n" + "2: Stand");
                int next = keyboard.nextInt();
                if (next == 1) {
                    boolean decision = true;
                    while (decision) {
                        if (dealerSum == 21) {
                            System.out.println("Dealer Got Lucky!, he wins!");
                            System.out.println("Would you like to play"
                                + "another hand?"
                                + "\n" + "1: yes" + "\n" + "2: no");
                            int lucky = keyboard.nextInt();
                            if (lucky == 1) {
                                a = 6;
                                decision = false;
                                next = 3;
                                decision2 = false;
                            } else {
                                a = 6;
                                decision = false;
                                playagain = false;
                                next = 3;
                                decision2 = false;
                            }
                        }
                        for (a = 2; a < 5; a++) {
                            System.out.println(" \n" + "User was dealt"
                                + "another card");
                            Card nextc = user.addCard(deck.dealCard());
                            stringnext = nextc.getStringcardName();
                            user.printhand(true);
                            userSum = user.getPlayerSum(0);
                            if (stringnext.equals("Ace")) {
                                System.out.println("\n" + "Would you like"
                                    + "your Ace(s)"
                                    + "to count as 1 or 11? [enter 1 or 11]");
                                int nextAce = keyboard.nextInt();
                                userSum = user.getPlayerSum(nextAce);
                                if (userSum > 21) {
                                    a = 6;
                                    System.out.println("\n" + "The user loses!"
                                        + "\n"
                                        + "Would you like to play another hand?"
                                        + "\n" + "1: yes" + "\n" + "2: no");
                                    int gameover = keyboard.nextInt();
                                    if (gameover == 1) {
                                        decision = false;
                                        playagain = true;
                                        decision2 = false;
                                    }
                                    if (gameover == 2) {
                                        playagain = false;
                                        decision = false;
                                        decision2 = false;
                                    }
                                }
                                if (userSum <= 21) {
                                    System.out.println("\n" + "Enter 1"
                                        + "or 2" + "\n"
                                        + "1: Hit" + "\n" + "2: Stand");
                                    next = keyboard.nextInt();
                                    if (next == 1) {
                                        decision = true;
                                    }
                                    if (next == 2) {
                                        decision = false;
                                        next = 2;
                                    }
                                }
                            }
                            if (!stringnext.equals("Ace")) {
                                userSum = user.getPlayerSum(0);
                                if (userSum > 21) {
                                    System.out.println("\n" + "The user loses!"
                                        + "\n" + "Would you like to play"
                                        + " another" + " hand?"
                                        + "\n" + "1: yes" + "\n" + "2: no");
                                    int gameover = keyboard.nextInt();
                                    if (gameover == 1) {
                                        a = 6;
                                        decision = false;
                                        playagain = true;
                                        decision2 = false;
                                    }
                                    if (gameover == 2) {
                                        a = 6;
                                        playagain = false;
                                        decision = false;
                                        decision2 = false;
                                    }
                                }
                                if (userSum <= 21) {
                                    System.out.println("\n" + "Enter 1"
                                        + "or 2" + "\n"
                                        + "1: Hit" + "\n" + "2: Stand");
                                    next = keyboard.nextInt();
                                    if (next == 1) {
                                        decision = true;
                                    }
                                    if (next == 2) {
                                        a = 6;
                                        decision = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if (next == 2) {
                    System.out.println("\n" + "Now it's the dealer's turn!");
                    System.out.println("The dealer's Sum is : "
                        + dealerSum);
                    System.out.println("the user sum is : "
                        + userSum);
                    decision2 = true;
                    while (decision2) {
                        for (a = 2; a < 5; a++) {
                            if (dealerSum > 17 && dealerSum <= 21) {
                                if (dealerSum > userSum) {
                                    System.out.println("Dealer wins! Would"
                                        + "like to play again?" + "\n"
                                        + "1: yes" + "\n" + "2: no");
                                    int above17 = keyboard.nextInt();
                                    if (above17 == 1) {
                                        a = 6;
                                        decision2 = false;
                                        playagain = true;
                                    } else {
                                        a = 6;
                                        decision2 = false;
                                        playagain = false;
                                    }
                                } else if (userSum > dealerSum) {
                                    System.out.println("User wins! Would"
                                        + " like to play again?" + "\n"
                                        + "1: yes" + "\n" + "2: no");
                                    int above17 = keyboard.nextInt();
                                    if (above17 == 1) {
                                        a = 6;
                                        decision2 = false;
                                        playagain = true;
                                    } else {
                                        a = 6;
                                        decision2 = false;
                                        playagain = false;
                                    }
                                }
                            }
                            if (dealerSum > 21) {
                                System.out.println("The user Wins!"
                                    + "\n" + "Would you like to play again?"
                                    + "\n" + "1: yes" + "\n" + "2: no");
                                int over = keyboard.nextInt();
                                if (over == 1) {
                                    a = 5;
                                    playagain = true;
                                    decision2 = true;
                                } else {
                                    a = 6;
                                    playagain = false;
                                    decision2 = false;
                                }

                            }
                            while (dealerSum <= 17) {
                                System.out.println("\n" + "Hit ME!");
                                System.out.println("\n" + "The"
                                    + " dealer was dealt another card");
                                dealer.addCard(deck.dealCard());
                                dealer.printhand(true);
                                dealerSum = dealer.getDealerSum();
                                if (dealerSum <= 21 && dealerSum >= 18) {
                                    if (userSum < dealerSum) {
                                        System.out.println("\n" + "The "
                                            + "dealer Wins! Congrats!"
                                            + "\n" + "Would you like to"
                                            + "play another hand?"
                                            + "\n" + "1: yes" + "\n" + "2: no");
                                        int dealerfinish = keyboard.nextInt();
                                        if (dealerfinish == 1) {
                                            a = 5;
                                            playagain = true;
                                            decision2 = false;
                                        } else {
                                            a = 5;
                                            decision2 = false;
                                            playagain = false;
                                        }
                                    }
                                    if (userSum > dealerSum) {
                                        System.out.println("\n" + "The "
                                            + "user Wins! Congrats!"
                                            + "\n" + "Would you like to"
                                            + "play another hand?"
                                            + "\n" + "1: yes" + "\n" + "2: no");
                                        int dealerfinish = keyboard.nextInt();
                                        if (dealerfinish == 1) {
                                            a = 5;
                                            playagain = true;
                                            decision2 = false;
                                        } else {
                                            a = 5;
                                            decision2 = false;
                                            playagain = false;
                                        }
                                    }
                                }
                                if (userSum > 17 && dealerSum > 16) {
                                    if (userSum > dealerSum || dealerSum > 21) {
                                        System.out.println("\n" + "The user"
                                            + " Wins! Congrats!" + "\n"
                                            + "Would you like"
                                            + "to play another hand?"
                                            + "\n" + "1: yes" + "\n" + "2: no");
                                        int dealerfinish = keyboard.nextInt();
                                        if (dealerfinish == 1) {
                                            a = 5;
                                            playagain = true;
                                            decision2 = false;
                                        } else {
                                            a = 5;
                                            decision2 = false;
                                            playagain = false;
                                        }
                                    }
                                }
                                if (userSum == dealerSum) {
                                    System.out.println("It's a tie!");
                                    System.out.println("Would you like to "
                                        + "play again?" + "\n" + "1: yes"
                                        + "\n" + "2: no:");
                                    int dealerfinish = keyboard.nextInt();
                                    if (dealerfinish == 1) {
                                        a = 5;
                                        playagain = true;
                                        decision2 = false;
                                    } else {
                                        a = 5;
                                        decision2 = false;
                                        playagain = false;
                                    }
                                }
                            }
                        }
                    }
                    a = 0;
                }
            }
            if (start == 2) {
                playagain = false;
            }
        }
    }
}