import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = new Card(1,1);
        Card card1 = new Card(1,0);

        Card[] cards = Search.makeDeck();
        deck.printCards(deck.getCards());
        deck.shuffle();
        deck.printCards(deck.getCards());

        System.out.println("---");
        int result = Search.search(cards,card);
        System.out.println(result);
        System.out.println("---");
        System.out.println(Search.binarySearch(cards,card));
        System.out.println(Search.binarySearchRecursion(cards,card,0,cards.length));
        System.out.println("---");
        System.out.println(card1.position());
        System.out.println("---");
        System.out.println(Arrays.toString(deck.getCards()));
        System.out.println(deck);
    }
}
