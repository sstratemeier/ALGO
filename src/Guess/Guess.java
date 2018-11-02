package Guess;

import java.util.Scanner;

public class Guess {
    public static void guess(int min, int max, Scanner scanner) {
        System.out.println("I guess " + (min + max) / 2);
        System.out.println("Is it higher or correct? (yes/no/correct)");
        String input = scanner.nextLine();
        if ("yes".startsWith(input)) {
            guess((min + max + 1) / 2, max, scanner);
        } else if ("no".startsWith(input)) {
            guess(min,  (min + max + 1) / 2, scanner);
        } else if ("correct".startsWith(input)) {
            System.out.println("Woop!Woop!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 100;

        guess(min, max, scanner);

        boolean running = false;
        while (running) {
            System.out.println("I guess " + (min + max) / 2);
            System.out.println("Is it higher or correct? (yes/no/correct)");
            while (running && scanner.hasNext()) {
                String input = scanner.nextLine();
                if("yes".startsWith(input)) {
                    min = (min + max + 1) / 2;
                } else if ("no".startsWith(input)) {
                    max = (min + max + 1) / 2;
                } else if ("correct".startsWith(input)) {
                    System.out.println("Woop!Woop!");
                    running = false;
                }
                if(running) {
                    System.out.println("I guess " + (min+max)/2);
                    System.out.println("Is it higher or correct? (yes/no/correct)");
                }
            }
        }
    }
}
