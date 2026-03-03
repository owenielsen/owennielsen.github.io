import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
            if (cards.isEmpty()) {
                return null;
            }
            return cards.remove(cards.size() - 1);
        }

        public List<Card> dealHand(int numCards) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < numCards; i++) {
                Card c = dealCard();
                if (c == null) break;
                hand.add(c);
            }
            return hand;
        }

        public boolean isEmpty() {
            return cards.isEmpty();
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

        public void addCard(Card c) {
            if (c != null) {
                hand.add(c);
            }
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
        private Scanner sc;

        public Game(List<String> names, int cardsPerHand, Scanner sc) {
            this.numPlayers = names.size();
            this.cardsPerHand = cardsPerHand;
            this.sc = sc;
            deck = new Deck();

            for (int i = 0; i < numPlayers; i++) {
                players.add(new Player(names.get(i)));
            }
        }

        public void dealHands() {
            deck = new Deck(); // fresh deck each round
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
            System.out.println("\n--- NEW ROUND ---");
            System.out.println("Dealing cards...\n");
            dealHands();
            displayHands();

            // offer each player additional cards
            for (Player p : players) {
                boolean another = true;
                while (another && !deck.isEmpty()) {
                    String ans = getYesNo("" + p.getName() + ", do you want another card? (yes/no): ");
                    if (ans.equals("yes")) {
                        Card card = deck.dealCard();
                        p.addCard(card);
                        System.out.println(p.getName() + " received " + card);
                    } else {
                        another = false;
                    }
                }
                if (deck.isEmpty()) {
                    System.out.println("Deck is empty. No more cards can be drawn.");
                }
            }

            displayHands();
            determineWinner();
        }

        // helper inside Game class to reuse scanner
        private String getYesNo(String prompt) {
            while (true) {
                System.out.print(prompt);
                String line = sc.nextLine().trim().toLowerCase();
                if (line.startsWith("y")) return "yes";
                if (line.startsWith("n")) return "no";
                System.out.println("Please answer 'yes' or 'no'.");
            }
        }
    }

    // -----------------------------
    // utility input helpers
    // -----------------------------
    private static int getIntInput(Scanner sc, String prompt, int min, int max) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = sc.nextInt();
                sc.nextLine(); // consume newline
                if ((min <= value && value <= max) || (min == -1 && max == -1)) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (java.util.InputMismatchException ime) {
                System.out.println("That's not a valid number. Try again.");
                sc.nextLine(); // discard invalid token
            }
        }
    }

    private static String getStringInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    // -----------------------------
    // Main Method
    // -----------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Card Game!");

        int numPlayers = getIntInput(sc, "How many players? (2-6): ", 2, 6);
        int cardsPerHand = getIntInput(sc, "How many cards per hand? (1-7): ", 1, 7);

        List<String> names = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            String name = getStringInput(sc, "Enter name for player " + (i + 1) + ": ");
            if (name.trim().isEmpty()) {
                name = "Player " + (i + 1);
            }
            names.add(name);
        }

        Game game = new Game(names, cardsPerHand, sc);
        boolean keepPlaying = true;
        while (keepPlaying) {
            game.play();
            String again = getStringInput(sc, "Play another round? (yes/no): ").trim().toLowerCase();
            keepPlaying = again.startsWith("y");
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
