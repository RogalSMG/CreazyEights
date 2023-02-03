import java.util.Scanner;

/**
 * Simulate Crazy Eight Game <p>
 * Basics rule you can find under following address:
 * <a href="https://en.wikipedia.org/wiki/Crazy_Eights">Crazy Eights</a>
 */
public class Eights {
    private final Player playerOne;
    private final Player playerTwo;
    private final Hand drawPile;
    private final Hand discardPile;
    private final Scanner in;

    /**
     * Basic constructor which initialize starting conditions of game
     */
    public Eights() {
        Deck deck = new Deck("Deck");
        deck.shuffle();

        int startingHandSize = 5;
        playerOne = new Player("Daniel");
        deck.deal(playerOne.getHand(), startingHandSize);

        playerTwo = new Player("Johnny");
        deck.deal(playerTwo.getHand(), startingHandSize);

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
        return playerOne.getHand().isEmpty()
                || playerTwo.getHand().isEmpty();
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
     * Drawing top card from drawing card
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
        if (current == playerOne) {
            return playerTwo;
        } else return playerOne;
    }

    /**
     * display basic info about current state of game
     */
    public void displayState() {
        playerOne.display();
        playerTwo.display();
        discardPile.display();
        System.out.printf("Drawing pile has a: %d cards\n", drawPile.size());
        in.nextLine();
    }

    /**
     * Actions which current player have to make
     *
     * @param player current player
     */
    public void takeTurn(Player player) {
        Card prev = discardPile.getLastCard();
        Card next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.printf("Player %s play %s\n", player.getName(), next);
    }

    /**
     * Method which start game until one of the players will have empty
     */
    public void playGame() {
        Player player = playerOne;

        while (!isDone()) {
            displayState();
            takeTurn(playerOne);
            player = nextPlayer(player);
        }

        playerOne.displayScore();
        playerTwo.displayScore();
    }
}
