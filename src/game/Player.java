package game;

import eights.Eights;
import eights.card.EightsCard;
import eights.hand.EightsHand;

public class Player {
    private final String name;
    private final EightsHand hand; // Normal player should have normal hand

    public Player(String name) {
        this.name = name;
        this.hand = new EightsHand(name + " hand");
    }

    public String getName() {
        return name;
    }

    public EightsHand getHand() {
        return this.hand;
    }

    /**
     * Method where player choose card to play
     *
     * @param eights state of game
     * @param prev the previous card to play to
     * @return available card to play
     */
    public Card play(Eights eights, Card prev) {

        return null;
    }

    /**
     * Return first card which is proper to play
     *
     * @param prev card for which a matching card is searched
     * @return game.Card to play
     */
    protected Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (EightsCard.cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        }
        return null;
    }

    /**
     * Draw next cards from pile until find match
     *
     * @param eights state of game
     * @param prev   card at top of the discard pile
     * @return return first matching card
     */
    protected Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.draw();
            System.out.printf("%s drawn: %s\n", name, card);
            if (EightsCard.cardMatches(card, prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }

    public void displayScore() {
        System.out.println(hand.calculateScore());
    }
}
