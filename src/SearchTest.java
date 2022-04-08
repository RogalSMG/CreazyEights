import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
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
    void makeDeck() {

    }

    @Test
    void search() {
        assertAll(
                () -> assertEquals(card.position(), Search.search(cards, card)),
                () -> assertEquals(0, Search.search(cards, card1)),
                () -> assertEquals(27, Search.search(cards, card2)),
                () -> assertEquals(51, Search.search(cards, card5))
        );
    }

    @Test
    void binarySearch() {
        assertAll(
                // doesn't work now, cards are sorted in way where aces have the smallest rank.
                // binarySearch use compareTo method where aces are higher than kings.
                () -> assertEquals(card.position(), Search.binarySearch(cards, card)),
                () -> assertEquals(0, Search.binarySearch(cards, card1)),
                () -> assertEquals(27, Search.binarySearch(cards, card2)),
                () -> assertEquals(51, Search.binarySearch(cards, card5))
        );
    }

    @Test
    void binarySearchRecursion() {
    }

    @Test
    void displayCards() {
    }
}