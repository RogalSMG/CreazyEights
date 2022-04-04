import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CardTable extends Canvas {

    private Image[][] images;
    private int cardWidth, cardHeight;

    /**
     * Tworzy obiekt klasy CardTable.
     * cardset to nazwa folderu, który zawiera grafiki przedstawiające karty.
     */
    public CardTable(String cardset) {
        setBackground(new Color(0x088A4B));

        // utwórz dwuwymiarową tablicę grafik kart
        images = new Image[14][4];
        String suits = "cdhs";

        for (int suit = 0; suit <= 3; suit++) {
            char c = suits.charAt(suit);

            for (int rank = 1; rank <= 13; rank++) {
                String s = String.format("%s/%02d%c.gif",
                        cardset, rank, c);
                images[rank][suit] = new ImageIcon(s).getImage();
            }
        }

        // pobierz szerokość i wysokość kart
        // i ustaw odpowiednie wymiary ramki
        cardWidth = images[1][1].getWidth(null);
        cardHeight = images[1][1].getHeight(null);

        // ustaw wymiary tymczasowo, aby otrzymać wstawki
        setTableSize(14, 4);
    }

    /**
     * Ustawia wielkość tablicy.
     * x oraz y są wyrażone w jednostkach szerokości i wysokości karty.
     */
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

    /**
     * Specjalna metoda wywoływana, gdy obiekt klasy Frame ma zostać narysowany.
     */
    public void paint(Graphics g) {
        for (int rank = 1; rank <= 13; rank++) {
            for (int suit = 0; suit <= 3; suit++) {
                double x = rank - 1 + suit / 5.0;
                double y = suit / 2.0;
                drawCard(g, rank, suit, x, y);
            }
        }
    }

    public static void main(String[] args) {
        // utwórz ramkę
        JFrame frame = new JFrame("Card Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // dodaj obiekt klasy CardTable
        String cardset = "C:\\Users\\danie\\Desktop\\Java przykłady\\r12\\cardset-oxymoron";
        Canvas canvas = new CardTable(cardset);
        frame.getContentPane().add(canvas);

        // pokaż ramkę
        frame.pack();
        frame.setVisible(true);
    }

}
