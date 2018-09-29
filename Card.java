/**
* This class represents a card object.
* @author David Kim
* @version 13.31
*/
public class Card {

    private String[] cardName = {"Ace", "2", "3", "4", "5",
        "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    private String[] cardSuit = {"Spades", "Clubs", "Diamonds", "Hearts"};

    private int cardValue;
    private int suit;
    /**
    * This method takes in two ints and sets them equal
    * the the instance variables
    * @param cardValue a number representing the value of a card
    * @param suit a number representing the suit of a card
    */
    public Card(int cardValue, int suit) {
        this.cardValue = cardValue;
        this.suit = suit;
    }
    /**
    * This method has no inputs and returns the cardvalue of a card
    * It takes in no parameter
    * @return the value of the card
    */
    public int getCardValue() {
        int localvalue = cardValue + 1;
        if (localvalue == 11 || localvalue == 12 || localvalue == 13) {
            localvalue = 10;
        }
        return localvalue;
    }
    /**
    * This method has no inputs and returns the String name
    * of the value of the card
    * @return the String name of the card
    */
    public String getStringcardName() {
        return cardName[cardValue];
    }
    /**
    * This method has no inputs and returns the String name
    * of the suit of the card
    * @return the STring name of the suit
    */
    public String getStringcardSuit() {
        return cardSuit[suit];
    }
    /**
    * This method has no inputs and returns the String of
    * what the card value is and of what suit it is
    * @return the String of both the card name and suit name in a statement.
    */
    public String toString() {
        return getStringcardName() + " of " + getStringcardSuit();
    }
}