package dbManegment;

import java.sql.*;

public class DbManagement {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
        String connectionPath = "jdbc:mysql://" + Constants.DB_HOST + ":" + Constants.DB_PORT + "/" + Constants.DB_NAME;
        dbConnection = DriverManager.getConnection(connectionPath, Constants.DB_USER, Constants.DB_PASS);
        return dbConnection;
    }
}



