package com.company;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws IOException {

        TravelAgency Agency = new TravelAgency("1. Luxurious Travel Agency XXX");
        Agency.getOfferList().add(new Offer("Super Ekstra Oferta", "04:12:2018",
                200, 30, "Hawaje", "Wroclaw", "It's an offer aimed at small families"));

        Agency.getOfferList().add(new Offer("NOWA OFERTA", "04:12:2018",
                200, 40, "JAPONIA", "Wroclaw", "A 4 days rest at a 4-star Hotel"));

        Interface inter = new Interface();
        inter.ShowMenu();
        inter.loadClients("clients.txt", Agency.getClientList());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        Collections.sort(Agency.getOfferList(), new CompareOffers());
        System.out.println("posortowane oferty: " + Agency.getOfferList().get(0).getAvailableTickets());
        do {
            line = reader.readLine();
            switch (line) {

                case "1": { inter.ShowOffer(Agency.getOfferList()); inter.ShowMenu(); break; }

                case "2": { Agency.makeOffer(); inter.ShowMenu(); break; }
                case "3": { Agency.updateOffer(); inter.ShowMenu(); break; }
                case "4": { inter.ReservationMenu(Agency); inter.ShowMenu(); break; }
                case "5": { Agency.ShowStatistics(); break; }
            }
        }while (line != "0");
    }

    public static class CompareOffers implements Comparator<Offer> {
        @Override
        public int compare(Offer off1, Offer off2) {
            return -(off1.buys - off2.buys);
        }
    }
}
