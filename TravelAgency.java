package com.company;

import com.company.Offer;
import com.company.Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;


public class TravelAgency {



    private String name = "";
    private List<Offer> OfferList = new ArrayList<>();
    private List<Client> ClientList = new ArrayList<>();



    public void ShowStatistics() {
        int number = 0;
        Collections.sort(OfferList, new Main.CompareOffers());
        for(Offer off : OfferList) {
            System.out.println(number + ".\n" + off.getName());off.getName();
            number++;
        }
    }


    public void ShowReservations() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which Client's reservation do you want to SHOW");
        int index = Integer.parseInt(reader.readLine());


            if(ClientList.get(index).getReservations().isEmpty()) System.out.println("NO RESERVATIONS FOR THIS CLIENT WERE FOUND");
           for(Reservation res: ClientList.get(index).getReservations()) {

            try {
                System.out.println("|||||||||||||||||||||||||||||||||||||||||");
                System.out.println("OWNER OF THE RESERVATION: " + res.getOwner());
                System.out.println("RESERVATION STATUS: " + res.getStatus());
                System.out.println("Payment due Date: " + res.getPayDate());
                System.out.println("|||||||||||||||||||||||||||||||||||||||||");
                System.out.println("|||||||||||||||||||||||||||||||||||||||||");
                System.out.println("TITLE: " + res.getReservedOffer().getName());
                System.out.println("OFFER DESTINATION: " + res.getReservedOffer().getDestination());
                System.out.println("DATE OF DEPARTURE: " + res.getReservedOffer().getDate());
                System.out.println("PRICE: " + res.getReservedOffer().getPrice());
                System.out.println("AVAILABLE TICKTS:" + res.getReservedOffer().getAvailableTickets());
                System.out.println("DESCRIPTION: " + res.getReservedOffer().getDescription() + "\n\n");

            }
            catch (IndexOutOfBoundsException e){
                System.out.println("NO SUCH RESERVATION WAS FOUND");
            }

           }






    }

    public void cancelReservation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which Client's reservation do you want to cancel");
        int index = Integer.parseInt(reader.readLine());

        System.out.println("Which reservation do you want to cancel");
        int reserv = Integer.parseInt(reader.readLine());

        ClientList.get(index).getReservations().remove(reserv);
        int newTickets = OfferList.get(index).getAvailableTickets() + 1;
        OfferList.get(index).setAvailableTickets(newTickets);
        OfferList.get(index).buys --;
    }


    public void makeReservation() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which Client do you want to make a Reservation for ");
        int index = Integer.parseInt(reader.readLine());

        System.out.println("Choose which offer you want to make the reservation for: ");
        int offerNumber = Integer.parseInt(reader.readLine());
        if(OfferList.get(offerNumber).getAvailableTickets() == 0) {
            System.out.println("WE ARE SORRY. THERE ARE NO AVAILABLE TICKETS!");
            return;
        }
        else {
            System.out.println("Choose Pay Date: ");
            String payDate = reader.readLine();

            ClientList.get(index).getReservations().add(new Reservation("AWAITING PAYMENT", ClientList.get(index).getName(), payDate, offerNumber, getOfferList().get(offerNumber)));
            int newTickets = OfferList.get(offerNumber).getAvailableTickets() -1;
            OfferList.get(offerNumber).setAvailableTickets(newTickets);
            OfferList.get(offerNumber).buys ++;
        }

    }
  //  Reservation(String status, String owner, String payDate)
   // String name, String date, int cost, int availableTickets, String destination, String from
    public void makeOffer() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("ENTER TITLE: ");
        String name = reader.readLine();

        System.out.println("ENTER DATE: ");
        String date = reader.readLine();

        System.out.println("ENTER PRICE: ");
        int price = Integer.parseInt(reader.readLine());

        System.out.println("ENTER ACAILABLE TICKETS: ");
        int availableTickets = Integer.parseInt(reader.readLine());

        System.out.println("ENTER DESTINATION: ");
        String destination = reader.readLine();

        System.out.println("ENTER PLACE OF DEPARTURE: ");
        String from = reader.readLine();

        System.out.println("ENTER PLACE OF DEPARTURE: ");
        String description = reader.readLine();

        OfferList.add(new Offer(name, date, price, availableTickets, destination, from, description));
    }

    public void updateOffer() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which offer would you like to update: ");
        int index = Integer.parseInt(reader.readLine());

        System.out.println("What INFO do you want to edit: \n");
        System.out.println("1. NAME");
        System.out.println("2. DATE ");
        System.out.println("3. PRICE ");
        System.out.println("4. TICKETS AVAILABLE");
        System.out.println("5. DESTINATION");
        System.out.println("6. PLACE OF DEPARTURE");
        System.out.println("7. DESCRIPTION ");
        String choice = reader.readLine();



        switch (choice) {
            case "1": {
                System.out.println("ENTER NEW NAME: ");
                String newName = reader.readLine();
                OfferList.get(index).setName(newName); break;
            }

            case "2": {
                System.out.println("ENTER NEW DATE: ");
                String newDate = reader.readLine();
                OfferList.get(index).setName(newDate); break;
            }
            case "3": {
                System.out.println("ENTER NEW PRICE: ");
                String newPrice = reader.readLine();
                OfferList.get(index).setName(newPrice); break;
            }
            case "4": {
                System.out.println("ENTER NEW TICKETS AVAILABLE: ");
                String newAvailableTickets = reader.readLine();
                OfferList.get(index).setName(newAvailableTickets); break;
            }
            case "5": {
                System.out.println("ENTER NEW DESTINATION: ");
                String newDestination = reader.readLine();
                OfferList.get(index).setName(newDestination); break;
            }
            case "6": {
                System.out.println("ENTER NEW PLACE OF DEPARTURE: ");
                String newFrom = reader.readLine();
                OfferList.get(index).setName(newFrom); break;
            }
            case "7": {
                System.out.println("ENTER NEW DESCRIPTION: ");
                String newName = reader.readLine();
                OfferList.get(index).setName(newName); break;
            }
        }

    }


    public TravelAgency(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Offer> getOfferList() {
        return OfferList;
    }

    public void setOfferList(List<Offer> offerList) {
        OfferList = offerList;
    }

    public List<Client> getClientList() {
        return ClientList;
    }

    public void setClientList(List<Client> clientList) {
        ClientList = clientList;
    }

}
