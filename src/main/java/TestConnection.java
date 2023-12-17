import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class TestConnection {

    public static Connection getConnect() {
        String dbURL = null;
        String dbUser = null;
        String dbPassword = null;

        FileInputStream fis;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);

            dbURL = properties.getProperty("dbURL");
            dbUser = properties.getProperty("USER_NAME");
            dbPassword = properties.getProperty("PASSWORD");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
