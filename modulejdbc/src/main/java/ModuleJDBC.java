import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class ModuleJDBC {


    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "pass";
    private static final File file = new File("/home/artem/IdeaProjects/modulejdbc/info.csv");

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public static void createDbUserTable() {
        String removeTableSQL = "DROP TABLE IF EXISTS csvdb";
        String createTableSQL = "CREATE TABLE IF NOT EXISTS csvdb("
                + "ID INT(2) NOT NULL,"
                + "Class VARCHAR(20) NOT NULL,"
                + "Count_of_pupils INT (20) NOT NULL,"
                + "Prepod VARCHAR(20) NOT NULL,"
                + "PRIMARY KEY (ID) "
                + ")";
        try (Connection dbConnection = getConnection();
             Statement statement = dbConnection.createStatement()) {
            statement.execute(removeTableSQL);
            statement.execute(createTableSQL);
            System.out.println("Table \"csvdb\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readAllLines() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            int n = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(",");
                addLine(n, lines[0], lines[1]);
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void addLine(int n, String second, String third) {
        try (Connection dbConnection = getConnection();
             PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO csvdb" +
                     "(ID, Class, Count_of_pupils, Prepod ) VALUES (?,?,?,?)");) {
            int i = 1;
            statement.setInt(i++, n);
            statement.setString(i++, createClass(n));
            statement.setString(i++, second);
            statement.setString(i, third);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String createClass(int num) {
        int ch = (int) Math.random() * 2;
        char[] chars = {'a', 'b', 'c'};
        String string = (String.valueOf(num) + String.valueOf(chars[ch]));
        return string;
    }


}
