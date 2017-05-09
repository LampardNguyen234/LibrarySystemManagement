/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thành
 */
public class DatabaseConnection {
    public static String password = "minhhao0948441310";
//    public static String password ="123456";
    public static String userName = "root";

    /*Taking database name as an input and connecting to that database*/
    public static Connection getMySQLConnection(String dbName) throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    /* Default Connection (Connect to datalibrary database*/
    public static Connection getMySQLConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";
        String dbName = "datalibrary";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
            String userName, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useSSL=false";

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

}
