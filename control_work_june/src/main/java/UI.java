import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    static public void loop() {
        DB database = new DB();
        while (true) {
            System.out.println();
            System.out.println("1. Add animal");
            System.out.println("2. Show all animals");
            System.out.println("3. Show the list of commands that the animal performs");
            System.out.println("4. Teach the animal a new command");
            System.out.println("5. Remove the animal");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

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
                    Functions.createAnimal(database);
                    break;
                case 2:
                    Functions.showAll(database);
                    break;
                case 3:
                    Functions.showCommands(database);
                    break;
                case 4:
                    Functions.addCommand(database);
                    break;
                case 5:
                    Functions.removeAnimal(database);
                    break;
                case 6:
                    System.out.println("6");
                    System.exit(1);
            }
        }
    }
}
