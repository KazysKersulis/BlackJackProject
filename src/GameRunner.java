import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) throws Exception {

//        Deck deck = new Deck(1, false);
//        deck.printDeck(24);

        Scanner sc = new Scanner(System.in);
        Deck deck = new Deck(1, true);

        Player me = new Player("Me");
        Player dealer = new Player("Dealer");

        me.addCard(deck.dealNextCard());
        dealer.addCard(deck.dealNextCard());
        me.addCard(deck.dealNextCard());
        dealer.addCard(deck.dealNextCard());

        // print hands
        System.out.println("Cards are dealt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");
        System.out.println("\n");

        boolean meDone = false;
        boolean dealerDone = false;
        String answer;

        while(!meDone || !dealerDone) {
            if (!meDone) {
                System.out.println("Hit or Stay? (H or S)");
                answer = sc.next();
                System.out.println("\n");

                if (answer.compareToIgnoreCase("H") == 0) {
                    meDone = !me.addCard(deck.dealNextCard());
                    me.printHand(true);
                } else {
                    meDone = true;
                    me.printHand(true);
                }
            }

            if (!dealerDone) {
                if (dealer.getHandSum() < 17) {
                    System.out.println("The dealer hits \n");
                    dealerDone = !dealer.addCard(deck.dealNextCard());
                    dealer.printHand(false);
                } else {
                    System.out.println("The dealer stays \n");
                    dealerDone = true;
                }
            }

            System.out.println("");

        }
        sc.close();

        me.printHand(true);
        dealer.printHand(true);

        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer Wins!");
        }

    }

}
