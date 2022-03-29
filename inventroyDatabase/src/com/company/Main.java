package com.company;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {

        int parse =0 ;
        int parse2 = 0;
        int manufactureID=0;
        ArrayList<Furniture> furniture = new ArrayList<Furniture>();
        ArrayList<Electronic> electronic = new ArrayList<Electronic>();



        boolean flag = true;
        System.out.println("Welcome to Inventory Management System");
        while(flag){
            System.out.println("\nPlease select the relevant option\n1.Add product to inventory\n2.View current inventory\n3.Delete object from inventory \n4.Update the furniture table\n5.Update the electronics table\n\n");
            System.out.println("\n Note: Manufacture_ID is unique id which automatically generates through every manufacturing event");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            scanner.nextLine();

            //Adding Products to inventory
            if(number == 1 ){
                System.out.println("\nPlease select the category\n1.Electronic\n2.Furniture\n\n");
                int second = scanner.nextInt();
                scanner.nextLine();
                if(second == 1){
                    System.out.println("What is the type:");
                    String type = scanner.nextLine();
                    System.out.println("Who is the manufacture:");
                    String manufactureName = scanner.nextLine();

                    var connectNow= new DatabaseConnector();
                    Connection connectDB = connectNow.getConnection();

                    String insertFields= "INSERT INTO electronics( manufacture_name,type) VALUES ('";

                    String insertValues= manufactureName+"','"+type+"');";
                    String insertToAdd= insertFields+insertValues;

                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(insertToAdd);

                        System.out.println("so far success");

                    }catch(Exception exception){
                    // exception.printStackTrace();
                    }

                    parse = parse + 1;
                }else if(second == 2){
                    System.out.println("What is the type:");
                    String type = scanner.nextLine();
                    System.out.println("Who is the manufacture:");
                    String manufactureName = scanner.nextLine();

                    var connectNow= new DatabaseConnector();
                    Connection connectDB = connectNow.getConnection();

                    String insertFields= "INSERT INTO furniture( manufacture_name,type) VALUES ('";

                    String insertValues= manufactureName+"','"+type+"');";
                    String insertToAdd= insertFields+insertValues;

                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(insertToAdd);

                        System.out.println("so far success");

                    }catch(Exception exception){
//            exception.printStackTrace();
                    }
                    Furniture name = new Furniture(type,manufactureName);
                    furniture.add(parse2, name);
                    parse2 = parse2 + 1;

                }else{
                    System.out.println("Invalid Input");
                }
            }else if(number == 2){
                System.out.println("Please select the category , 1 for electronics and 2 for furniture");
                int selection = scanner.nextInt();
                if(selection==1){
                    var connectNow1= new DatabaseConnector();
                    Connection connectDB1 = connectNow1.getConnection();
                    String insertFields= "SELECT * FROM  electronics;";

                    try{
                        Statement statement= connectDB1.createStatement();
                        ResultSet queryOutput = statement.executeQuery(insertFields);

                        while(queryOutput.next()){
                            Integer queryManufactureID=queryOutput.getInt("manufacture_id");
                            String queryManufactureName=queryOutput.getString("manufacture_name");
                            String queryType=queryOutput.getString("type");

                            System.out.println("manufacture_id = "+queryManufactureID+","+"manufacture_name = "+queryManufactureName+","+"type = "+queryType);

                        }


                    }catch (SQLException exception){
                        //
                    }

                //Viewing Products from inventory
                }else if(selection==2){
                    var connectNow1= new DatabaseConnector();
                    Connection connectDB1 = connectNow1.getConnection();
                    String insertFields= "SELECT * FROM  furniture;";

                    try{
                        Statement statement= connectDB1.createStatement();
                        ResultSet queryOutput = statement.executeQuery(insertFields);

                        while(queryOutput.next()){
                            Integer queryManufactureID=queryOutput.getInt("manufacture_id");
                            String queryManufactureName=queryOutput.getString("manufacture_name");
                            String queryType=queryOutput.getString("type");

                            System.out.println("manufacture_id = "+queryManufactureID+","+"manufacture_name = "+queryManufactureName+
                                    ","+"type = "+queryType);
                        }

                    }catch (SQLException exception){
                        //
                    }
                }else{
                    System.out.println("error enter a valid command");
                }


            //Updating the furniture table from inventory

            }else if (number == 4){
                System.out.println("Enter a valid manufacture id");
                manufactureID = scanner.nextInt();
                System.out.println("Enter 1 if you want to update type , Enter 2 if you want to update manufacture name");
                int number2 = scanner.nextInt();
                if(number2==1){
                    System.out.println("Enter type");
                    scanner.nextLine();
                    String manufactureName= scanner.nextLine();
                    var connectNow= new DatabaseConnector();
                    Connection  connectDB = connectNow.getConnection();
                    String updateFields= "UPDATE furniture SET manufacture_name ='";
                    String updateValues = manufactureName +"'"+" WHERE " + "manufacture_id ="+ manufactureID+";";
                    String updateDB=updateFields+updateValues;
                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(updateDB);

                    }catch(Exception exception){
                    //            exception.printStackTrace();
                    }


                }else if(number2==2){

                    System.out.println("Enter type");
                    scanner.nextLine();
                    String type= scanner.nextLine();
                    var connectNow= new DatabaseConnector();
                    Connection  connectDB = connectNow.getConnection();

                    String updateFields= "UPDATE furniture SET type ='";
                    String updateValues = type +"'"+" WHERE " + "manufacture_id ="+ manufactureID+";";
                    String updateDB=updateFields+updateValues;

                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(updateDB);
                    }catch(Exception exception){
                    //            exception.printStackTrace();
                    }


                }

            }

            //Updating the electronics table from inventory
            else if (number == 5){
                System.out.println("Enter a valid manufacture id");
                manufactureID = scanner.nextInt();
                System.out.println("Enter 1 if you want to update manufacture name, Enter 2 if you want to update type");
                int number2 = scanner.nextInt();

                if(number2==1){
                    System.out.println("Enter type");
                    scanner.nextLine();
                    String manufactureName= scanner.nextLine();
                    var connectNow= new DatabaseConnector();
                    Connection  connectDB = connectNow.getConnection();
                    String updateFields= "UPDATE electronics SET manufacture_name ='";
                    String updateValues = manufactureName +"'"+" WHERE " + "manufacture_id ="+ manufactureID+";";
                    String updateDB=updateFields+updateValues;
                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(updateDB);
                    }catch(Exception exception){
                    //  exception.printStackTrace();
                    }


                }else if(number2==2){

                    System.out.println("Enter type");
                    scanner.nextLine();
                    String type= scanner.nextLine();
                    var connectNow= new DatabaseConnector();
                    Connection  connectDB = connectNow.getConnection();

                    String updateFields= "UPDATE electronics SET type ='";
                    String updateValues = type +"'"+" WHERE " + "manufacture_id ="+ manufactureID+";";
                    String updateDB=updateFields+updateValues;

                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(updateDB);


                    }catch(Exception exception){

                    //            exception.printStackTrace();

                    }


                }


            }

            //Deleting object from inventory
                else if (number == 3){
                System.out.println("If you want to delete electronic press 1 and If you want to delete furniture press 2 ");
                int number4= scanner.nextInt();

                if(number4==1){
                    System.out.println("Enter a valid manufacture id");
                    manufactureID = scanner.nextInt();

                    String removeFields ="DELETE FROM electronics WHERE manufacture_id="+manufactureID+";" ;

                    var connectNow= new DatabaseConnector();
                    Connection  connectDB = connectNow.getConnection();

                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(removeFields);

                    }catch(Exception exception){

                    // exception.printStackTrace();

                    }


                } else if (number4==2) {
                    System.out.println("Enter a valid manufacture id");
                    manufactureID = scanner.nextInt();

                    String removeFields ="DELETE FROM furniture WHERE manufacture_id="+manufactureID+";" ;

                    var connectNow= new DatabaseConnector();
                    Connection  connectDB = connectNow.getConnection();

                    try{
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(removeFields);

                    }catch(Exception exception){
//            need to fixed
//            exception.printStackTrace();
////            exception.getCause();
                    }

                }
                else {
                    System.out.println("Enter a valid key");
                }
                }
            else{
                System.out.println("Please select a correct option\n");
            }
        }

    }
}
