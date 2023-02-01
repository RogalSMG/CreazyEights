public class WarGame {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        int mid = deck.getCards().length / 2;

        Pile p1 = new Pile(deck.subDeck(0, mid).getCards());
        Pile p2 = new Pile(deck.subDeck(mid, deck.getCards().length).getCards());

        System.out.println(p1.getCards().size());
        System.out.println(p2.getCards().size());

        Pile stock = new Pile();

        while (!p1.isEmpty() && !p2.isEmpty()) {
            System.out.println(p1.getCards().size());
            System.out.println(p2.getCards().size());

            //pull out cards
            Card c1 = p1.popCard();
            stock.addCard(c1);
            Card c2 = p2.popCard();
            stock.addCard(c2);

            int diff = c1.compareToRanks(c2);
            if (diff > 0) {
                p1.addCard(stock);
            } else if (diff < 0) {
                p2.addCard(stock);
            } else {
                if (p1.size() > 4 && p2.size() > 4) {
                    for (int i = 0; i < 3; i++) {
                        stock.addCard(p1.popCard());
                        stock.addCard(p2.popCard());
                    }
                    continue;
                } else {
                    break;
                }
            }

            stock.removeAllCard();
        }

        if (p1.size() < p2.size()) {
            System.out.println("Player two has won");
        } else {
            System.out.println("Player one has won");
        }
    }
}
