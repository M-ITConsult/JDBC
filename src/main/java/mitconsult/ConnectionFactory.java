package mitconsult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  abstract class ConnectionFactory {

    private final static String URL = "jdbc:postgresql://localhost:5432/CarnetAdresse";
    private final static String USERNAME = "postgres";

    private final static String PASSWORD = "test1234";


    public static Connection CreateConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME,PASSWORD);
    }
}
