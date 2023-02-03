public class Card {
    public static final String[] RANKS = {null, "as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "walet", "dama", "król"};
    // club, diamond, heart ,spade
    public static final String[] SUITS = {"trefl", "karo", "kier", "pik"};
    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Compare cards ranks. Assume that the lowest card is 2 and the highest ace.
     *
     * @param card card to compare with
     * @return Return +1 if given card is lesser, -1 when greater and 0 if equals.
     */
    public int compareToRanks(Card card) {
        int aceRank = 14;
        int cardRank = this.rank;
        int compareRank = card.rank;

        //change rank of aces from default 1 to 14, one above the kings
        if (this.rank == 1) {
            cardRank = aceRank;
        }
        if (card.rank == 1) {
            compareRank = aceRank;
        }

        // return 0 if equal
        return Integer.compare(cardRank, compareRank);
    }

    /**
     * Compare cards colors
     *
     * @param card to compare with
     * @return Return +1 if given card is lesser, -1 when greater and 0 if equals.
     */
    public int compareToColors(Card card) {
        return Integer.compare(this.suit, card.suit);
    }

    /**
     * Compare cards. Assume that suits are before ranks and the lowest card is 2 and the highest ace.
     *
     * @param card to compare with
     * @return Return +1 if given card is lesser, -1 when greater and 0 if equals.
     */
    public int compareTo(Card card) {
        int color = compareToColors(card);

        if (color != 0) {
            return color;
        } else {
            return compareToRanks(card);
        }
    }

    /**
     * <p>Check if given card obj is equal to this.</p>
     * If are equals return true, if else false.
     *
     * @param card to be checked
     * @return boolean
     */
    public boolean equals(Card card) {
        return (this.rank == card.rank && this.suit == card.suit);
    }

    /**
     * Getter to rank
     *
     * @return Index with represent rank in String[] RANKS.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Getter to suit
     *
     * @return Index which represent suit in String[] SUIT.
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Instance method
     *
     * @return Index of this object in sorted deck.
     */
    public int position() {
        return this.suit * 13 + this.rank - 1;
    }

    /**
     * Method return value of card and it's rank.
     *
     * @return String
     */
    @Override
    public String toString() {
        return RANKS[this.rank] + " " + SUITS[this.suit];
    }
}
