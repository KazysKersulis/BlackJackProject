/**
 * An implementation of a card type;
 */
public class Card {

    private Suit suit;
    private int number;

    public Card(Suit suit, int number) throws Exception {
        this.suit = suit;
        if (number >= 1 && number <= 13)
            this.number = number;
        else
            throw new Exception("Invalid card number" + number);
        
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", number=" + number +
                '}';
    }
}
