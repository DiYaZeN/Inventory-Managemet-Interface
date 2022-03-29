package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
public  class DatabaseConnector {

    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName="inventory";
        String databaseUser="root";
        String databasePassword="root";
        String url="jdbc:mysql://localhost/"+databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            ////////////////////////
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception exception){
            exception.printStackTrace();
            exception.getCause();
        }
        return databaseLink;
    }
}
