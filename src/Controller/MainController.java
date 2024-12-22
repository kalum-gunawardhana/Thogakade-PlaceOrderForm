/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Customer.Customer;
import DBConnection.DBConnection;
import Item.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kguna
 */
public class MainController {
    //------------------generating order ID-------------------------------------
    public static String generateOrderId() throws ClassNotFoundException, SQLException {
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = stm.executeQuery("select id from orders");

        String newId = null;
        if (rst.next()) {
            newId = rst.getString("id");
        }
        while (rst.next()) {
            newId = rst.getString("id");
            rst.next();
        }
        if (newId == null) {
            return "D001";
        } else {
            int id = Integer.parseInt(newId.substring(1, 4));
            return String.format("D%03d", id + 1);
        }
    }

    //--------------------------update combo for customers----------------------
    public static ArrayList updateCombo() throws ClassNotFoundException, SQLException {
        ArrayList cusArrayList = new ArrayList();

        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = stm.executeQuery("select id from customer");

        while (rst.next()) {
            cusArrayList.add(rst.getString("id"));
        }
        
        return cusArrayList;
    }

    //--------------------------update combo for item---------------------------
    public static ArrayList<Item> updateItemCombo() throws ClassNotFoundException, SQLException {
        ArrayList<Item> itemArrayList = new ArrayList<>();

        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = stm.executeQuery("select code, description, unitPrice, qtyOnHand from item");

        while (rst.next()) {
            String id = rst.getString("code");
            String description = rst.getString("description");
            double unitPrice = rst.getDouble("unitPrice");
            int qtyOnHand = rst.getInt("qtyOnHand");

            Item item = new Item(id, description, unitPrice, qtyOnHand);
            itemArrayList.add(item);
        }
        return itemArrayList;
    }

    //------------------------------set item text field-------------------------
    public static ArrayList<Item> setItemTextField(String selectedItem) throws ClassNotFoundException, SQLException {
        ArrayList<Item> selectItemsArrayList = new ArrayList<>();

        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = stm.executeQuery("select description, unitPrice, qtyOnHand from item where code='" + selectedItem + "'");

        if (rst.next()) {
            selectItemsArrayList.add(new Item(null, rst.getString("description"), rst.getDouble("unitPrice"), rst.getInt("qtyOnHand")));
        }

        return selectItemsArrayList;
    }
    
    public static ArrayList<Customer> setCustomerTextField(String selectedCustomer) throws ClassNotFoundException, SQLException{
        ArrayList<Customer> selectCustomerArrayList=new ArrayList<>();
        
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = stm.executeQuery("select name from customer where id='" + selectedCustomer + "'");
        
        if (rst.next()) {
            selectCustomerArrayList.add(new Customer(null,rst.getString("name"),null,null));
        }
        
        return selectCustomerArrayList;
    }
}
