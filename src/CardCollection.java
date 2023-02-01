import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
    private String label;
    protected ArrayList<Card> cardsArr;

    public CardCollection() {
    }

    public CardCollection(String label) {
        this.label = label;
        this.cardsArr = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void addCard(Card card) {
        this.cardsArr.add(card);
    }

    public Card popCard(int i) {
        return this.cardsArr.remove(i);
    }

    /**
     * @return last card in collection
     */
    public Card popCard() {
        return popCard(cardsArr.size() - 1);
    }

    public int size() {
        return this.cardsArr.size();
    }

    public boolean isEmpty() {
        return cardsArr.size() == 0;
    }

    public Card getCard(int i) {
        return cardsArr.get(i);
    }

    public Card getLastCard() {
        return cardsArr.get(cardsArr.size() - 1);
    }

    public void deal(CardCollection that, int i) {
        for (int j = 0; j < i; j++) {
            Card card = popCard();
            that.cardsArr.add(card);
        }
    }

    public void dealAll(CardCollection that) {
        int n = that.size();
        deal(that, n);
    }

    public void swapCards(int i, int j) {
        Card temp = cardsArr.get(i);
        cardsArr.set(i, cardsArr.get(j));
        cardsArr.set(j, temp);
    }

    public void shuffle() {
        Random ran = new Random();
        for (int i = 0; i < cardsArr.size() - 1; i++) {
            int j = ran.nextInt(cardsArr.size() - 1);
            swapCards(i, j);
        }
    }
}
