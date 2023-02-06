package game;

import java.util.ArrayList;
import java.util.Random;

public abstract class CardCollection {
    private final String label;
    public ArrayList<Card> cards;

    public CardCollection(String label) {
        this.label = label;
        this.cards = new ArrayList<>();
    }

    /**
     * Give name of this game.CardCollection
     *
     * @return String representation of name
     */
    protected String getLabel() {
        return label;
    }

    /**
     * Wrapper method for <code>ArrayList</code> .add() method
     *
     * @param card given <code>game.Card</code> obj in order to add to <code>cards</code>
     *             field which is an object of <code>ArrayList</code> class parametrized by <code>game.Card</code> class
     */
    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Return specified card from a list
     *
     * @param i index of card
     * @return game.Card object under i index
     */
    public Card popCard(int i) {
        return this.cards.remove(i);
    }

    /**
     * Remove last card in collection and return them
     *
     * @return last card in collection
     */
    public Card popCard() {
        int i = cards.size() - 1;
        return popCard(i);
    }

    public void remove(Card card) {
        cards.remove(card);
    }

    /**
     * Wrapper method for ArrayList .size() method
     *
     * @return size of this <Code>cards</Code> array
     */
    public int size() {
        return this.cards.size();
    }

    /**
     * @return return true if cards field has none cards object inside, in other case false
     */
    public boolean isEmpty() {
        return size() == 0;

    }

    /**
     * Method give specified card from cards field
     *
     * @param i index of card to return
     * @return card object under i index
     */
    public Card getCard(int i) {
        return cards.get(i);
    }

    /**
     * Method give last game.Card obj
     *
     * @return last game.Card obj in
     */
    public Card getLastCard() {
        return getCard(cards.size() - 1);
    }

    /**
     * Method which deal specified amount of cards to that obj
     *
     * @param that game.CardCollection object where cards will be added
     * @param i    amount of cards
     */
    public void deal(CardCollection that, int i) {
        for (int j = 0; j < i; j++) {
            Card card = popCard();
            that.addCard(card);
        }
    }

    /**
     * Method which deal adda all cards from given {@code game.CardCollection} to that obj
     *
     * @param that given card collection where cards will be added
     */
    public void dealAll(CardCollection that) {
        int n = size();
        deal(that, n);
    }

    /**
     * Method which change place of two obj in <code>this</code> cards field
     *
     * @param i index of first card
     * @param j index of second card
     */
    public void swapCards(int i, int j) {
        Card temp = getCard(i);
        cards.set(i, getCard(j));
        cards.set(j, temp);
    }

    /**
     * Method randomly change places of all <code>card</code> objects in <code>this</code> cards field
     */
    public void shuffle() {
        Random ran = new Random();
        for (int i = 0; i < cards.size() - 1; i++) {
            int j = ran.nextInt(cards.size() - 1);
            swapCards(i, j);
        }
    }

    /**
     * Print all cards. Representation consists of a list of the collection's
     * elements in the order they are returned by its iterator,
     * enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (comma and space).
     */
    public void showCards() {
        String str = cards.toString();
        System.out.printf("%s\n", str);
    }
}
