package dbManegment;

import java.sql.*;

public class DbManagement {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
        String connectionPath = "jdbc:mysql://" + Constants.DB_HOST + ":" + Constants.DB_PORT + "/" + Constants.DB_NAME;
        dbConnection = DriverManager.getConnection(connectionPath, Constants.DB_USER, Constants.DB_PASS);
        return dbConnection;
    } // metode ceļam līdz datu bāzei

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
    } // metode lai pievienotu jaunu spēlētāju

    public boolean checkUserName(String userName) throws SQLException {
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
    } // metode lai pārbaudītu vai šāds vārds jau datu bāzē nav reģistrēts

    public boolean checkUser(String userName, String password) throws SQLException {
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



