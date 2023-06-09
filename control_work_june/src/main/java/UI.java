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
        Scanner choice = new Scanner(System.in);
        try {
            key = choice.nextInt();
        } catch (InputMismatchException error) {
            System.out.println("Wrong choice! Error:" + error);
            return;
        }

        switch (key) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                System.exit(1);
        }
    }
}
