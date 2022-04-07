/**
 * Searching and displaying static methods.
 *
 * @author Daniel
 */
public class Search {

    /**
     * Makes an array of all cards.
     *
     * @return Card[]
     */
    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (int i = 0; i < Card.SUITS.length; i++) {
            for (int j = 1; j < Card.RANKS.length; j++) {
                cards[index] = new Card(j, i);
                index++;
            }
        }
        return cards;
    }

    /**
     * Sequential search.
     *
     * @param cards array of cards obj
     * @param card  card obj
     * @return Index of given card in card array, if it does not found return -1.
     */
    public static int search(Card[] cards, Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(card)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary search. Work only if given array is sorted according to compareTo method.
     *
     * @param cards array to search
     * @param card  obj to find
     * @return Index of given card in card array, if it does not found return -1.
     */
    public static int binarySearch(Card[] cards, Card card) {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = cards[mid].compareTo(card);

            if (result == 0) {
                return mid;
            } else if (result == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Binary search using recursion.
     *
     * @param cards  array to search
     * @param target card to found
     * @param low    lowest index of cards array
     * @param high   highest index of cards array
     * @return Index of target card in card array, if it does not found return -1.
     */
    public static int binarySearchRecursion(Card[] cards, Card target, int low, int high) {
        System.out.println(low + ", " + high);

        if (high < low) {
            return -1;
        }
        int mid = (low + high) / 2;
        int comp = cards[mid].compareTo(target);

        if (comp == 0) {
            return mid;
        } else if (comp < 0) {
            return binarySearchRecursion(cards, target, mid + 1, high);
        } else {
            return binarySearchRecursion(cards, target, low, mid - 1);
        }
    }
}
