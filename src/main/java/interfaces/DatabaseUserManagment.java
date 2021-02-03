package interfaces;

import java.sql.SQLException;

public interface DatabaseUserManagment {
   boolean isUsernameUnique(String username) throws SQLException;
    void userRegistration(String username, String password, String email);
    boolean checkUserLogin(String username, String password) throws SQLException;

}
