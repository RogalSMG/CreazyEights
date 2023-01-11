import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
    private String label;
    protected ArrayList<Card> cards;

    public CardCollection() {
    }

    public CardCollection(String label) {
        this.label = label;
        this.cards = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card popCard(int i) {
        return this.cards.remove(i);
    }

    /**
     * @return last card in collection
     */
    public Card popCard() {
        return popCard(cards.size() - 1);
    }

    public int size() {
        return this.cards.size();
    }

    public boolean isEmpty() {
        return cards.size() == 0;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }

    public void deal(CardCollection that, int i) {
        for (int j = 0; j < i; j++) {
            Card card = popCard();
            that.cards.add(card);
        }
    }

    public void dealAll(CardCollection that) {
        int n = that.size();
        deal(that, n);
    }

    public void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    public void shuffle() {
        Random ran = new Random();
        for (int i = 0; i < cards.size() - 1; i++) {
            int j = ran.nextInt(cards.size() - 1);
            swapCards(i, j);
        }
    }
}
