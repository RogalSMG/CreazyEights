import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {
    Card card = new Card(1, 1);
    Card card1 = new Card(1, 0);
    Card card2 = new Card(2, 2);
    Card card3 = new Card(3, 2);
    Card card4 = new Card(1, 1);
    Card card5 = new Card(13, 3);
    Card[] cards = Search.makeDeck();
    Card[] cards1 = {card, card1, card2, card3, card4};
    Card[] cards2 = {card, card, card, card, card};

    @Test
    void testSuitHist() {
        assertAll(
                () -> assertArrayEquals(new int[]{13, 13, 13, 13}, Poker.suitHist(cards)),
                () -> assertArrayEquals(new int[]{1, 2, 2, 0}, Poker.suitHist(cards1))
        );
    }

    @Test
    void testHasFlush() {
        assertAll(
                () -> assertTrue(Poker.hasFlush(Poker.suitHist(cards2))),
                () -> assertFalse(Poker.hasFlush(Poker.suitHist(cards1)))
        );
    }
}