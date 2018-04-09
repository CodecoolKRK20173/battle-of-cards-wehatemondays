public class Card {


    private int rank;
    private int suit;
    private Pile containingPile;

    public Card(SuitEnum suit, CardEnum rank) {
        this.suit = suit.getSuit();
        this.rank = rank.getRank();
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    
    public Pile getContainingPile() {
        return containingPile;
    }

    public static boolean isOppositeColor(Card card1, Card card2) {
        if (card1.isRed() && !card2.isRed()) return true;
        else if (!card1.isRed() && card2.isRed()) return true;
        else return false;
    }

    public static boolean isSameSuit(Card card1, Card card2) {
        return card1.getSuit() == card2.getSuit();
    }
}