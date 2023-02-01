public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.printCards();
        deck.shuffle();
        deck.printCards();

        Deck afterMerge = Deck.merge(deck, deck);
        afterMerge.printCards();
        main2(args);
    }
    public static void main2(String[] args) {
        Deck deck = new Deck("Talia");
        deck.shuffle();

        Hand hand = new Hand("Układ");
        deck.deal(hand, 5);
        hand.display();

        Hand drawPile = new Hand("Stos ciągnięcia");
        deck.dealAll(drawPile);
        System.out.printf("Stos ciągnięcia zawiera %d kart.\n",
                drawPile.size());
    }
}
