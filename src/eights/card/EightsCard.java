package eights.card;

import game.Card;

public class EightsCard extends Card{


    public EightsCard(int rank, int suit) {
        super(rank, suit);
    }

    /**
     * Check if given cards match each other
     *
     * @param card card to play
     * @param prev last card on discardPile
     * @return true if they match, else false
     */
    public static boolean cardMatches(Card card, Card prev) {
        return card.getRank() == prev.getRank() || card.getSuit() == prev.getSuit() || card.getRank() == 8;
    }
}
