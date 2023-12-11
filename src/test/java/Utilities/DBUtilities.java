package Utilities;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtilities {
    static Connection con;
    protected static Statement statement;

    @BeforeTest
    public static void DBConnection() {
        String url = "jdbc:mysql://localhost:3306/prestashop";
        String userName = "root";
        String password = "root1234";

        try {
            con = DriverManager.getConnection(url, userName, password);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            System.out.println("Connection Error = " + e.getMessage());
        }
    }



    @AfterTest
    public static void DBConnectionClose() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Connection.close error = " + e.getMessage());
        }


    }

    public static List<List<String>> getData(String query) {
        List<List<String>> returnList = new ArrayList<>();
        DBConnection();
        ResultSet rs;
        try {
            rs = statement.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getString(i));

                }
                returnList.add(row);

            }
        } catch (SQLException e) {
            System.out.println("Error on getData() = " + e.getMessage());
        }
        DBConnectionClose();

        return returnList;


    }

}
