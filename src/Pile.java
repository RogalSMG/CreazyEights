import java.util.ArrayList;
import java.util.Collections;

public class Pile {
    private final ArrayList<Card> cards;

    public Pile() {
        this.cards = new ArrayList<>();
    }

    public Card popCard() {
        return this.cards.remove(0);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public void addDeck(Deck deck) {
        Collections.addAll(this.cards, deck.getCards());
    }
}
