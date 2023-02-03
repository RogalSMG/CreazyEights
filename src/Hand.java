public class Hand extends CardCollection {

    /**
     * Basic constructor
     * @param label name of this hand
     */
    public Hand(String label) {
        super(label);
    }

    /**
     * Method display name of Hand and cards inside
     */
    public void display() {
        System.out.println(getLabel() + ": ");
        for (int i = 0; i < size(); i++) {
            System.out.println(getCard(i));
        }
        System.out.println();
    }
}
