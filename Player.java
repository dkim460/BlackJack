/**
* This class represents a Player object.
* @author David Kim
* @version 13.31
*/

public class Player {

    private Card[] hand = new Card[5];
    private int cardNum;
    private int acevalue;
    private String name;
    private int dealerhandSum;
    /**
    * This creates a player with a name
    * @param name takes in a String value of name
    */
    public Player(String name) {
        this.name = name;
    }
    /**
    * This method is used to add cards taken out of
    * the deck into the hand of the player
    * @param card takes in a parameter of a value of card
    * that is taken out of the deck
    * @return returns the card
    */
    public Card addCard(Card card) {
        if (cardNum == 5) {
            System.out.println("Hand is full");
        }
        if (cardNum < 5) {
            this.hand[this.cardNum] = card;
            this.cardNum++;
        }
        return card;
    }
    /**
    * This method is used to check the sum of the
    * user player
    * @param aceValue takes in the chosen value of the ace card
    * or the default 0 value for if its not an ace.
    * @return the value of the sum of the cards in hand
    */
    public int getPlayerSum(int aceValue) {
        int handSum = 0;
        this.acevalue = acevalue;
        for (int i = 0; i < cardNum; i++) {
            int cardvalue = (hand[i].getCardValue());
            if (aceValue == 11) {
                if (cardvalue == 1) {
                    handSum += 11;
                } else {
                    handSum += cardvalue;
                }
            } else {
                if (cardvalue == 1) {
                    handSum += 1;
                } else if (cardvalue > 10) {
                    handSum += 10;
                } else {
                    handSum += cardvalue;
                }
            }
        }
        System.out.println(handSum);
        return handSum;
    }
    /**
    * This method is used to get the sum of the
    * dealer player
    * @return the value of the sum of the cards in hand
    */
    public int getDealerSum() {
        dealerhandSum = 0;
        for (int i = 0; i < cardNum; i++) {
            int cardvalue = (hand[i].getCardValue());
            if (cardvalue == 1) {
                dealerhandSum += 11;
                if (dealerhandSum > 21) {
                    dealerhandSum -= 10;
                }
            } else if (cardvalue <= 10) {
                dealerhandSum += cardvalue;
            }
        }
        return dealerhandSum;
    }
    /**
    * This method takes in a boolean value and is
    * used to print the hand of the players.
    * @param showfirstcard takes in a boolean value to choose whether
    * or not the first card should be hidden or not.
    */
    public void printhand(boolean showfirstcard) {
        for (int i = 0; i < cardNum; i++) {
            if (i == 0 && !showfirstcard) {
                System.out.println("FACE DOWN");
            } else {
                System.out.println(this.hand[i].toString());
            }
        }
    }
}

