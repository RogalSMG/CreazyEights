package eights;

import eights.player.EightsPlayer;
import eights.player.EightsEightsPlayer;
import eights.player.HighestRankEightsPlayer;
import game.Card;
import game.Deck;
import game.Hand;
import game.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulate Crazy Eight Game <p>
 * Basics rule you can find under following address:
 * <a href="https://en.wikipedia.org/wiki/Crazy_Eights">Crazy eights.Eights</a>
 */
public class Eights {
    public final ArrayList<Player> players;

    private final Hand drawPile;
    private final Hand discardPile;
    private final Scanner in;

    /**
     * Basic constructor which initialize starting conditions of game
     */
    public Eights() {
        Deck deck = new Deck("game.Deck");
        deck.shuffle();

        players = new ArrayList<>();

        int startingHandSize = 10;
        EightsPlayer playerOne = new EightsPlayer("Daniel");
        deck.deal(playerOne.getHand(), startingHandSize);

        EightsEightsPlayer playerTwo = new EightsEightsPlayer("Johnny");
        deck.deal(playerTwo.getHand(), startingHandSize);

        HighestRankEightsPlayer playerThree = new HighestRankEightsPlayer("Inexperienced");
        deck.deal(playerThree.getHand(), startingHandSize);

        players.add(playerOne);
        players.add(playerTwo);
        players.add(playerThree);

        drawPile = new Hand("Draw Pile");
        deck.dealAll(drawPile);

        discardPile = new Hand("Discard Pile");
        discardPile.addCard(drawPile.popCard());

        in = new Scanner(System.in);

    }

    /**
     * Method check if one of players hands is empty and game should end
     *
     * @return true if some player hand in empty
     */
    public boolean isDone() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method make new drawPile and left last card in discard pile
     */
    public void reshuffle() {
        Card prev = discardPile.popCard();
        discardPile.dealAll(drawPile);
        drawPile.shuffle();
        discardPile.addCard(prev);
    }

    /**
     * Drawing top card from drawing pile
     *
     * @return top card of drawing pile
     */
    public Card draw() {
        if (drawPile.isEmpty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    /**
     * Move turn to next player
     *
     * @param current actual player
     * @return next player
     */
    public Player nextPlayer(Player current) {
        if (current == players.get(players.size() - 1)) {
            return players.get(0);
        }
        return players.get(players.indexOf(current) + 1);
    }

    /**
     * display basic info about current state of game
     */
    public void displayState() {
        for (Player player : players) {
            player.getHand().displayInRow();
        }

        discardPile.displayInRow();
        System.out.printf("Drawing pile has a: %d cards\n", drawPile.size());
        // in.nextLine();
    }

    /**
     * Actions which current player have to make
     *
     * @param player current player
     */
    public void takeTurn(Player player) {
        Card prev = discardPile.getLastCard(); // check last card on discard pile
        Card next = player.play(this, prev); // play next possible card from current player deck
        discardPile.addCard(next);

        System.out.printf("game.Player %s play: %s \n", player.getName(), next);
        System.out.println();
    }

    /**
     * Method which start game until one of the players will have empty
     */
    public void playGame() {
        Player player = players.get(0);

        while (!isDone()) {
            displayState();
            takeTurn(player);
            player = nextPlayer(player);
        }

        for (Player x : players) {
            x.displayScore();
        }
    }

    public Player currentPlayer() {
        return null;
    }
}
