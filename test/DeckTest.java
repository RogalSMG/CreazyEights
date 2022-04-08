import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Card card = new Card(1, 1);
    Card card1 = new Card(1, 0);
    Card card2 = new Card(2, 0);
    Card card3 = new Card(3, 0);
    Card card4 = new Card(4, 0);
    Card card5 = new Card(5, 0);
    Card[] cards = Search.makeDeck();
    Card[] cards1 = {card, card1, card2, card3, card4, card5};
    Card[] cards2 = {card, card, card, card, card};

    @Test
    void findLowestCard() {
        Deck deck = new Deck();
        deck.setCards(cards1);
        assertAll(
                () -> assertEquals(2, deck.findLowestCard(0, deck.getCards().length))
        );
    }
}