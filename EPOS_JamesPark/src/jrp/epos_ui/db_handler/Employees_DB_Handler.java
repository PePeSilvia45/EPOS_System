package jrp.epos_ui.db_handler;

/**
 * @author James Park
 */

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;

import jrp.epos_ui.classes.Employee;
import static jrp.epos_ui.db_handler.DB_Handler.getConnection;

public class Employees_DB_Handler {

    public static Employee getValidEmployee(Employee employee) {
        //used to get a vaild employee from the database
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getEmployee = stmt.executeQuery(
                    "SELECT *"
                    + "FROM employees "
                    + "WHERE "
                    + "employee_id = '" + employee.getEmployee_id() + "' "
                    + "AND "
                    + "employee_pin = '" + employee.getEmployee_pin() + "'"
            );

            getEmployee.next();
            return new Employee(
                    String.format("%06d", getEmployee.getInt("employee_id")),
                    getEmployee.getString("employee_first_name"),
                    getEmployee.getString("employee_last_name"),
                    getEmployee.getString("employee_pin"),
                    getEmployee.getBoolean("employee_is_manager"),
                    getEmployee.getInt("customers_served")
            );

        } catch (SQLException e) {
            System.err.println("getValidEmployee : error");
            System.err.println("SQL Exception occured " + e);
        }

        return employee;
    }

    public static Employee getValidEmployeeFromIdOnly(Employee employee) {
        //used to get a valid employee if only the id is known (used by manager accounts)
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getEmployee = stmt.executeQuery(
                    "SELECT *"
                    + "FROM employees "
                    + "WHERE "
                    + "employee_id = '" + employee.getEmployee_id() + "' "
            );

            getEmployee.next();
            return new Employee(
                    String.format("%06d", getEmployee.getInt("employee_id")),
                    getEmployee.getString("employee_first_name"),
                    getEmployee.getString("employee_last_name"),
                    getEmployee.getString("employee_pin"),
                    getEmployee.getBoolean("employee_is_manager"),
                    getEmployee.getInt("customers_served")
            );

        } catch (SQLException e) {
            System.err.println("getValidEmployee : error");
            System.err.println("SQL Exception occured " + e);
        }

        return employee;
    }

    public static boolean checkIsEmployee(Employee employee) {
        //check if the employee being looked at is valid
        
        String id = employee.getEmployee_id();
        String pin = employee.getEmployee_pin();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getEmployee = stmt.executeQuery(
                    "SELECT * FROM employees "
                    + "WHERE "
                    + "employee_id = '" + id + "' "
                    + "AND "
                    + "employee_pin = '" + pin + "'"
            );
            while (getEmployee.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("checkIsEmployee : error");
            System.err.println("SQL Exception occured " + e);
            return false;
        }
        return false;
    }

    public static ArrayList<String> getAllEmployeesPreviews() {
        //gets employee previews to be used in combo boxes.
        
        ArrayList<String> employees = new ArrayList<String>();

        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet getEmployee = stmt.executeQuery(
                    "SELECT * FROM employees"
            );

            while (getEmployee.next()) {

                String idAndName = getEmployee.getString("employee_id") + ":"
                        + getEmployee.getString("employee_first_name").substring(0, 1) + "."
                        + getEmployee.getString("employee_last_name");
                employees.add(idAndName);
            }
        } catch (SQLException e) {
            System.err.println("getAllEmployeesPreviews : error");
            System.err.println("SQLException occured " + e);
        }
        return employees;
    }

    public static void updateCustomersServed(Employee employee) {
        //updates the amount uf customers the current user has served
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                    "UPDATE employees "
                    + "SET customers_served = " + employee.getCustomers_served()
                    + " WHERE employee_id = '" + employee.getEmployee_id() + "'"
            );

        } catch (SQLException e) {
            System.err.println("updateCustomersServed : error");
            System.err.println("SQL Exception occured " + e);
        }

    }

    //add update and delete empployees
    public static boolean createEmployee(Employee employee) {
        //creates a new employee
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(
                    "INSERT INTO employees "
                    + "(employee_first_name, employee_last_name, employee_is_manager, employee_pin) "
                    + "VALUES "
                    + "('" + employee.getEmployee_first_name() + "', '"
                    + employee.getEmployee_last_name() + "', "
                    + employee.isEmployee_is_manager() + ", '"
                    + employee.getEmployee_pin() + "')"
            );
            return true;
        } catch (SQLException e) {
            System.err.println("createEmployee : error");
            System.err.println("SQL Exception occured " + e);
            return false;
        }
    }

    public static boolean updateEmployeeDetails(Employee employee) {
        //updates an existing employee
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                    "UPDATE employees "
                    + "SET "
                    + "employee_first_name = '" + employee.getEmployee_first_name() + "', "
                    + "employee_last_name = '" + employee.getEmployee_last_name() + "', "
                    + "employee_is_manager = " + employee.isEmployee_is_manager() + ", "
                    + "employee_pin = '" + employee.getEmployee_pin() + "' "
                    + "WHERE employee_id = '" + employee.getEmployee_id() + "'"
            );
            return true;
        } catch (SQLException e) {
            System.err.println("UpdateEmployee : error");
            System.err.println("SQL Exception occured " + e);
            return false;
        }
    }

    public static boolean deleteEmployeeInformtaion(Employee employee) {
        //deletes an existing employee
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                    "DELETE FROM employees WHERE employee_id = '" + employee.getEmployee_id() + "'"
            );
            return true;

        } catch (SQLException e) {
            System.err.println("deleteEmployeeInformtaion : error");
            System.err.println("SQL Exception occured " + e);
            return false;
        }
    }
}