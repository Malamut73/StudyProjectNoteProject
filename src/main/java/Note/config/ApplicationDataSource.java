package Note.config;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationDataSource {

    private static  final PGSimpleDataSource ds;
    private static final Connection connection;

    static {
        ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost:5432"});
        ds.setDatabaseName("NoteProject");
        ds.setUser("postgres");
        ds.setPassword("root");

        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }

}
