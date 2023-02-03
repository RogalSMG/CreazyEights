public class Player {
    private final String name;
    private final Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand(name + " hand");
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return this.hand;
    }

    /**
     * Method where player choose card to play
     *
     * @param eights state of game
     * @param prev   the previous card to play to
     * @return available card to play
     */
    public Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    /**
     * return first card which is proper to play
     *
     * @param prev card for which a matching card is searched
     * @return Card to play
     */
    private Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        }
        return null;
    }

    /**
     * Draw next cards from pile until find match
     *
     * @param eights state of game
     * @param prev card at top of the discard pile
     * @return return first matching card
     */
    private Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.draw();
            System.out.printf("Drawn Card: %s", card);
            if (cardMatches(card, prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }

    /**
     * Check if given cards match each other
     *
     * @param card card to play
     * @param prev last card on discardPile
     * @return true if they match, else false
     */
    private boolean cardMatches(Card card, Card prev) {
        return card.getRank() == prev.getRank() || card.getSuit() == prev.getSuit() || card.getRank() == 8;
    }

    /**
     * Method count penalty points for cards left in the player hand
     *
     * @return score in {@code int}
     */
    public int displayScore() {
        int score = 0;
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (card.getRank() == 8) { // for eights minus 20
                score -= 20;
            } else if (card.getRank() == 2) {
                score -= 10;
            } else {
                score -= Math.min(card.getRank(), 10);
            }
        }
        return score;
    }

    /**
     * Wrapped method which display player hand
     */
    public void display() {
        hand.display();
    }
}
