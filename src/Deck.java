import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A deck of cards
 */
public class Deck {

    private List<Card> cards;
    private int numberOfCards;

    public Deck(int numberOfDecks, boolean shuffle) throws Exception {
        this.numberOfCards = numberOfDecks * 52;
        this.cards = new ArrayList<Card>();

        int index = 0;

        for (int i = 0; i <= this.numberOfCards; i++) {
            for (int j = 0; j < 4; j++) {
                for (int n = 1; n <= 13; n++) {
                    this.cards.add(index, new Card(Suit.values()[j], n));
                    index++;
                }
            }
        }

        if (shuffle) {
            this.shuffle();
        }
    }

    public void shuffle() {

        Random rnd = new Random();

        Card tmp;

        int j;
        for (int i = 0; i < this.numberOfCards; i++) {
            j = rnd.nextInt(this.numberOfCards);

            tmp = this.cards.get(i);
            this.cards.set(i, this.cards.get(j));
            this.cards.set(j, tmp);
        }
    }

    public Card dealNextCard() {

        Card topCard = this.cards.get(0);

        this.cards.remove(0);

        return topCard;
    }

    public void printDeck(int numberToPrint) {
        for (int c = 0; c < numberToPrint; c++) {
            System.out.printf("% 3d/%d %s\n", c+1, this.numberOfCards, this.cards.get(c).toString());
        }
        System.out.printf("\t\t[%d other]\n", this.numberOfCards - numberToPrint);
    }
}
