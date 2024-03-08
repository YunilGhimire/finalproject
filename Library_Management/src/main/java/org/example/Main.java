package org.example;

import org.example.models.Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String LIBRARY_TABLE = "LIBRARY";

    public static void main(String[] args) {

        Library l1 = new Library(200, 320.00, "Helen Keller", "Hari", 2);
        String URL = "jdbc:sqlite:LibraryDB.db";
        String createStatementSql = "CREATE TABLE IF NOT EXISTS " + LIBRARY_TABLE + "(id integer PRIMARY KEY NOT NULL, " +
                "price Double, " +
                "bookName text, " +
                "buyerName text," +
                "quantity integer)";
        String insertStatementSQL = "INSERT INTO " + LIBRARY_TABLE + "(price,bookName,buyerName,quantity) values(?,?,?,?)";
        System.out.println(insertStatementSQL);
        String selectStatement = "Select * from " + LIBRARY_TABLE;


        try {
                Connection connection = DriverManager.getConnection(URL);
                System.out.println("Connected");
                //statement
                Statement statement = connection.createStatement();
                statement.execute(createStatementSql);
                System.out.println("Table Created");

            PreparedStatement psm = connection.prepareStatement(insertStatementSQL);
            psm.setDouble(1, l1.getBookPrice());
            psm.setString(2, l1.getBookName());
            psm.setString(3, l1.getBuyerName());
            psm.setFloat(4, l1.getQuantity());
            psm.execute();
            System.out.println("Data Added");

            ResultSet rs = statement.executeQuery(selectStatement);
            List<Library> libraryList = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                Double price = rs.getDouble("price");
                String bookName = rs.getString("bookName");
                String buyerName = rs.getString("buyerName");
                int quantity = rs.getInt("quantity");

                Library L = new Library(id, price, bookName, buyerName, quantity);
                libraryList.add(L);
            }
            System.out.println(libraryList.size());
            for (Library s : libraryList) {
                System.out.println(s.getBookPrice());
                System.out.println(s.getBookName());
                System.out.println(s.getBuyerName());
                System.out.println(s.getQuantity());
            }
        } catch (Exception e) {
            System.out.println("Cannot connect to DB");
            e.printStackTrace();

        }
        l1.vat();
    }

}