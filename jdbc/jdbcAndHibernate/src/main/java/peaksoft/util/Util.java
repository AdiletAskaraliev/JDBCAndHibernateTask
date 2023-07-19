package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String userName = "postgres";
    private final static String password = "1234";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to db");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
