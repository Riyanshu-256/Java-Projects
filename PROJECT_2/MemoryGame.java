package PROJECT_2;


    // A simple Java program to demonstrate 
// Memory Game
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MemoryGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cards = new ArrayList<>();

        // Add 4 pairs of cards
        cards.add("A"); cards.add("A");
        cards.add("B"); cards.add("B");
        cards.add("C"); cards.add("C");
        cards.add("D"); cards.add("D");

        Collections.shuffle(cards);

        String[] board = new String[cards.size()];
        Arrays.fill(board, " ");
        boolean[] flipped = new boolean[cards.size()];
        int pairsFound = 0;

        System.out.println("Welcome to the Memory Game!");
        while (pairsFound < 4) {
            printBoard(board);

            int firstIndex = getCardIndex(scanner, board, flipped, 
            "Enter index of first card to flip:");
            board[firstIndex] = cards.get(firstIndex);
            flipped[firstIndex] = true;
            printBoard(board);

            int secondIndex = getCardIndex(scanner, board, flipped, 
            "Enter index of second card to flip:");
            board[secondIndex] = cards.get(secondIndex);
            flipped[secondIndex] = true;
            printBoard(board);

            if (cards.get(firstIndex).equals(cards.get(secondIndex))) {
                System.out.println("You found a pair!");
                pairsFound++;
            } else {
                System.out.println("Sorry, those cards don't match.");
                board[firstIndex] = " ";
                board[secondIndex] = " ";
                flipped[firstIndex] = false;
                flipped[secondIndex] = false;
            }
        }

        System.out.println("Congratulations, you won!");
        scanner.close();
    }

    public static int getCardIndex(Scanner scanner, String[] board, 
    boolean[] flipped, String prompt) {
        int index;
        while (true) {
            System.out.println(prompt);
            index = scanner.nextInt();
            if (index < 0 || index >= board.length) {
                System.out.println("Invalid index, try again.");
            } else if (flipped[index]) {
                System.out.println("Card already flipped, try again.");
            } else {
                break;
            }
        }
        return index;
    }

    public static void printBoard(String[] board) {
        for (String value : board) {
            System.out.print("| " + value + " ");
        }
        System.out.println("|");
    }
}