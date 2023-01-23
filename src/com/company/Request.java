package com.company;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;

public class Request{

    protected java.util.List<Room> selectedRooms;
    protected LocalDate reservationDate;
    protected int clientID;
    protected int guestsAmount;

    /**
     *
     * @param selectedRooms
     * @param reservationDate
     * @param clientID
     * @param guestsAmount
     */
    public Request(java.util.List<Room> selectedRooms, LocalDate reservationDate, int clientID, int guestsAmount) {

        this.selectedRooms = selectedRooms;
        this.reservationDate = reservationDate;
        this.clientID = clientID;
        this.guestsAmount = guestsAmount;
    }


    public List<Room> getSelectedRooms() {
        return selectedRooms;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public int getClientID() {
        return clientID;
    }

    public int getGuestsAmount() {
        return guestsAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rezerwacja na dzień: " + reservationDate);
        sb.append(" ID Klienta: " + clientID);
        sb.append(" Ilość gości: " + guestsAmount + "\n");
        sb.append("Wybrane pokoje: \n");
        for (int i = 0; i < selectedRooms.size(); i++) {
            sb.append(i + ". " + selectedRooms.get(i) + "\n");
        }
        return sb.toString();
    }
}
