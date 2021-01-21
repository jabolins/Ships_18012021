package dbManegment;

public class Constants {
    // datu bāzes vieta un piekļuves
    public static final String DB_HOST = "127.0.0.1";
    public static final String DB_PORT = "3306";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "Rootroot1$";
    public static final String DB_NAME = "ships_20210117";

    // tabula "lietotāji" ar laukiem
    public static final String TABLE_USERS = "users";

    public static final String USER_ID = "idUser";
    public static final String USER_NAME = "name";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "eMail";

    //tabula "rezultati" ar laukiem
    public static final String TABLE_RESULTS = "results";
    public static final String RESULT_ID = "idResult";
    public static final String RESULT_USER = "userName";
    public static final String RESULT_RESULT = "result";
    public static final String RESULT_GAMECODE = "gameCode";

}
