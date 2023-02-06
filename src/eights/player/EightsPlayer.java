package eights.player;

import eights.card.EightsCard;
import game.Card;
import game.Eights;
import game.Player;

import java.util.ArrayList;

/**
 * Class with methods for Crazy Eights game
 */
public class EightsPlayer extends Player {

    /**
     * Standard constructor
     *
     * @param name name of player
     */
    public EightsPlayer(String name) {
        super(name);
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
     * Method make a list of possible cards to play
     *
     * @param prev last card on discard pile
     * @return list of playable cards
     */
    protected ArrayList<Card> searchAllMatches(Card prev) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < getHand().size(); i++) {
            Card checked = getHand().getCard(i);
            if (EightsCard.cardMatches(prev, checked)) {
                cards.add(checked);
            }
        }
        return cards;
    }

    /**
     * Method where card with the highest rank will be searched
     * @param cards list of cards
     * @return highest card by rank
     */
    protected Card highestRank(ArrayList<Card> cards) {
        Card highest = cards.get(0);
        for (int i = 1; i < cards.size(); i++) {
            Card temp = cards.get(i);
            if (highest.compareToRanks(temp) == -1) {
                highest = temp;
            }
        }
        return highest;
    }
}
