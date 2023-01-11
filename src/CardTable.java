import javax.swing.*;
import java.awt.*;

public class CardTable extends Canvas {

    private final Image[][] images;
    private final int cardWidth;
    private final int cardHeight;
    private final Image cardRevers;

    /**
     * @param cardSet path to folder with images
     */
    public CardTable(String cardSet) {
        setBackground(new Color(0x088A4B));

        // set image for cards reverse
        cardRevers = new ImageIcon(cardSet + "/back001.gif").getImage();

        // set two dimension array
        images = new Image[14][4];
        String suits = "cdhs";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 13; rank++) {
                String s = String.format("%s/%02d%c.gif",
                        cardSet, rank, c);
                images[rank][suit] = new ImageIcon(s).getImage();
            }
        }

        // set frame size
        cardWidth = images[1][0].getWidth(null);
        cardHeight = images[1][0].getHeight(null);
        setTableSize(14, 4);
    }

    /**
     * Main function inside <code>CardTable</code> class
     *
     * @param args cmd array :java Main
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String cardSet = "E:\\Developer Start\\Java Projekty\\CardGames\\images";
        Canvas canvas = new CardTable(cardSet);
        frame.getContentPane().add(canvas); // frame.add(canvas) also works

        // show frame
        frame.pack();
        frame.setVisible(true);
    }

    public void setTableSize(double x, double y) {
        setSize((int) (x * cardWidth),
                (int) (y * cardHeight));
    }

    /**
     * Rysuje kartę w miejscu określonym przez współrzędne.
     * x oraz y są wyrażone w jednostkach szerokości i wysokości karty.
     */
    public void drawCard(Graphics g, int rank, int suit, double x, double y) {
        Image image = images[rank][suit];
        g.drawImage(image,
                (int) (x * cardWidth),
                (int) (y * cardHeight),
                null);

    }

    public void drawCardRevers(Graphics g, double x, double y) {
        x = x * cardWidth;
        y = y * cardHeight;
        g.drawImage(cardRevers, (int) x, (int) y, null);
    }

    public void paint(Graphics g) {
//        standardLayOut(g);
        pasjans(g);
//        drawCardRevers(g, 1 ,1);
    }

    public void pasjans(Graphics g) {
        int rank = 0;
        int suit = 0;
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11 - i; j++) {
                if (rank < 13) {
                    rank++;
                } else {
                    rank = 1;
                    suit++;
                }

                double x = i + i * 0.1;
                double y = 1 + j / 5.0;
                if (j < 10 - i) {
                    drawCardRevers(g, x, y);
                } else {
                    drawCard(g, rank, suit, x, y);
                }
            }
        }
    }

    public void standardLayOut(Graphics g) {
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank - 1 + suit / 5.0;
                double y = suit / 2.0;
                drawCard(g, rank, suit, x, y);
            }
        }
    }

}
