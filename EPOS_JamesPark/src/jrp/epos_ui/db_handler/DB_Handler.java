package jrp.epos_ui.db_handler;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author James Park
 */

public class DB_Handler {
    
    private static Connection theConnection = null;
    private final static String DATAFOLDER = "DATA";
    private final static String DATAFILENAME = "epos_system.accdb";
    private final static String CONNECTIONSTRING = "jdbc:ucanaccess://"
            + DATAFOLDER
            + "\\"
            + DATAFILENAME;
    private static final String DATABASEDRIVERCLASS = "net.ucanaccess.jdbc.UcanaccessDriver";

//==============================================================================
    public static boolean databaseDriverExists() {

        boolean exists = false;

        try {
            Class.forName(DATABASEDRIVERCLASS);
            exists = true;
            System.out.println("ucanaccess drivers found");

        } catch (ClassNotFoundException e) {
            System.err.println("databaseDriverExists : error");
            System.err.println("Class Not Found Exception Occured " + e);
        }

        return exists;
    }

    public static Connection getConnection() {
        //Gets the active connection
        
        if (theConnection != null) {
            return theConnection;
        }

        return getNewConnection();
    }

    public static Connection getNewConnection() {
        //if no active connection this gets a new connection
        
        try {
            Class.forName(DATABASEDRIVERCLASS);
            theConnection = DriverManager.getConnection(CONNECTIONSTRING);

        } catch (SQLException e) {

            System.out.println("getNewConnection : error");
            System.out.println("SQLException occured " + e);

        } catch (ClassNotFoundException e) {

            System.out.println("getNewConnection : error");
            System.out.println("ClassNotFoundException occured " + e);
        }
        return theConnection;
    }
}