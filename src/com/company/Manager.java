package com.company;
import java.util.
import java.util.LinkedList;
import java.util.Scanner;

public class Manager {

    private java.util.List<Request> request;
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
        System.out.println("Podaj kryterium filtrowania\n 0 - po dacie \n 1 - po nazwisku klienta");
        int decision = sc.nextInt();
        //List<Request> temp = new LinkedList<Request>();
        if(decision == 0) {

        }
        return null;
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
