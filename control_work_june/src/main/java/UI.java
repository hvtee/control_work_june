import java.io.IOError;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    static public void loop() {
        System.out.println("1. Add animal");
        System.out.println("2. Show the list of commands that the animal performs");
        System.out.println("3. Teach the animal a new command");
        System.out.println("4. Remove the animal");
        System.out.println("5. Exit");
        System.out.println("Choice: ");

        int key;
        Scanner scanner = new Scanner(System.in);
        try {
            key = scanner.nextInt();
        } catch (InputMismatchException error) {
            System.out.println("Wrong choice! Error:" + error);
            return;
        }

        if (key == 1) {
            System.out.println("1");
            return;
        } else if (key == 2) {
            System.out.println("2");
            return;
        } else if (key == 3) {
            System.out.println("3");
            return;
        } else if (key == 4) {
            System.out.println("4");
            return;
        } else if (key == 5) {
            System.out.println("5");
            System.exit(1);
        } else {
            System.out.println("Wrong choice!");
        }
    }
}
