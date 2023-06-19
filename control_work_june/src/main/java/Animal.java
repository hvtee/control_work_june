import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected String name;
    protected String type;
    protected List<String> commands;

    public Animal(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void showCommands() {
        System.out.println("Список команд для животного " + name + ":");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }


}
