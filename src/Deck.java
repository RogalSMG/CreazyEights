import java.util.Random;

public class Deck {
    private Card[] cards;

    public Deck() {
        this.cards = Search.makeDeck();
    }

    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Modifying method.
     * Shuffle deck by swapping card under each index of this Card[] with random index.
     */
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int r = pickRandomInt(0, cards.length);
            swapCards(i, r);
        }
    }

    /**
     * Returns a pseudo randomly chosen int value between the specified
     * origin (inclusive) and the specified bound (exclusive).
     *
     * @param low origin
     * @param max bound
     * @return a pseudo randomly chosen int value between the
     * origin (inclusive) and the bound (exclusive)
     */
    private static int pickRandomInt(int low, int max) {
        Random random = new Random();
        return random.nextInt(low, max);
    }

    /**
     * Swap places of two Card[] obj in <code>this</code> obj
     * under i and j index.
     *
     * @param i first index
     * @param j second index
     */
    private void swapCards(int i, int j) {
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }

    public void selectionSort() {
        for (int i = 0; i < cards.length; i++) {
            int lowest = findLowestCard(i, cards.length);
            swapCards(i, lowest);
        }
    }

    public int findLowestCard(int low, int high) {
        int lowest = low;
        for (int i = low + 1; i < high; i++) {
            if (cards[lowest].compareTo(cards[i]) > 0) {
                lowest = i;
            }
        }
        return lowest;
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

    /**
     * Print all cards of this object in one line.
     * <p>Pattern [card, card, ...]
     */
    public void printCards() {
        System.out.println(this);
    }

    /**
     * Make string of all cards in deck in this object.
     * <p>Pattern [card, card, ...]
     *
     * @return string contained all cards
     */
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

    /**
     * Getter of cards field
     *
     * @return this Card[] field
     */
    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
