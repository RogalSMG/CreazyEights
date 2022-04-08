import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card card = new Card(1, 1);
    Card card1 = new Card(1, 0);
    Card card2 = new Card(2, 2);
    Card card3 = new Card(3, 2);
    Card card4 = new Card(1, 1);
    Card card5 = new Card(13, 3);

    @Test
    void compareTo() {
        assertAll(
                () -> assertEquals(0, card.compareTo(card)),
                () -> assertEquals(1, card.compareTo(card1)),
                () -> assertEquals(-1, card1.compareTo(card)),
                () -> assertEquals(-1, card.compareTo(card2)),
                () -> assertEquals(1, card3.compareTo(card2)),
                () -> assertEquals(-1, card2.compareTo(card3))
        );
    }

    @Test
    void testEquals() {
        assertAll(
                () -> assertEquals(card, card), // do not test method
                () -> assertTrue(card.equals(card4)),
                () -> assertFalse(card.equals(card1)),
                () -> assertFalse(card.equals(card2))
        );
    }

    @Test
    void testToString() {
        assertAll(
                () -> assertEquals("as karo",card.toString()),
                () -> assertEquals("as trefl",card1.toString()),
                () -> assertEquals("2 kier",card2.toString()),
                () -> assertEquals("3 kier",card3.toString()),
                () -> assertEquals("król pik",card5.toString())
        );
    }

    @Test
    void testPosition() {
        assertAll(
                () -> assertEquals(13, card.position()),
                () -> assertEquals(0, card1.position()),
                () -> assertEquals(27, card2.position()),
                () -> assertEquals(28, card3.position()),
                () -> assertEquals(13, card4.position()),
                () -> assertEquals(51, card5.position())
        );
    }
}