public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = new Card(1, 1);
        Card card1 = new Card(1, 0);

        Card[] cards = Search.makeDeck();
        deck.printCards();
        deck.shuffle();
        deck.printCards();

        Deck.merge(deck, deck);
    }
}
