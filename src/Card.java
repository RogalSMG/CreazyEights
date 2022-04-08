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
     * Compare cards. Assume that suits are before ranks and the lowest card is 2 and the highest ace.
     *
     * @param card second card
     * @return Return +1 if given card is lesser, -1 when greater and 0 if equals.
     */
    public int compareTo(Card card) {
        // compare colors
        if (this.suit > card.suit) {
            return 1;
        } else if (this.suit < card.suit) {
            return -1;
        }

        int aceRank = 14;
        int cardRank = this.rank;
        int compareRank = card.rank;

        //change rank of aces, default 1 to 14, 1 higher than kings
        if (this.rank == 1) {
            cardRank = aceRank;
        }
        if (card.rank == 1) {
            compareRank = aceRank;
        }

        // compare ranks
        if (cardRank > compareRank) {
            return 1;
        } else if (cardRank < compareRank) {
            return -1;
        }
        // return 0 if equal
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

    /**
     * Getter to rank
     * @return Index with represent rank in String[] RANKS.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Getter to suit
     * @return Index which represent suit in String[] SUIT.
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Instance method
     * @return Index of this object in sorted deck.
     *
     */
    public int position() {
        return this.suit * 13 + this.rank - 1;
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
