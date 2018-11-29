package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Client {



    private String name = "";
    private List<Reservation> Reservations = new ArrayList<>();


public void Pay() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("which reservation would you like to pay for ");
    int whichReservation = Integer.parseInt(reader.readLine());

    Reservations.get(whichReservation).setStatus("PAYED");

}

    public Client(String name) {
        this.name = name;
    }


    private void makeReservation(TravelAgency agency) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose which offer to reserve: ");
        int offerNumber = Integer.parseInt(reader.readLine());

        System.out.println("Choose Pay Date: ");
        String payDate = reader.readLine();

        Reservations.add(new Reservation("AWAITING PAYMENT", name, payDate, offerNumber, agency.getOfferList().get(offerNumber)));
    }


    public void CancelReservation() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which Reseration do you want to cancel: ");
        int index = Integer.parseInt(reader.readLine());

        Reservations.remove(index);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getReservations() {
        return Reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        Reservations = reservations;
    }



}
