package com.company;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class Interface {

    public void ShowMenu() {
        System.out.println("||||||||||||WELCOME TO THE BIGGEST ONLINE TRAVELLING SERVICE IN THE WORLD|||||||||||||||||||");
        System.out.println("1. Show available offers");
        System.out.println("2. Add new Offer");
        System.out.println("3. Update Offer");
        System.out.println("4. Reservation");
        System.out.println("5. Show Statistics");
    }

    public void ReservationMenu(TravelAgency agency) throws IOException {
        System.out.println("1. Show reservations");
        System.out.println("2. Make a reservation");
        System.out.println("3. Cancel a reservation");
        System.out.println("4. Pay");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = reader.readLine();
        switch(choice) {
            case "1": { agency.ShowReservations(); break; }
            case "2": { agency.makeReservation(); break; }
            case "3": { agency.cancelReservation(); break; }
            case "4": { agency.getClientList().get(0).Pay(); break; }
        }

    }


    public void ShowOffer(List<Offer> OfferList) {

        System.out.println("THIS IS OUR AVAILABLE OFFERS\n");

        for(Offer off : OfferList) {

            System.out.println("TITLE: " + off.getName());
            System.out.println("OFFER DESTINATION: " + off.getDestination());
            System.out.println("DATE OF DEPARTURE: " + off.getDate());
            System.out.println("PRICE: " + off.getPrice());
            System.out.println("AVAILABLE TICKTS:" + off.getAvailableTickets());
            System.out.println("DESCRIPTION: " + off.getDescription() + "\n\n");
        }


    }

    public void loadClients(String fileName, List<Client> ClientList) throws FileNotFoundException {

        File file = new File(fileName);

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            ClientList.add(new Client(sc.nextLine()));
        }
    }
}
