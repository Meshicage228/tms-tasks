package config;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
                            "******",
                            "******");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Statement createStatement() {
        try {
            return connection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
