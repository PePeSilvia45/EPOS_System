package jrp.epos_ui.classes;

import java.util.ArrayList;
import javax.swing.JComboBox;

import static jrp.epos_ui.db_handler.Employees_DB_Handler.checkIsEmployee;
import static jrp.epos_ui.db_handler.Employees_DB_Handler.getAllEmployeesPreviews;
import static jrp.epos_ui.db_handler.Employees_DB_Handler.getValidEmployee;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class Login {
    
    //stores the current user
    private static Employee CURRENT_USER;

    public static Employee getCURRENT_USER() {
        return CURRENT_USER;
    }

    public static void setCURRENT_USER(Employee CURRENT_USER) {
        Login.CURRENT_USER = CURRENT_USER;
    }    
    
    public static boolean Login(String employeeId, String pin) {
        try {
            CURRENT_USER = new Employee(employeeId, pin);
            
            if (checkIsEmployee(CURRENT_USER)) {
                CURRENT_USER = getValidEmployee(CURRENT_USER);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }        
    }
    
    //populate the combo boxes
    public static void populateComboBoxes(JComboBox cmboForUpdate, JComboBox cmboForDelete) {
        ArrayList<String> employees = getAllEmployeesPreviews();

        employees.stream().map(employee -> {
            cmboForUpdate.addItem(employee);
            return employee;
        }).forEachOrdered(employee -> {
            cmboForDelete.addItem(employee);
        });
    }
    
    //update the comboboxes with any new or updated information
    public static void updateComboBoxes(JComboBox cmboForUpdate, JComboBox cmboForDelete) {
        ArrayList<String> employees = getAllEmployeesPreviews();

        for (int i = cmboForDelete.getItemCount() - 1; i > 0; i--) {
            cmboForUpdate.removeItemAt(i);
            cmboForDelete.removeItemAt(i);
        }
        employees.stream().map(employee -> {
            cmboForUpdate.addItem(employee);
            return employee;
        }).forEachOrdered(employee -> {
            cmboForDelete.addItem(employee);
        });
    }
}