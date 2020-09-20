import java.util.*;

public class Player {
  public List<Card> cardsInHand = new ArrayList<Card>();
  String name;

  public Player(String _name) {
    name = _name;
  }

  public void doTurn() {
    Main.ClearConsole();
    System.out.println("It's " + name + "'s turn! Good luck!");
    System.out.print("Top card: ");
    System.out.println(Game.pile.peek().getCardName());
  }

  public boolean tryPlayCard(Card c) {
    Card topCard = Game.pile.peek();
    Boolean canPlay = false;
    if (c.number == 8 || topCard.number == c.number || topCard.mySuit == c.mySuit) {
      canPlay = true;
    }
    if (canPlay) {
      cardsInHand.remove(c);
      Game.pile.push(c);
    }
    return canPlay;
  }

  void getCardFromDeck() {
    Card c = Game.deck.pop();
    cardsInHand.add(c);
  }
}