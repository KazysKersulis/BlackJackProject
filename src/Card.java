/**
 * An implementation of a card type;
 */
public class Card {

    private Suit suit;
    private int number;

    public Card(Suit suit, int number) throws Exception {
        this.suit = suit;
        if (number >= 0 && number <= 13)
            this.number = number;
        else
            throw new Exception("Invalid card number " + number);

    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {

        if (number > 1 && number <= 10) {
            return "Card{" +
                    "suit=" + suit +
                    ", number=" + number +
                    '}';
        } else {
            switch (number) {
                case 1 : return "Ace of " + suit;
                case 11: return "Jack of " + suit;
                case 12: return "Queen of " + suit;
                case 13: return "King of " + suit;
            }
        }

        return "";
    }
}
