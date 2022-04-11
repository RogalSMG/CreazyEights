import java.util.Random;

public class Deck {
    private Card[] cards;
    private static final Random random = new Random();


    public Deck() {
        this.cards = Search.makeDeck();
    }

    public Deck(int n) {
        this.cards = new Card[n];
    }

    public Deck(Card[] cards) {
        this.cards = cards;
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
     * Returns a pseudo randomly int value between the specified
     * origin (inclusive) and the specified bound (exclusive).
     *
     * @param low origin
     * @param max bound
     * @return a pseudo randomly chosen int value between the
     * origin (inclusive) and the bound (exclusive)
     */
    private static int pickRandomInt(int low, int max) {
        return random.nextInt(low, max);
    }

    /**
     * Swap places of two Card obj in <code>this</code> obj
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

    /**
     * Modifying method.
     * Sorting this cards array.
     */
    public void selectionSort() {
        for (int i = 0; i < cards.length; i++) {
            int lowest = findLowestCard(i, cards.length);
            swapCards(i, lowest);
        }
    }

    /**
     * Find index of the lowest card in cards field.
     *
     * @param low starting index (included)
     * @param high last index (excluded)
     * @return index of the lowest card
     */
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
     * Return <code>Deck</code> object with cards from index low (included) to high (included)
     * by using this object.
     * New object can not be empty
     * @param low first index
     * @param high last index
     * @return <code>Deck</code> object with cards from index low (included) to high (included)
     */
    public Deck subDeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low];
            low++;
        }
        return sub;
    }

    /**
     * Merge cards fields of both given Deck obj. Compare cards, adding first lower card.
     * If both cards fields are sorted it return also Deck with sorted cards field.
     *
     * @param d1 first Deck
     * @param d2 second Deck
     * @return Deck with merged cards field from params d1 and d2
     */
    public static Deck merge(Deck d1, Deck d2) {
        // new deck
        Deck merge = new Deck(d1.cards.length + d2.cards.length);
        // indexes of d1 and d2
        int i = 0;
        int j = 0;

        for (int k = 0; k < merge.cards.length; k++) {
            // if first deck is empty add card from second
            if (i == d1.cards.length) {
                merge.cards[k] = d2.cards[j];
                j++;
                continue;
            }
            // if second deck is empty add card from first
            if (j == d2.cards.length) {
                merge.cards[k] = d1.cards[i];
                i++;
                continue;
            }
            // if both decks are not empty compare cards and add the lower one
            if (d1.cards[i].compareTo(d2.cards[j]) > 0) {
                merge.cards[k] = d2.cards[j];
                j++;
            } else {
                merge.cards[k] = d1.cards[i];
                i++;
            }
        }
        return merge;
    }

    /**
     * Simplifying merge sort.
     * @return sorted this deck
     */
    public Deck almostMergeSort() {
        int mid = this.cards.length / 2;
        Deck d1 = subDeck(0, mid);
        Deck d2 = subDeck(mid +1, this.cards.length - 1);
        d1.selectionSort();
        d2.selectionSort();
        return merge(d1, d2);
    }

    /**
     * Merge sort algorithm
     * @return sorted this deck
     */
    public Deck mergeSort() {
        // base case
        if (this.cards.length == 0 || this.cards.length == 1) {
            return this;
        }

        // making two sub decks
        int mid = this.cards.length / 2 - 1;
        Deck d1 = subDeck(0, mid);
        Deck d2 = subDeck(mid + 1, this.cards.length - 1);

        //recursive calls
        d1 = d1.mergeSort();
        d2 = d2.mergeSort();

        return merge(d1, d2);
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
     * @return string contained all cards.
     */
    public String toString() {
        //when one element
        if (cards.length == 1) {
            return "[" + cards[0] + "]";
        }

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
