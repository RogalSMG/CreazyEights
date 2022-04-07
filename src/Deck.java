import java.util.Random;

public class Deck {
    private Card[] cards;

    public Deck() {
        this.cards = Search.makeDeck();
    }

    public Deck(int n) {
        this.cards = new Card[n];
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int r = pickRandomInt(0, cards.length);
            swapCards(i , r);
        }
    }

    private static int pickRandomInt(int low, int max) {
        Random random = new Random();
        return random.nextInt(low, max);
    }

    private void swapCards(int i, int j) {
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }

    /**
     * Print all cards in given array in separate rows
     *
     * @param cards array of cards.
     */
    public void printCards(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cards.length; i++) {
            if (i == 0) {
                builder.append("[").append(cards[i]).append(", ");
            } else if (i < cards.length - 1) {
                builder.append(cards[i]).append(", ");
            } else {
                builder.append(cards[i]).append("]");
            }
        }
        return builder.toString();
    }

    public Card[] getCards() {
        return cards;
    }
}
