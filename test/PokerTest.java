import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {
    Card card = new Card(1, 1);
    Card card1 = new Card(1, 0);
    Card card2 = new Card(2, 2);
    Card card3 = new Card(3, 2);
    Card card4 = new Card(1, 1);
    Card card5 = new Card(13, 3);
    Card card6 = new Card(4, 2);
    Card card7 = new Card(5, 2);
    Card card8 = new Card(6, 2);
    Card card9 = new Card(6, 3);
    Card card10 = new Card(10, 2);
    Card card11 = new Card(11, 2);
    Card card12 = new Card(12, 2);
    Card card13 = new Card(13, 2);
    Card card14 = new Card(9, 2);

    Card[] cards = Search.makeDeck();
    Card[] cards1 = {card, card1, card2, card3, card4};
    Card[] cards2 = {card, card, card, card, card};
    Card[] straightAce = {card1, card2, card3, card6, card7};
    Card[] straightTwo = {card2, card3, card6, card7, card9};
    Card[] straightTen = {card10, card11, card12, card13, card1};
    Card[] straightNine = {card14, card10, card11, card12, card13};
    Card[] poker = {card2, card3, card6, card7, card8};
    Card[] onePair = {card, card1, card6, card7, card8};
    Card[] twoPairs = {card8, card9, card1, card4, card14};
    Card[] triple = {card, card1, card4, card7, card8};
    Card[] fours = {card, card1, card4, card, card8};
    Card[] fullHouse = {card, card1, card4, card9, card8};

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

    @Test
    void testRankHist() {
        assertAll(
                () -> assertArrayEquals(new int[]{0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, Poker.rankHist(cards)),
                () -> assertArrayEquals(new int[]{0, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, Poker.rankHist(cards1))
        );
    }

    @Test
    void testHasStraight() {
        assertAll(
                () -> assertFalse(Poker.hasStraight(Poker.rankHist(cards2))),
                () -> assertFalse(Poker.hasStraight(Poker.rankHist(cards1))),
                () -> assertTrue(Poker.hasStraight(Poker.rankHist(straightAce))),
                () -> assertTrue(Poker.hasStraight(Poker.rankHist(straightTwo))),
                () -> assertTrue(Poker.hasStraight(Poker.rankHist(straightNine))),
                () -> assertTrue(Poker.hasStraight(Poker.rankHist(straightTen)))
        );
    }

    @Test
    void testHasPoker() {
        assertAll(
                () -> assertTrue(Poker.hasPoker(poker)),
                () -> assertFalse(Poker.hasPoker(straightTwo)),
                () -> assertFalse(Poker.hasPoker(cards2))
        );
    }

    @Test
    void TestHasPair() {
        assertAll(
                () -> assertFalse(Poker.hasPair(Poker.rankHist(poker))),
                () -> assertFalse(Poker.hasPair(Poker.rankHist(straightTwo))),
                () -> assertFalse(Poker.hasPair(Poker.rankHist(cards2))),
                () -> assertTrue(Poker.hasPair(Poker.rankHist(onePair)))
        );
    }

    @Test
    void TestHasTwoPairs() {
        assertAll(
                () -> assertFalse(Poker.hasTwoPairs(Poker.rankHist(poker))),
                () -> assertFalse(Poker.hasTwoPairs(Poker.rankHist(straightTwo))),
                () -> assertFalse(Poker.hasTwoPairs(Poker.rankHist(cards2))),
                () -> assertFalse(Poker.hasTwoPairs(Poker.rankHist(onePair))),
                () -> assertTrue(Poker.hasTwoPairs(Poker.rankHist(twoPairs)))
        );
    }

    @Test
    void testHasTriple() {
        assertAll(
                () -> assertFalse(Poker.hasTriple(Poker.rankHist(cards2))),
                () -> assertFalse(Poker.hasTriple(Poker.rankHist(onePair))),
                () -> assertFalse(Poker.hasTriple(Poker.rankHist(twoPairs))),
                () -> assertTrue(Poker.hasTriple(Poker.rankHist(triple)))
        );
    }

    @Test
    void testHasFours() {
        assertAll(
                () -> assertFalse(Poker.hasFours(Poker.rankHist(cards2))),
                () -> assertFalse(Poker.hasFours(Poker.rankHist(onePair))),
                () -> assertFalse(Poker.hasFours(Poker.rankHist(twoPairs))),
                () -> assertFalse(Poker.hasFours(Poker.rankHist(triple))),
                () -> assertTrue(Poker.hasFours(Poker.rankHist(fours)))
        );
    }

    @Test
    void testHasFullHouse() {
        assertAll(
                () -> assertFalse(Poker.hasFullHouse(Poker.rankHist(cards2))),
                () -> assertFalse(Poker.hasFullHouse(Poker.rankHist(onePair))),
                () -> assertFalse(Poker.hasFullHouse(Poker.rankHist(twoPairs))),
                () -> assertFalse(Poker.hasFullHouse(Poker.rankHist(triple))),
                () -> assertFalse(Poker.hasFullHouse(Poker.rankHist(fours))),
                () -> assertTrue(Poker.hasFullHouse(Poker.rankHist(fullHouse)))
        );
    }
}