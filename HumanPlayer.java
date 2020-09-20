public class HumanPlayer extends Player {
  public HumanPlayer(String name) {
    super(name);
  }

  public void doTurn() {
    super.doTurn();
    organiseHand();
    displayHand();
    System.out.println("Kirby, select your card or enter n to draw a new card.");
    pickCard();

  }

  public void displayHand() {
    for (int i = 0; i < cardsInHand.size(); i++) {
      Card c = cardsInHand.get(i);
      System.out.println("[" + (i + 1) + "]" + c.getCardName());
    }
  }

  public void pickCard() {
    try {
      String input = Main.input.nextLine();
      if (input.equals("reset")) {
        // main.reset();
        return;
      }
      if (input.equals("n")) { // Can't compare String objects with "=="
        getCardFromDeck();
        return;
      }
      int i = Integer.parseInt(input);
      i--;
      Card c = cardsInHand.get(i);
      if (!tryPlayCard(c)) {
        System.out.println("You can't play that card :(");
        Main.sleep(1000);
        doTurn();
      }
    } catch (Exception e) {
      System.out.println("Nope");
      Main.sleep(1000);
      doTurn();

    }
  }

  private void swapCard(int j) {
    Card temp = cardsInHand.get(j);
    cardsInHand.set(j, cardsInHand.get(j + 1));
    cardsInHand.set(j + 1, temp);
  }

  public void organiseHand() {
    int n = cardsInHand.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        if (cardsInHand.get(i).number > cardsInHand.get(j).number) {
          swapCard(j);
        }
      }
    }
  }
}
