import java.util.*;

class Game {
  public static Stack<Card> deck = new Stack<Card>();
  public static Stack<Card> pile = new Stack<Card>();
  public static List<Player> players;
  int nCardsPerPlayer = 7;

  public Game() {
    players = new ArrayList<Player>();
    players.add(new HumanPlayer("Kirby"));
    players.add(new AIPlayer("Waddle Dee"));
    createDeck();
    shuffleDeck();
    handOutCards();
    pile.push(deck.pop());
    while (true) {
      for (Player P : players) {
        P.doTurn();
        if (P.cardsInHand.size() == 0) {
          Main.ClearConsole();
          System.out.println(P.name + " won!");
          new Game();
        }
      }
    }

  }

  public void createDeck() {
    for (int i = 2; i < 14; i++) {

      deck.push(new Card(i, Card.Suit.Hearts));
      deck.push(new Card(i, Card.Suit.Diamonds));
      deck.push(new Card(i, Card.Suit.Clubs));
      deck.push(new Card(i, Card.Suit.Spades));
    }
  }

  public void shuffleDeck() {
    for (int i = 0; i < deck.size(); i++) {
      int r = Main.rand.nextInt(deck.size());// generating random number from 0 to length of the deck.
      Card temp = deck.get(r);
      deck.set(r, deck.get(i));
      deck.set(i, temp);

    }
  }

  void handOutCards() {
    for (Player P : players) {
      for (int i = 0; i < nCardsPerPlayer; i++) {
        Card topCard = deck.pop();
        P.cardsInHand.add(i, topCard);
      }
    }
  }
}