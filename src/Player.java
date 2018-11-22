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

//        this.hand.set(this.numberOfCards, aCard);
        this.hand.add(this.numberOfCards, aCard);
        this.numberOfCards++;

        return (this.getHandSum() <= 21);
    }

    public int getHandSum() {
        int handSum = 0;
        int cardNum;
        int numAces = 0;

        for (int c = 0; c < this.numberOfCards; c++) {
            cardNum = this.hand.get(c).getNumber();
            if (cardNum == 1) {
                numAces++;
                handSum += 11;
            } else if (cardNum > 10) {
                handSum += 10;
            } else {
                handSum += cardNum;
            }
        }

        while (handSum > 21 && numAces > 0) {
            handSum -= 10;
            numAces--;
        }

        return handSum;
    }

    public void printHand(boolean showFirstCard) {

        System.out.printf("%s's cards:\n", this.name);
        for (int c = 0; c < this.numberOfCards; c++) {
            if (c == 0 && !showFirstCard) {
                System.out.println("  [hidden]  ");
            } else {
                System.out.printf("  %s\n", this.hand.get(c).toString());
            }
        }

    }


}
