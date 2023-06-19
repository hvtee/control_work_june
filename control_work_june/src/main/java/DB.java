import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DB {
    static Connection connection;

    DB() {
        connection = connectDB();
    }

    private Connection connectDB() {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }

        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Успешное подключение к базе данных.");
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return conn;
    }

    public void showAll() {
        String sql = "SELECT * FROM animals";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            int i = 1;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String command = resultSet.getString("command");
                System.out.println("Id:" + i);
                System.out.println("Name: " + name);
                System.out.println("Type: " + type);
                System.out.println("Command: " + command);
                System.out.println("------------------------");
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAnimal(Animal animal) {
        String sql = "INSERT INTO animals (name, type, command) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, animal.name);
            statement.setString(2, animal.type);
            String commandsString = String.join(", ", animal.commands);
            statement.setString(3, commandsString);
            statement.executeUpdate();
            System.out.println("Запись успешно добавлена в таблицу animals.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeAnimal(int id) {
        String sql = "DELETE FROM animals WHERE id = " + id;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
            System.out.println("Запись успешно deleted from таблицу animals.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
