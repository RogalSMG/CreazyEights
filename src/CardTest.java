import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @org.junit.jupiter.api.Test
    void compareTo() {
        Card card = new Card(6,1);
        Card card1 = new Card(5,0);
        Card card2 = new Card(7,1);
        assertAll(
                () -> assertEquals(0,card.compareTo(card)),
                () -> assertEquals(1,card.compareTo(card1)),
                () -> assertEquals(-1,card.compareTo(card2))
        );
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}