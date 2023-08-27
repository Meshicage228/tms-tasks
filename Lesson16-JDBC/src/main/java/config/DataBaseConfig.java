package config;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection connection() {
        try {
            return DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/postgres",
                            "postgres",
                            "28072004");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
