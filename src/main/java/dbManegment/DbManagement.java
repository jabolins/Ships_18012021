package dbManegment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManagement {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
        String connectionPath= "jdbc:mysql://"+ Constants.DB_HOST+ ":"+ Constants.DB_PORT+"/"+ Constants.DB_NAME;
        dbConnection= DriverManager.getConnection(connectionPath,Constants.DB_USER,Constants.DB_PASS);
        return dbConnection;
    } // metode ceļam līdz datu bāzei

    public void userRegistration(String name, String password, String eMail){
        String input = "INSERT INTO "+ Constants.TABLE_USERS+ "("+ Constants.USER_NAME+ ","
                + Constants.USER_PASSWORD+ ","+ Constants.USER_EMAIL+ ")"+ " VALUES(?,?,?)";
        try {
            PreparedStatement inputValues= getDbConnection().prepareStatement(input);
            inputValues.setString(1, name);
            inputValues.setString(2,password);
            inputValues.setString(3, eMail);

            inputValues.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
