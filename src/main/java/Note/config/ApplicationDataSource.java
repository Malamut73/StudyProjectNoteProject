package Note.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplicationDataSource {

    private static final ApplicationDataSource SINGLETON_DATA_SOURCES = new ApplicationDataSource();

    private ApplicationDataSource(){}

    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "lemoor@mail.ru";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/noteproject";

    private static Connection connection;
    Statement statement;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            System.out.println("connected");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

}
