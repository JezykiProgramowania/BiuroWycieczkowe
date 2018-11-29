package com.company;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Offer {

    private String name = "";
    private String date = "";
    private String description = "";
    private String destination = "";
    private String from = "";
    public int buys = 0;

    private int price = 0;
    private int availableTickets = 0;

    private Map<String, String> fromTo = new TreeMap<>();



    public Offer(String name, String date, int price, int availableTickets, String destination, String from, String description) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.availableTickets = availableTickets;
        this.destination = destination;
        this.from = from;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Map<String, String> getFromTo() {
        return fromTo;
    }

    public void setFromTo(Map<String, String> fromTo) {
        this.fromTo = fromTo;
    }


}
