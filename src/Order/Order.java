/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kguna
 */
public class Order {
    String id;
    String date;
    String customerId;

    public Order() {
        date = new SimpleDateFormat("yyyy/MM/mm").format(new Date());
    }

    public Order(String id, String date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + ", customerId=" + customerId + '}';
    }
}
