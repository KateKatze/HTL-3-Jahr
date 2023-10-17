package at.htlpinkafeld.companymanager.dao;

import org.hsqldb.persist.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
    // singleton setup
    // Volatile! Essentially, volatile is used to indicate that a variable's value will be modified by different threads.
    //Declaring a volatile Java variable means:
    //The value of this variable will never be cached thread-locally: all reads and writes will go straight to "main memory";
    //Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself.
    private volatile static ConnectionManager connectionManager = null;
    private static Connection connection = null;

    private static final String DB_URL = "jdbc:hsqldb:file:../../_DATABASE/CompanyDB/company";
    private static final String DB_USER = "db";
    private static final String DB_PASSWORD = "";

    // By adding the synchronized keyword to getInstance(), we force every thread to wait its turn before it can enter the method. That is, no two threads may enter the method at the same time.
    // Returns the instance - Lazy Installation
    public static synchronized ConnectionManager getInstance() throws SQLException {
        if (connectionManager == null)
            connectionManager = new ConnectionManager();
        return connectionManager;
    }

    // Driver loading
    private void loadDriver(){
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
            throw new RuntimeException("Problems with loading of HSQLDB driver.");
        }
    }

    // Calling the driver
    private ConnectionManager() {
        loadDriver();
    }

    // Make up the connection
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }

    // Close the connection
    public static void closeConnection() {
        if (connectionManager != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, "DB is still connected.", e);
            }
        }
    }
}
