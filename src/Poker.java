/**
 * This class contain method to compare poker hands
 */
public class Poker {
    /**
     * Method makes a suits' histogram of given array.
     *
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
     *
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
     *
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

    public static boolean hasStraight(int[] ranks) {
        //Straight from ten to ace, needed because ace has rank 1
        if (ranks[1] > 0 && ranks[10] > 0 && ranks[11] > 0 && ranks[12] > 0 && ranks[13] > 0) {
            return true;
        }
        int i = 1;
        //find first card
        while (i <= ranks.length - 5) {
            if (ranks[i] > 0) {

                int count = 1;
                //check next four position (cards) if are present
                for (int j = i + 1; j < i + 5; j++) {
                    if (ranks[j] > 0) {
                        count++;
                    } else {
                        i = findNextNoZeroValue(ranks, j);
                        break;
                    }
                }
                if (count >= 5) {
                    return true;
                }
            } else {
                i = findNextNoZeroValue(ranks, i);
            }
        }
        return false;
    }

    /**
     * Helping method. Finding next bigger than zero value and return its index.
     * Start search from index.
     *
     * @param ranks given array to search
     * @param beg   start
     * @return index of next value bigger than 0, if not found return length of array
     */
    private static int findNextNoZeroValue(int[] ranks, int beg) {
        for (int i = beg + 1; i < ranks.length; i++) {
            if (ranks[beg] > 0) {
                return beg;
            } else {
                beg++;
            }
        }
        return ranks.length;
    }


    public static boolean hasPoker(int[] suits, int[] ranks) {
        return (hasStraight(ranks) && hasFlush(suits));
    }
}
