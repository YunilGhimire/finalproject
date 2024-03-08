package org.example.models;

public class Library {

    int bookId;
    Double bookPrice;
    String bookName;
    String buyerName;
    int quantity;



    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Library(int bookId, Double bookPrice, String bookName,String buyerName, int quantity) {
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.bookName = bookName;
        this.buyerName = buyerName;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void vat() {
        this.bookId = bookId;
        this.bookPrice = bookPrice;
        this.bookName = bookName;
        this.quantity = quantity;
        double price = bookPrice*quantity;
        double vat= price*0.13;
        double total = price+ vat;

        System.out.println("\nOrder details: \n");
        System.out.println("Name: "+bookName);
        System.out.println("Price: " + bookPrice);
        System.out.println("Items:"+quantity);
        System.out.println("Total with VAT:"+total);

        }
}
