package dbManegment;

import interfaces.DatabaseUserManagment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUser extends DbManagement implements DatabaseUserManagment {

    public void userRegistration(String name, String password, String eMail) {
        String input = "INSERT INTO " + Constants.TABLE_USERS + "(" + Constants.USER_NAME + ","
                + Constants.USER_PASSWORD + "," + Constants.USER_EMAIL + ")" + " VALUES(?,?,?)";
        try {
            PreparedStatement inputValues = getDbConnection().prepareStatement(input);
            inputValues.setString(1, name);
            inputValues.setString(2, password);
            inputValues.setString(3, eMail);

            inputValues.executeUpdate();
            dbConnection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean isUsernameUnique(String userName) throws SQLException {
        String query = "SELECT * FROM " + Constants.TABLE_USERS + " WHERE " + Constants.USER_NAME + " = " + "'" + userName + "'";
        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                if (userName.equals(result.getString(Constants.USER_NAME))) {
                    dbConnection.close();
                    return true; // ja atradām kādu sakritību, izbeidzam pārbaudi
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbConnection.close();
        return false;
    } // metode lai pārbaudītu vai šāds vārds jau datu bāzē nav reģistrēts. true- reģistrēts, false- nav reģistrēts

    public boolean checkUserLogin(String userName, String password) throws SQLException {
        String query = "SELECT * FROM " + Constants.TABLE_USERS + " WHERE " + Constants.USER_NAME + " =? AND " +
                Constants.USER_PASSWORD + " =? ";
        try {
            PreparedStatement values = getDbConnection().prepareStatement(query);
            values.setString(1, userName);
            values.setString(2, password);
            ResultSet result = values.executeQuery();

            int count = 0;
            while (result.next()) {
                count++;
            }
            if (count > 0) {
                dbConnection.close();
                return true; // ja atrasto daudzums vairāk kā 0 - atgriežam vērtību true un pārtraucam darbu
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dbConnection.close();
        return false; // ja nekas netika atrsts, atgriežam vērtību false
    } // metode lai pārbudītu reģistrēta lietotāja vārdu un paroli
}
