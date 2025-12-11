import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame {

    // -----------------------------
    // Card Class
    // -----------------------------
    static class Card {
        private String rank;
        private String suit;
        private int value;

        private static final String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        private static final String[] SUITS = {
                "Clubs", "Diamonds", "Hearts", "Spades"
        };

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
            this.value = getRankValue(rank);
        }

        private int getRankValue(String rank) {
            switch (rank) {
                case "2":  return 2;
                case "3":  return 3;
                case "4":  return 4;
                case "5":  return 5;
                case "6":  return 6;
                case "7":  return 7;
                case "8":  return 8;
                case "9":  return 9;
                case "10": return 10;
                case "Jack": return 11;
                case "Queen": return 12;
                case "King": return 13;
                case "Ace":  return 14;
                default: return 0;
            }
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return rank + " of " + suit;
        }

        public static String[] getAllRanks() {
            return RANKS;
        }

        public static String[] getAllSuits() {
            return SUITS;
        }
    }

    // -----------------------------
    // Deck Class
    // -----------------------------
    static class Deck {

        private List<Card> cards = new ArrayList<>();

        public Deck() {
            // Build the 52-card deck
            for (String suit : Card.getAllSuits()) {
                for (String rank : Card.getAllRanks()) {
                    cards.add(new Card(rank, suit));
                }
            }
        }

        public void shuffle() {
            Collections.shuffle(cards);
        }

        public Card dealCard() {
            return cards.remove(cards.size() - 1);
        }

        public List<Card> dealHand(int numCards) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < numCards; i++) {
                hand.add(dealCard());
            }
            return hand;
        }
    }

    // -----------------------------
    // Player Class
    // -----------------------------
    static class Player {
        private String name;
        private List<Card> hand;

        public Player(String name) {
            this.name = name;
            this.hand = new ArrayList<>();
        }

        public void receiveHand(List<Card> newHand) {
            hand = newHand;
        }

        public void showHand() {
            System.out.println("\n" + name + "'s Hand:");
            for (Card c : hand) {
                System.out.println("   " + c);
            }
        }

        public int handStrength() {
            int total = 0;
            for (Card c : hand) {
                total += c.getValue();
            }
            return total;
        }

        public String getName() {
            return name;
        }
    }

    // -----------------------------
    // Game Class
    // -----------------------------
    static class Game {
        private int numPlayers;
        private int cardsPerHand;
        private List<Player> players = new ArrayList<>();
        private Deck deck;

        public Game(int numPlayers, int cardsPerHand) {
            this.numPlayers = numPlayers;
            this.cardsPerHand = cardsPerHand;
            deck = new Deck();

            for (int i = 0; i < numPlayers; i++) {
                players.add(new Player("Player " + (i + 1)));
            }
        }

        public void dealHands() {
            deck.shuffle();
            for (Player p : players) {
                p.receiveHand(deck.dealHand(cardsPerHand));
            }
        }

        public void displayHands() {
            System.out.println("\n--- DEALT HANDS ---");
            for (Player p : players) {
                p.showHand();
            }
        }

        public void determineWinner() {
            Player winner = players.get(0);
            int highest = winner.handStrength();

            for (Player p : players) {
                int score = p.handStrength();
                if (score > highest) {
                    highest = score;
                    winner = p;
                }
            }

            System.out.println("\n--- WINNER ---");
            System.out.println(winner.getName() + " wins with a score of " + highest + "!");
        }

        public void play() {
            System.out.println("Dealing cards...\n");
            dealHands();
            displayHands();
            determineWinner();
        }
    }

    // -----------------------------
    // Main Method
    // -----------------------------
    public static void main(String[] args) {
        // 5 players, 5 cards each (can change to 6 or 7 if desired)
        Game game = new Game(5, 5);
        game.play();
    }
}
