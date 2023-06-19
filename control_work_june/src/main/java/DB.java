import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
