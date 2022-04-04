public class Card {
    private final int rank;
    private final int suit;
    public static final String[] RANKS = {null, "as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "walet", "dama", "król"};
    public static final String[] SUITS = {"trefl", "karo", "kier", "pik"};

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Compare cards, return +1 if given card is lesser, -1 when greater and 0 if equals.
     * @param card second card
     * @return int
     */
    public int compareTo(Card card) {
        if (this.suit > card.suit) {
            return 1;
        } else if (this.suit < card.suit) {
            return -1;
        } else if (this.rank > card.rank) {
            return 1;
        } else if (this.rank < card.rank) {
            return -1;
        }
        return 0;
    }

    /**
     * <p>Check if given card obj is equal to this.</p>
     * If are equals return true, if else false.
     * @param card checked card
     * @return boolean
     */
    public boolean equals(Card card) {
        return (this.rank == card.rank && this.suit == card.suit);
    }

    public static Card[] makingDeck() {
        Card[] deck = new Card[52];
        int ii = 0;
        for (int i = 0; i < SUITS.length; i++) {
            for (int j = 0; j < RANKS.length - 1; j++) {
                deck[ii] = new Card(j,i);
            }
        }
        return deck;
    }

    /**
     * Getter to rank
     * @return int
     */
    public int getRank() {
        return rank;
    }

    /**
     * Getter to suit
     * @return int
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Method return value of card and it's rank.
     * @return String
     */
    @Override
    public String toString() {
        return RANKS[this.rank] + " " + SUITS[this.suit];
    }
}
