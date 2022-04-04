public class Card {
    private int rank;
    private int suit;
    public static final String[] RANKS = {null, "as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "walet", "dama", "król"};
    public static final String[] SUITS = {"trefl", "karo", "kier", "pik"};

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

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

    /**
     * Method return value of card and it's rank.
     * @return String
     */
    @Override
    public String toString() {
        return RANKS[this.rank] + " " + SUITS[this.suit];
    }
}
