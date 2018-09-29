import java.util.Random;

/**
* This class represents a deck object
* @author David Kim
* @version 13.31
*/
public class Deck {

    private Random rand = new Random();
    private Card[] deck;
    private int numCard;
    /**
    * This constructor takes in no variable and creates a deck,
    * it refers to the other deck constructor as well
    */
    public Deck() {
        this(1, false);
    }
    /**
    * This constructor is another way a deck is created, but
    * through the use of two required inputs. It does not overload
    * with the other constructor named exactly the same as this because
    * they do not have the same signature
    * @param amountofdecks the number of decks that should be created
    * @param shuffle a boolean value determining whether it should be shuffled
    */
    public Deck(int amountofdecks, boolean shuffle) {
        this.numCard = amountofdecks * 52;
        this.deck = new Card[numCard];
        int cardCreated = 0;
        for (int card = 0; card < 13; card++) {
            for (int suit = 0; suit < 4; suit++) {
                this.deck[cardCreated] = new Card(card, suit);
                cardCreated++;
            }
        }
        if (shuffle) {
            this.shuffle();
        }
    }
    /**
    * This method is used in order to shuffle the deck it does not
    * return anything
    */
    public void shuffle() {
        Card temporary;
        for (int i = 0; i < numCard; i++) {
            int j = rand.nextInt(numCard);
            temporary = deck[i];
            deck[i] = deck[j];
            deck[j] = temporary;
        }
    }
    /**
    * This method is used to take a card out of the deck and use it.
    * it uses a series of if and for statements in order to index
    * cards out etc. It does not take in any parameters
    * @return it returns a shuffled deck of class card
    */
    public Card dealCard() {
        if (numCard == 52) {
            shuffle();
        }
        Card top = deck[0];
        for (int i = 1; i < numCard; i++) {
            deck[i - 1] = deck[i];
        }
        deck[numCard - 1] = null;
        numCard--;
        return top;
    }
}