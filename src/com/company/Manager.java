package com.company;
import java.time.LocalDate;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Manager {

    private java.util.List<Request> requests;
    private java.util.List<Reservation> reservations;

    public Manager() {
        // TODO - implement Manager.Manager
        throw new UnsupportedOperationException();
    }

    private Reservation searchReservation() {
        // TODO - implement Manager.searchReservation
        throw new UnsupportedOperationException();
    }

    private Request searchRequest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj kryterium filtrowania\n 0 - po dacie \n 1 - po ID klienta");
        int decision = sc.nextInt();
        List<Request> temp = new LinkedList<Request>();
        if(decision == 0) {
            System.out.println("Jaka data cie interesuje? Podaj w formacie YYYY-MM-DD");
            String dataString = sc.nextLine();
            LocalDate filterDate = LocalDate.parse(dataString);
            for(Request req : requests) {
                if(req.getReservationDate().equals(filterDate)) {
                    temp.add(req);
                }
            }
        } else if(decision == 1) {
            System.out.println("Podaj ID klienta:");
            int clientId = sc.nextInt();
            for(Request req : requests) {
                if(req.getClientID() == clientId) {
                    temp.add(req);
                }
            }

        }
        System.out.println(temp);
        System.out.println("Ktora rezerwacja cie interesuje? Podaj indeks.");
        decision = sc.nextInt();
        return temp.get(decision);
    }

    void confirmRequest() {
        Request base = searchRequest();
        reservations.add(new Reservation(base.getSelectedRooms(), base.getReservationDate(),
                base.getClientID(), base.getGuestsAmount()));
    }

    void confirmReservation() {
        // TODO - implement Manager.confirmReservation
        throw new UnsupportedOperationException();
    }

    void cancelReservation() {
        // TODO - implement Manager.cancelReservation
        throw new UnsupportedOperationException();
    }

    void addRequest() {
        // TODO - implement Manager.addRequest
        throw new UnsupportedOperationException();
    }

}
