package jrp.epos_ui.classes;

import static jrp.epos_ui.db_handler.Employees_DB_Handler.createEmployee;
import static jrp.epos_ui.db_handler.Employees_DB_Handler.updateCustomersServed;
import static jrp.epos_ui.db_handler.Employees_DB_Handler.updateEmployeeDetails;
import static jrp.epos_ui.db_handler.Employees_DB_Handler.deleteEmployeeInformtaion;
import static jrp.epos_ui.db_handler.Employees_DB_Handler.getValidEmployeeFromIdOnly;
import static jrp.epos_ui.db_handler.Transactions_DB_Handler.avarageSaleForEmployee;
import static jrp.epos_ui.db_handler.Transactions_DB_Handler.getAmountOfSalesForEmployee;
import static jrp.epos_ui.db_handler.Transactions_DB_Handler.maxSaleForEmployee;
import static jrp.epos_ui.db_handler.Transactions_DB_Handler.minSaleForEmployee;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class Employee {

    private String employee_id;
    private String employee_first_name;
    private String employee_last_name;
    private boolean employee_is_manager;
    private String employee_pin;
    private static int customers_served = 0;

//=====================GETTERS AND SETTERS======================================
    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_first_name() {
        return employee_first_name;
    }

    public void setEmployee_first_name(String employee_first_name) {
        this.employee_first_name = employee_first_name;
    }

    public String getEmployee_last_name() {
        return employee_last_name;
    }

    public void setEmployee_last_name(String employee_last_name) {
        this.employee_last_name = employee_last_name;
    }

    public boolean isEmployee_is_manager() {
        return employee_is_manager;
    }

    public void setEmployee_is_manager(boolean employee_is_manager) {
        this.employee_is_manager = employee_is_manager;
    }

    public String getEmployee_pin() {
        return employee_pin;
    }

    public void setEmployee_pin(String employee_pin) {
        this.employee_pin = employee_pin;
    }

    public int getCustomers_served() {
        return customers_served;
    }

    public void setCustomers_served(int customers_served) {
        this.customers_served = customers_served;
    }

    public static void customerServed() {
        customers_served = customers_served + 1;
        updateCustomersServed(Login.getCURRENT_USER());
    }
//==============================================================================

//============================CLASS=============================================
    public Employee() {

    }

    public Employee(String employeeId) {
        this.employee_id = employeeId;
    }

    public Employee(String employeeId, String employeePin) {
        this.employee_id = employeeId;
        this.employee_pin = employeePin;
    }

    public Employee(String employeeId, String firstName, String lastName, String pin, boolean isManager, int customersServed) {
        this.employee_id = employeeId;
        this.employee_first_name = firstName;
        this.employee_last_name = lastName;
        this.employee_pin = pin;
        this.employee_is_manager = isManager;
        this.customers_served = customersServed;
    }
//==============================================================================
    
//============================METHODS===========================================

    public boolean activateEmployee(Employee employee) {
        return createEmployee(employee);
    }

    public static int getAmountOfSales(String id){
        return getAmountOfSalesForEmployee(id);
    }
    
    public static double getAvarageSale(String id){
        return avarageSaleForEmployee(id);
    }
    
    public static double getMinSale(String id){
        return minSaleForEmployee(id);
    }
    
    public static double getMaxSale(String id){
        return maxSaleForEmployee(id);
    }
    
    public static Employee getValidEmployee(Employee employee){
        return getValidEmployeeFromIdOnly(employee);
    }
    
    public boolean update() {
        return updateEmployeeDetails(this);
    }

    public boolean delete() {

        return deleteEmployeeInformtaion(this);
    }
//==============================================================================
}
