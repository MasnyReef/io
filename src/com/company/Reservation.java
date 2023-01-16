package com.company;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Reservation extends Request{

    private boolean isConfirmed;
    private boolean isPaid;
    private float advance;

    public void confirm() {
        if(this.isPaid){
            this.isConfirmed = true;
        }
    }

    /**
     *
     * @param selectedRooms
     * @param reservationDate
     * @param clientID
     * @param guestsAmount
     */
    public Reservation(List<Room> selectedRooms, Date reservationDate, int clientID, int guestsAmount) {
        super(selectedRooms, reservationDate, clientID, guestsAmount);
        this.isConfirmed = false;
        this.isPaid = false;

        //ToDo zaliczka
        Iterator<Room> selectedRoomsIterator = selectedRooms.iterator();
        int price = 0;
        while(selectedRoomsIterator.hasNext()){
            price += selectedRoomsIterator.next().getPrice();
        }
        this.advance = (float) (price * 0.15);
    }

//    public Reservation(Request request) {
//        return;
//    }


}
