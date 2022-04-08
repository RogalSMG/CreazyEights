import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    Card card = new Card(1, 1);
    Card card0 = new Card(2, 0);
    Card card1 = new Card(1, 0);
    Card card2 = new Card(2, 2);
    Card card3 = new Card(3, 2);
    Card card4 = new Card(1, 1);
    Card card5 = new Card(13, 3);
    Card card51 = new Card(1, 3);
    Card[] cards = Search.makeDeck();
    Card[] cards1 = {card, card1, card2, card3, card4};
    Card[] cards2 = {card, card, card, card, card};

    @Disabled
    void testMakeDeck() {

    }

    @Test
    void testSearch() {
        Search.selectionSort(cards);
        assertAll(
                () -> assertEquals(25, Search.search(cards, card)),
                () -> assertEquals(12, Search.search(cards, card1)),
                () -> assertEquals(0, Search.search(cards, card0)),
                () -> assertEquals(50, Search.search(cards, card5)),
                () -> assertEquals(51, Search.search(cards, card51)),
                () -> assertEquals(1, Search.search(cards1, card1))
        );
    }

    @Test
    void testBinarySearch() {
        Search.selectionSort(cards);
        Search.selectionSort(cards1);
        assertAll(
                // doesn't work if not sorted, cards are sorted by default in way where aces have the smallest rank.
                // binarySearch use compareTo method where aces are higher than kings.
                () -> assertEquals(25, Search.binarySearch(cards, card)),
                () -> assertEquals(12, Search.binarySearch(cards, card1)),
                () -> assertEquals(0, Search.binarySearch(cards, card0)),
                () -> assertEquals(50, Search.binarySearch(cards, card5)),
                () -> assertEquals(Search.search(cards1, card1), Search.binarySearch(cards1, card1))
        );
    }

    @Disabled
    void binarySearchRecursion() {
    }

    @Disabled
    void displayCards() {
    }
}