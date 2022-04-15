import java.util.ArrayList;
import java.util.Collections;

public class Pile {
    private final ArrayList<Card> cards;

    public Pile() {
        this.cards = new ArrayList<>();
    }

    public Pile(Card[] cards) {
        this.cards = new ArrayList<>();
        Collections.addAll(this.cards, cards);
    }

    /**
     * Take first card in cards arrayList, remove and return it
     * @return Card at index 0
     */
    public Card popCard() {
        return this.cards.remove(0);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Add all card in given pile to this pile
     * @param pile given pile
     */
    public void addCard(Pile pile) {
        for (Card card : pile.getCards()) {
            this.addCard(card);
        }
    }

    public void addCard(Deck deck) {
        Collections.addAll(this.cards, deck.getCards());
    }

    public void removeAllCard() {
        this.cards.clear();
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int size() {
        return this.cards.size();
    }
}
