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

        for (int i = 0; i < this.numberOfCards; i++) {
            for (int j = 0; j < 4; j++) {
                for (int n = 0; n <= 13; n++) {
                    this.cards.add(index, new Card(Suit.values()[j], n));
                    index++;
                }
            }
        }

        if (shuffle) {
            this.shuffle();
        }
    }

    private void shuffle() {

        Random rnd = new Random();

        Card tmp;

        int j;
        for (int i = 0; i < this.numberOfCards; i++) {
            j = rnd.nextInt(this.numberOfCards);

            tmp = this.cards.get(i);
            this.cards.add(i, this.cards.get(j));
            this.cards.add(j, tmp);
        }
    }

    private Card dealNextCard() {
        return this.cards.get(0);
    }
}
