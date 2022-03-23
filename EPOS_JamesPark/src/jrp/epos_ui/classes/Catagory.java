package jrp.epos_ui.classes;

import java.util.ArrayList;

import static jrp.epos_ui.db_handler.Catagories_DB_Handler.getAllCatagories;

/**
 * @author James Park
 */
@SuppressWarnings("unchecked")
public class Catagory {

    private String catagory_id;
    private String catagory_name;

//===============GETTTERS AND SETTERS===========================================
    public String getCatagory_id() {
        return catagory_id;
    }

    public void setCatagory_id(String catagory_id) {
        this.catagory_id = catagory_id;
    }

    public String getCatagory_name() {
        return catagory_name;
    }

    public void setCatagory_name(String catagory_name) {
        this.catagory_name = catagory_name;
    }
//==============================================================================
    
//===========================CLASS==============================================    
    public Catagory() {

    }

    public Catagory(String catagory_id) {
        this.catagory_id = catagory_id;
    }

    public Catagory(String catagory_id, String catagory_name) {
        this.catagory_id = catagory_id;
        this.catagory_name = catagory_name;
    }
//==============================================================================
    
//===========================METHODS============================================
    public static ArrayList<Catagory> getAll(){
        
        return getAllCatagories();
    }
//==============================================================================
}
