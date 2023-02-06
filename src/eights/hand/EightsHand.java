package eights.hand;

import game.Card;
import game.Hand;

public class EightsHand extends Hand {
    /**
     * Basic constructor
     *
     * @param label name of this hand
     */
    public EightsHand(String label) {
        super(label);
    }

    /**
     * Method count penalty points for cards left in the player hand
     *
     * @return score in {@code int}
     */
    public int calculateScore() {
        int score = 0;
        for (int i = 0; i < this.size(); i++) {
            Card card = this.getCard(i);
            if (card.getRank() == 8) { // for eights minus 20
                score -= 20;
            } else if (card.getRank() == 1) { // for aces where rank is 1
                score -= 10;
            } else {
                score -= Math.min(card.getRank(), 10); // for rest cards their rank, or above 10 always 10
            }
        }
        return score;
    }
}
