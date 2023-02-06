package game;
import eights.hand.EightsHand;

public class Test {
    public static void main(String[] args) {
        playMultipleTimes(500);
    }

    public static void playMultipleTimes(int num) {
        int pointsOne = 0;
        int pointsTwo = 0;
        int pointsThree = 0;
        for (int i = 0; i < num; i++) {
            Eights eights = new Eights();
            eights.playGame();

            pointsOne += eights.players.get(0).getHand().calculateScore();
            pointsTwo += eights.players.get(1).getHand().calculateScore();
            pointsThree += eights.players.get(2).getHand().calculateScore();
        }
        System.out.printf("First have %d points. \nSecond have %d points \nThird have %d points. \nThey played %d times", pointsOne, pointsTwo, pointsThree, num);
    }

    public static void drawTesting() {
        Deck deck = new Deck("game.Deck");
        deck.shuffle();
        deck.showCards();

        Hand hand = new Hand("Set");
        deck.deal(hand, 5);
        hand.displayInRow();

        Hand drawPile = new Hand("Draw Pile");
        deck.dealAll(drawPile);
        System.out.printf("Draw pile has a %d cards", drawPile.size());
    }
}
