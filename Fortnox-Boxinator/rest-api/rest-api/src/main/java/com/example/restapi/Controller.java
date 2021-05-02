package com.example.restapi;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public ArrayList<Table> getReq() {
        System.out.println("Get request made!");
        ArrayList<Table> tbl = getDB();
        return tbl;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postReq(@RequestBody Table payload) {
        System.out.println("Post request made!");
        insertToDB(payload.getName(), payload.getWeight(), payload.getColor(), payload.getCountry());
    }

    // db functions
    public static void insertToDB(String name, String weight, String color, String country) {
        try {
            String query = "INSERT INTO tblbox (name, weight, color, country) VALUES(";
            String end = ")";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/boxinator", "root", "root");
            Statement stm = con.createStatement();
            System.out.println(query + name + "," + weight + "," + color + "," + country + end);
            stm.execute(query + "'" + name + "'" + "," + "'" + weight + "'" + "," + "'" + color + "'" + "," + "'"
                    + country + "'" + end);
            System.out.println("Insert done!");
        } catch (Exception e) {
            System.out.println("err: " + e);
        }
    }

    public static ArrayList<Table> getDB() {
        try {
            String query = "SELECT * FROM tblbox";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/boxinator", "root", "root");
            java.sql.Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            ArrayList<Table> table = new ArrayList<Table>();
            while (rs.next()) {   
                Table row = new Table(rs.getString(1), rs.getString(2), rs.getString(3), calcShipcost(rs.getString(2), rs.getString(4)));
                table.add(row);
            }
            return table;
        } catch (Exception e) {
            System.out.println("err: " + e);
        }
        return null;
    }

    public static String calcShipcost(String weigth, String country) {
        double shipcost = 0;
        if(Integer.parseInt(weigth)>0) {
        switch (country) {
            case "Sweden":
                shipcost = Integer.parseInt(weigth) * 1.3;
                break;
            case "China":
                shipcost = Integer.parseInt(weigth) * 4;
                break;
            case "Brazil":
                shipcost = Integer.parseInt(weigth) * 8.6;
                break;
            case "Australia":
                shipcost = Integer.parseInt(weigth) * 7.2;
                break;
            default:
            	return "Something went wrong, negative weigth or invalide Country!";
        }
        return Double.toString(shipcost) + " SEK";
        }
        else {
        	return "Something went wrong, negative weigth or invalide Country!";
        }
    }

}