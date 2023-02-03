public class Test {
    public static void main(String[] args) {
        Eights eights = new Eights();
        eights.playGame();
    }

    public static void drawTesting() {
        Deck deck = new Deck("Deck");
        deck.shuffle();
        deck.showCards();

        Hand hand = new Hand("Set");
        deck.deal(hand, 5);
        hand.display();

        Hand drawPile = new Hand("Draw Pile");
        deck.dealAll(drawPile);
        System.out.printf("Draw pile has a %d cards", drawPile.size());
    }
}
