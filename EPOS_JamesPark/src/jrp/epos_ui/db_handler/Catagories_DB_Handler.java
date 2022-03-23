package jrp.epos_ui.db_handler;

/**
 * @author James Park
 */

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jrp.epos_ui.classes.Catagory;

import static jrp.epos_ui.db_handler.DB_Handler.getConnection;

public class Catagories_DB_Handler {

    public boolean isCatagoryValid(Catagory catagory) {
        //used to check if the catagory been looked for is a valid catagory
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getCatagory = stmt.executeQuery(
                    "SELECT * FROM catagories "
                    + "WHERE "
                    + "catagory_id = " + catagory.getCatagory_id()
            );
            while (getCatagory.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("isCatagoryValid : error");
            System.err.println("SQL Exception occured " + e);
        }
        return false;
    }

    public Catagory getValidCatagory(Catagory catagory) {
        //when a valid catagory is found this method gets it from the database
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getCatagory = stmt.executeQuery(
                    "SELECT * FROM catagories "
                    + "WHERE "
                    + "catagory_id = " + catagory.getCatagory_id()
            );
            getCatagory.next();
            Catagory validCatagory = new Catagory(
                    String.format("%03d", getCatagory.getInt("catagory_id")),
                    getCatagory.getString("catagory_name")
            );
            return validCatagory;

        } catch (SQLException e) {
            System.err.println("getValidCatagory : error");
            System.err.println("SQL Exception occured " + e);
        }

        return null;
    }

    public static ArrayList<Catagory> getAllCatagories() {
        //Gets all the catagories
        
        ArrayList<Catagory> catagories = new ArrayList<Catagory>();

        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getCatagory = stmt.executeQuery(
                    "SELECT * FROM catagories"
            );

            while (getCatagory.next()) {
                Catagory catagory = new Catagory(
                        String.format("%03d", getCatagory.getInt("catagory_id")),
                        getCatagory.getString("catagory_name")
                );
                catagories.add(catagory);
            }

        } catch (SQLException e) {
            System.err.println("getAllCatagories : error");
            System.err.println("SQL Exception occured " + e);
        }

        return catagories;
    }
}
