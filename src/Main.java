public class Main {

    public static void main(String[] args) {
        Card card = new Card(12,1);
        Card card1 = new Card(1,3);
        Card[] cards = Search.makeDeck();
        Search.displayCards(cards);
        System.out.println("---");
        int result = Search.search(cards,card);
        System.out.println(result);
        System.out.println("---");
        System.out.println(Search.binarySearch(cards,card));
        System.out.println(Search.binarySearchRecursion(cards,card,0,cards.length));
    }
}
