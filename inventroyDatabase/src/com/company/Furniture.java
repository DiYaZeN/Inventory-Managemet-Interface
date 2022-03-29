package com.company;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Furniture extends Inventory {

    public String type;
    public String manufacture;

    public Furniture(String type, String manufacture) {
        this.type = type;
        this.manufacture = manufacture;
    }

    public String getType() {
        return type;
    }


    public String getManufacture() {
        return manufacture;
    }

}