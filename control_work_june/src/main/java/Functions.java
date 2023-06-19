import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
    public static void showAll(DB db) {
        db.showAll();
    }

    public static void showCommands(DB db) {

    }

    public static void createAnimal(DB db) {
        int key;
        String name;
        Scanner choice = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("What animal do you want to create?");
            System.out.println("1. Cat");
            System.out.println("2. Dog");
            System.out.println("3. Hamster");
            try {
                System.out.print("Choice: ");
                key = choice.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("Wrong choice! Error:" + error);
                return;
            }

            switch (key) {
                case 1:
                    System.out.print("Input name: ");
                    name = str.next();
                    Animal cat = new Cat(name);
                    db.saveAnimal(cat);
                    return;
                case 2:
                    System.out.print("Input name: ");
                    name = str.next();
                    Animal dog = new Dog(name);
                    db.saveAnimal(dog);
                    return;
                case 3:
                    System.out.print("Input name: ");
                    name = str.next();
                    Animal hamster = new Hamster(name);
                    db.saveAnimal(hamster);
                    return;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    public static void removeAnimal(DB db) {
        int key, id;
        Scanner choice = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("What animal do you want to remove?");

            try {
                System.out.print("Choice: ");
                id = choice.nextInt();
                break;
            } catch (InputMismatchException error) {
                System.out.println("Wrong choice! Error:" + error);
                return;
            }
        }
        db.removeAnimal(id);
    }

    public static void addCommand(DB db) {
    }


}
