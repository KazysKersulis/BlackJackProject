import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Card> hand = new ArrayList<>();

    private int numberOfCards;

    public Player(String name) {
        this.name = name;

        this.emptyHand();
    }

    private void emptyHand() {
        for (int c = 0; c < hand.size(); c++) {
            this.hand.remove(c);
        }
    }

    public boolean addCard(Card aCard) throws Exception {

        if (this.numberOfCards == 10) {
            throw new Exception(name + "'s hand already has 10 cards");
        }

        this.hand.set(this.numberOfCards, aCard);
        this.numberOfCards++;

        return (this.getHandSum() <= 21);
    }

    private int getHandSum() {
        return 5;
    }


}
