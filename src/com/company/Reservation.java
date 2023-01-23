package com.company;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Reservation extends Request{

    private boolean isConfirmed;
    private boolean isPaid;
    private float advance;

    public void confirm() {
        if(this.isPaid){
            this.isConfirmed = true;
            System.out.println("Rezerwacja potwierdzona");
        } else {
            System.out.println("Rezerwacja musi byc opłacona.");
        }
    }

    /**
     *
     * @param selectedRooms
     * @param reservationDate
     * @param clientID
     * @param guestsAmount
     */
    public Reservation(List<Room> selectedRooms, LocalDate reservationDate, int clientID, int guestsAmount) {
        super(selectedRooms, reservationDate, clientID, guestsAmount);
        this.isConfirmed = false;
        this.isPaid = false;

        Iterator<Room> selectedRoomsIterator = selectedRooms.iterator();
        int price = 0;
        while(selectedRoomsIterator.hasNext()){
            price += selectedRoomsIterator.next().getPrice();
        }
        this.advance = (float) (price * 0.15);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rezerwacja na dzień: " + reservationDate);
        sb.append(" ID Klienta: " + clientID);
        sb.append(" Ilość gości: " + guestsAmount + "\n");
        sb.append("Wybrane pokoje: \n");
        for (int i = 0; i < selectedRooms.size(); i++) {
            sb.append(i + ". " + selectedRooms.get(i) + "\n");
        }
        sb.append("Oplacona? " + isPaid + "\n");
        sb.append("Potwierdzona? " + isConfirmed);
        return sb.toString();
    }

    public void pay() {
        this.isPaid = true;
    }




}
