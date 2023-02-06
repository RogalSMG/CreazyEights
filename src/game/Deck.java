package game;

public class Deck extends CardCollection {

    /**
     * Constructor of super class
     * @param label name of deck
     */
    public Deck(String label) {
        super(label);
        for (int suit = 0; suit <= Card.SUITS.length - 1; suit++) {
            for (int rank = 1; rank <= Card.RANKS.length - 1; rank++) {
                addCard(new Card(rank, suit)); // using inherited method addCard which is wrapped method for .add method from list collection
                // super.cards.add(new game.Card(rank, suit)); doing same, reference to arrayList field 'cards' in super class and calling build in .add method
            }
        }
    }
}
