package eights.player;

import game.Card;
import eights.Eights;

import java.util.ArrayList;

/**
 * Class where player play 8 first
 */
public class EightsEightsPlayer extends EightsPlayer {
    public EightsEightsPlayer(String name) {
        super(name);
    }

    /**
     *
     * @param eights state of game
     * @param prev the previous card to play to
     * @return card to play
     */
    public Card play(Eights eights, Card prev) {
        ArrayList<Card> matches = this.searchAllMatches(prev);
        Card toPlay = findTheBest(matches);
        if (toPlay == null) {
            return drawForMatch(eights, prev);
        }
        getHand().remove(toPlay);
        return toPlay;
    }

    private Card findTheBest(ArrayList<Card> matches) {
        int size = matches.size();
        // when no matches return null
        if (size == 0) {
            return null;
        }

        // if only one match, return them
        Card theBest = matches.get(0);
        if (size == 1) {
            return theBest;
        }

        // look for eights
        for (Card match : matches) {
            if (match.getRank() == 8) {
                return match;
            }
        }

        // if no eights play highest
        return highestRank(matches);
    }

}
