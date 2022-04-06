/**
 * This class contain method to compare poker hands
 */
public class Poker {

    /**
     * Method check if given array has value 2 under any index.
     *
     * @param ranks given array
     * @return true if found any 2, otherwise false
     */
    public static boolean hasPair(int[] ranks) {
        return wherePair(ranks, 1) >= 0;
    }

    /**
     * Method check if given array has value 2 under any index.
     *
     * @param ranks given array
     * @param index int value where method start to search, included
     * @return index of given array where were value 2 founded,
     * return -1 if method do not find any 2
     */
    private static int wherePair(int[] ranks, int index) {
        for (int i = index; i < ranks.length; i++) {
            if (ranks[i] == 2) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method check if given array contains two two values.
     *
     * @param ranks given array
     * @return true if found two pairs, otherwise false
     */
    public static boolean hasTwoPairs(int[] ranks) {
        int nextIndex = 1;
        for (int i = 0; i < 2; i++) {
            int pairIndex = wherePair(ranks, nextIndex);
            if (pairIndex <= 0) {
                return false;
            }
            nextIndex = pairIndex + 1;
        }
        return true;
    }

    /**
     * Method check if given array has value 3 under any index.
     *
     * @param ranks given array
     * @return true if found any 3 value in array, otherwise false
     */
    public static boolean hasTriple(int[] ranks) {
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] == 3) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method check if given array has value 4 under any index.
     *
     * @param ranks given array
     * @return true if found any 4 value in array, otherwise false
     */
    public static boolean hasFours(int[] ranks) {
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasFullHouse(int[] ranks) {
        return (hasPair(ranks) && hasTriple(ranks));
    }

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
     * @param suits given array
     * @return true if number 5 or greater were found in array, otherwise false
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
     * value under each index represent amount of card of each rank
     */
    public static int[] rankHist(Card[] cards) {
        int[] hist = new int[Card.RANKS.length];
        for (Card card : cards) {
            hist[card.getRank()]++;
        }
        return hist;
    }

    /**
     * Check if given array has five consecutive values next to each other.
     *
     * @param ranks given array
     * @return true if there are five consecutive values next to each other,
     * otherwise false
     */
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
                    //when found increase count
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
     * Helping method. Finding next index where value is bigger than zero.
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

    /**
     * Method check if given cards array has poker. That is, it has both straight and flush.
     *
     * @param cards given array
     * @return true if given array is poker, otherwise false
     */
    public static boolean hasPoker(Card[] cards) {
        int[] suitsHist = suitHist(cards);
        int[] rankHist = rankHist(cards);
        return (hasStraight(rankHist) && hasFlush(suitsHist));
    }
}
