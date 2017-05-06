/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Date;

/**
 *
 * @author Thành
 */
public class Book {
    String SKU;
    String Name;
    String Gendre;
    String Publisher;
    String PublishedDay;
    String Author;
    String Price;
    int Total;

    public String getSKU() {
        return SKU;
    }

    public String getName() {
        return Name;
    }

    public String getGendre() {
        return Gendre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public String getPublishedDay() {
        return PublishedDay;
    }

    public String getAuthor() {
        return Author;
    }
    
    public String getPrice() {
        return Price;
    }
    
    public int getTotal() {
        return Total;
    }
    
    public Book(String SKU, String Name, String Gendre, String Publisher, String PublishedDay, String Author) {
        this.SKU = SKU;
        this.Name = Name;
        this.Gendre = Gendre;
        this.Publisher = Publisher;
        this.PublishedDay = PublishedDay;
        this.Author = Author;
    }

    public Book(String SKU, String Name, String Gendre, String Publisher, String PublishedDay, String Author, String Price, int Total) {
        this.SKU = SKU;
        this.Name = Name;
        this.Gendre = Gendre;
        this.Publisher = Publisher;
        this.PublishedDay = PublishedDay;
        this.Author = Author;
        this.Price = Price;
        this.Total = Total;
    }

    public Book() {
    }
    
}
