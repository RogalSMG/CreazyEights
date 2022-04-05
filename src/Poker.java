/**
 * This class contain method to compare poker hands
 */
public class Poker {
    /**
     * Method makes a suits' histogram of given array.
     * @param cards array to make histogram
     * @return array of length of number of colors where
     * value under each index represent amount of card of each color.
     */
    public static int[] suitHist(Card[] cards) {
        int[] hist = new int[Card.SUITS.length];
        for (Card card : cards) {
            hist[card.getSuit()]++;
        }
        return hist;
    }

    /**
     * Check if in given array is index with value equal or greater than 5.
     * @param suits given histogram
     * @return true if number 5 or greater were found in array, otherwise false.
     */
    public static boolean hasFlush(int[] suits) {
        for (int suit : suits) {
            if (suit >= 5) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method makes a ranks histogram of given string.
     * @param cards array to make histogram
     * @return array of length of number of ranks where
     * value under each index represent amount of card of each rank.
     */
    public static int[] rankHist(Card[] cards) {
        int[] hist = new int[Card.RANKS.length];
        for (Card card : cards) {
            hist[card.getRank()]++;
        }
        return hist;
    }
}
