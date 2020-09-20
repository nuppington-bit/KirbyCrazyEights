class Card {
  public int number;
  public Suit mySuit;

  public enum Suit {
    Hearts, Diamonds, Spades, Clubs
  }

  public Card(int _number, Suit _suit) {
    number = _number;
    mySuit = _suit;
  }

  public String getCardName() {
    return Main.cardIdToName.get(number) + " of " + mySuit;
  }
}
