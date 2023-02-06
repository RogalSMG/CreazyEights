package eights.player;

import game.Card;
import game.Eights;

import java.util.ArrayList;

public class HighestRankEightsPlayer extends EightsPlayer{
    public HighestRankEightsPlayer(String name) {
        super(name);
    }

    public Card play(Eights eight, Card prev) {
        Card toPlay = highCardFirst(prev);
        if (toPlay == null) {
            return drawForMatch(eight, prev);
        }
        getHand().cards.remove(toPlay);
        return toPlay;
    }

    /**
     * Method which return card with the highest rank
     *
     * @param prev top card on discard pile
     * @return highest card to play
     */
    private Card highCardFirst(Card prev) {
        ArrayList<Card> cards = this.searchAllMatches(prev);
        int cardsSize = cards.size();

        //if there is no matches in hand
        if (cardsSize == 0) {
            return null;
        }

        // if only one card matches
        if (cardsSize == 1) {
            return cards.get(0);
        }

        return highestRank(cards);
    }
}
