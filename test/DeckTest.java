import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    Card[] cardsMerge = {card};
    Card[] cardsMerge0 = {};
    Card[] cardsMerge2 = {card2, card1};
    // Filled with all cards, starting from ace club
    Deck deck = new Deck();

    @Test
    void testFindLowestCard() {
        deck.setCards(cards1);
        assertEquals(2, deck.findLowestCard(0, deck.getCards().length));
        deck.selectionSort();
        assertEquals(0, deck.findLowestCard(0, deck.getCards().length));
    }

    @Test
    void testSelectionSort() {
        Deck d1 = new Deck(cards1);
        assertEquals("[as karo, as trefl, 2 trefl, 3 trefl, 4 trefl, 5 trefl]",d1.toString());
        d1.selectionSort();
        assertEquals("[2 trefl, 3 trefl, 4 trefl, 5 trefl, as trefl, as karo]",d1.toString());
    }

    @Test
    void testSubDeck() {
        Deck sub = deck.subDeck(0,2);
        assertEquals("[as trefl, 2 trefl, 3 trefl]", sub.toString());
        sub = deck.subDeck(1,3);
        assertEquals("[2 trefl, 3 trefl, 4 trefl]", sub.toString());
        sub = deck.subDeck(0,1);
        assertEquals("[as trefl, 2 trefl]", sub.toString());
        sub = deck.subDeck(0,0);
        assertEquals("[as trefl]", sub.toString());
    }

    @Test
    void testAlmostMergeSort() {
        deck.setCards(cards1);
        assertEquals("[as karo, as trefl, 2 trefl, 3 trefl, 4 trefl, 5 trefl]",deck.toString());
        deck = deck.almostMergeSort();
        assertEquals("[2 trefl, 3 trefl, 4 trefl, 5 trefl, as trefl, as karo]",deck.toString());
    }

    @Test
    void testMergeSort() {
        deck.setCards(cards1);
        assertEquals("[as karo, as trefl, 2 trefl, 3 trefl, 4 trefl, 5 trefl]",deck.toString());
        deck = deck.mergeSort();
        assertEquals("[2 trefl, 3 trefl, 4 trefl, 5 trefl, as trefl, as karo]",deck.toString());
    }


    @Test
    void testToString() {
        deck.setCards(cards1);
        assertEquals("[as karo, as trefl, 2 trefl, 3 trefl, 4 trefl, 5 trefl]",deck.toString());
        deck.selectionSort();
        assertEquals("[2 trefl, 3 trefl, 4 trefl, 5 trefl, as trefl, as karo]",deck.toString());
        Deck empty = new Deck(0);
        assertEquals("",empty.toString());
        Deck nullInside = new Deck(1);
        assertEquals("[null]",nullInside.toString());

    }

    @Test
    void merge() {
        Deck d = new Deck(cardsMerge);
        Deck d0 = new Deck(cardsMerge0);
        Deck d2 = new Deck(cardsMerge2);
        assertAll(
                () -> assertEquals("[2 trefl, as trefl, as karo]",(d.merge(d,d2).toString())),
                () -> assertEquals("[2 trefl, 2 trefl, as trefl, as trefl]",(d.merge(d2,d2).toString())),
                () -> assertEquals("[2 trefl, as trefl]",(d.merge(d0,d2).toString())),
                () -> assertEquals("",(d.merge(d0,d0).toString()))
        );
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }
}