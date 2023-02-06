package game;

import game.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class DeckTest {
    Card card = new Card(1, 1);
    Card card1 = new Card(1, 0);
    Card card2 = new Card(2, 0);
    Card card3 = new Card(3, 0);
    Card card4 = new Card(4, 0);
    Card card5 = new Card(5, 0);
    Card[] cards1 = {card, card1, card2, card3, card4, card5};
    Card[] cards2 = {card, card, card, card, card};
    Card[] cardsMerge = {card};
    Card[] cardsMerge0 = {};
    Card[] cardsMerge2 = {card2, card1};
    // Filled with all cards, starting from ace club

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }
}