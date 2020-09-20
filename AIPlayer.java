public class AIPlayer extends Player {
  public AIPlayer(String name) {
    super(name);
  }

  public void doTurn() {
    super.doTurn();
    playCard();
    System.out.println(name + " has " + cardsInHand.size() + " cards left");
    Main.sleep(3000);
  }

  void playCard() {
    for (Card c : cardsInHand) {
      if (tryPlayCard(c)) {
        System.out.println(name + " played " + c.getCardName());
        return;
      }
    }
    System.out.println(name + " just drew a new card");
    getCardFromDeck();
  }

}